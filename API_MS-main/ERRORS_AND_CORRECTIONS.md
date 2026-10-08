# Errors and Corrections Report

This document lists every meaningful mistake identified in the original
**API & Micro Services Lab Manual (2026-27, AUS RECORD)** during the
analysis-and-build pass, and the correction applied in this project
collection. It also notes deliberate structural decisions made when the
manual's own section breakdown didn't cleanly match the requested
per-sub-question folder layout.

## Environment note (read first)

This container has **no network access** and **no Maven binary
installed**, so `mvn clean test` / `mvn clean package` could not actually
be executed against Maven Central to produce a verified build log for any
of the 40 projects. Verification here was done by rigorous **static
review** instead:
- Every `.java` file was checked for balanced braces, a package
  declaration matching its folder path, and a type name matching its
  file name (149/149 passed).
- Every `pom.xml`, `logback-spring.xml`, `sample-request.xml`, and
  `.xsd` file was parsed as XML and confirmed well-formed (43/43 passed).
- All 40 sub-projects were manually reviewed for correct imports,
  annotation usage, Spring Boot 3.3.4 / Jakarta EE namespace
  compatibility (`jakarta.persistence.*`, not the legacy
  `javax.persistence.*`), and consistent dependency sets.

This is **not** a substitute for an actual `mvn` build, and it cannot
catch every possible issue (e.g. a typo'd Spring Data method name that
doesn't match JPA's derived-query grammar). If you run this on a machine
with Maven and internet access, running `mvn clean test` in each folder
is still recommended and should be quick given the code's small size.

---

## Corrections Table

| Experiment | Sub-question | Original Problem | Correction Made | Reason |
|---|---|---|---|---|
| 2 | a (Explore Spring Modules) | Manual's dependency list for this sub-question only included `spring-boot-starter-jdbc`, `h2`, and `test` — but the sub-question's own goal is to demonstrate the **Core, Data Access, and Web** modules together, and a Web module example is expected. | Added `spring-boot-starter-web` and a `ModuleInfoController` REST endpoint. | Without the Web starter, no `DispatcherServlet`/MVC module can be demonstrated, and the described learning objective (explore Web module) can't be met. |
| 3 | c (Logback Logging) | `logback-spring.xml` contained a malformed XML element: `<appender-ref ref="ref="CONSOLE" /\>` — a duplicated, incorrectly escaped `ref` attribute. This is not well-formed XML. | Fixed to `<appender-ref ref="CONSOLE" />`. | An appender-ref with a duplicated/malformed `ref` attribute causes Logback's XML parser to fail configuration, which by default prevents the Spring Boot application from starting at all. |
| 4 | b, c, d, e (AOP — Student/StudentService, Aspect, Apply Advice, Test) | The manual's `pom.xml` for the AOP experiment only lists `spring-boot-starter-web`. It never lists `spring-boot-starter-aop`, despite the sample code importing `org.aspectj.lang.annotation.Aspect` and `@Before`. | Added `spring-boot-starter-aop` to the pom for every AOP sub-project (b onward). | Without `spring-boot-starter-aop` (which brings in AspectJ weaver + Spring AOP autoconfiguration), the `@Aspect`/`@Before` code shown in the manual cannot even compile (`org.aspectj.lang.annotation` would not resolve on the classpath), let alone run. |
| 5 | f (CRUD Test) | The manual's test code called `userRepository.findById(1L)` and `userRepository.deleteById(2L)` with **hardcoded IDs**, assuming H2's identity counter always starts at exactly 1 for a fresh run. | Rewrote the test to capture and reuse the actual IDs returned by `save()`, added `deleteAll()` at the start for a clean baseline, and added real JUnit assertions (the manual's version only printed to console with no pass/fail checks). | Hardcoded IDs are fragile — if any other bean or test in the same Spring test context inserts rows into `users` first, or if the identity sequence doesn't reset, the hardcoded IDs won't match real rows and the test fails or silently does the wrong thing. Using the real returned IDs is deterministic and portable. Adding assertions turns a "prints output" demo into an actual verifiable test, as required. |
| 6 | a (Repository Pagination) | The manual's index-table title for this sub-question ("Create a repository interface with pagination methods") did not match the heading that appeared with the actual code block in the manual body, which was mislabeled "Test CRUD operations" (an apparent copy-paste leftover from Experiment 5). | Used the correct title (matching the index table and the actual pagination-repository content) for the folder/README. | The mismatched heading in the manual body would confuse anyone cross-referencing the index table against the actual content; the code itself (a plain `JpaRepository` extension) was correct and unaffected. |
| 6 | c (Test Pagination) | The manual's pagination test only printed results to the console with no JUnit assertions, and appeared to depend on a separate test class/method for its seed data with no guaranteed run order between independent JUnit test classes. | Added a `@BeforeEach` that seeds its own 5 users, and added real assertions on total elements, total pages, and sort order. | JUnit does not guarantee execution order between independent test classes. Making each test self-seeding removes that hidden dependency and makes the test deterministic and independently runnable. |
| 6 | d (Custom Query Sorting) | Same issue as above — relied on data possibly seeded elsewhere, with no assertions. | Same fix: self-contained `@BeforeEach` seeding + real assertions on the descending-sorted result. | Same reasoning as above — determinism and genuine verification. |
| 7 | c/d (REST Controller CRUD) | The manual's `UserController` used `.orElseThrow(() -> new RuntimeException("User not found"))` for missing-user lookups in `getUserById`, `updateUser`, and `deleteUser`. An unhandled `RuntimeException` in a Spring MVC controller method results in an **HTTP 500 Internal Server Error**, not a `404 Not Found`. | Rewrote all three methods to return `ResponseEntity.notFound().build()` (HTTP 404) when the user doesn't exist, and to use `ResponseEntity<T>` consistently with explicit status codes (`200`, `201`, `404`) throughout. | A missing resource is a client-side condition (bad ID) that REST conventions represent as `404`, not a server fault (`500`). The original code would mislead API consumers into thinking the server was broken when they simply requested an ID that doesn't exist. |
| 8 | a (Create Project) | The manual's dependency lists for the SOAP experiment don't consistently include `wsdl4j` alongside `spring-boot-starter-web-services`, even though `DefaultWsdl11Definition` needs `wsdl4j`'s WSDL-generation classes on the classpath at runtime. | Added `wsdl4j` to the SOAP pom from the start. | Without `wsdl4j`, generating the WSDL at `/ws/users.wsdl` throws a runtime `ClassNotFoundException` for WSDL4J classes (`com.ibm.wsdl.*`), even though the code compiles fine — a classic "works until you hit that code path" bug. |
| 8 | d, e (WSDL/Endpoint Config, SoapUI Testing) | The manual's `WebServiceConfig` extends `WsConfigurerAdapter`, a class that is **deprecated** in modern Spring-WS (all of its methods are simple no-op overrides of default interface methods) and has been removed entirely in some later Spring-WS releases. | Changed `WebServiceConfig` to `implements WsConfigurer` directly instead of extending `WsConfigurerAdapter`. | `WsConfigurer`'s methods are all Java 8 `default` methods, so implementing the interface directly requires no boilerplate and avoids depending on a deprecated (and eventually removed) base class, making the code robust against future Spring-WS upgrades. |
| 9 | b/c (REST Controller CRUD) | Same `RuntimeException` → HTTP 500 issue as Experiment 7. | Same fix: `ResponseEntity` with proper `404` responses. | Same reasoning as Experiment 7. |
| 10 | b/c (RequestBody/ResponseEntity CRUD) | (1) Same `RuntimeException` → HTTP 500 issue as Experiments 7 and 9. (2) The manual's `DELETE` endpoint returned a plain `String` message with an implicit `200 OK`. | (1) Same 404 fix as above. (2) Changed `DELETE` to return `ResponseEntity<Void>` with `204 No Content` on success. | (1) Same reasoning as Experiment 7. (2) `204 No Content` is the standard REST convention for a successful delete with no response body, and better demonstrates `ResponseEntity`'s ability to represent a body-less success response — distinct from the body-bearing `200`/`201` cases elsewhere in the same controller, which is exactly what this experiment is meant to teach. |

---

## Structural Decisions (not "errors", but judgment calls worth documenting)

The brief asked for one folder per sub-question, matching "the actual
questions found in the uploaded lab manual." In several experiments, the
manual's **index table** (page 1 of each experiment) lists more granular
letters (e.g. Experiment 3: a–f) than the manual's **body content**
actually presents as separate, independently-runnable code blocks. Where
the manual's own body merges several index-table letters into one
implementation (because they are inseparable steps of a single class or
config, not independently runnable artifacts), this collection follows
the body's breakdown rather than inventing artificial, non-functional
intermediate projects. Each affected README explicitly states which
index-table letters it covers. Affected experiments:

- **Experiment 3** (b+c+d merged into one "Employee/EmployeeService/@Autowired" project)
- **Experiment 4** (b+c merged into one "Student/StudentService" project)
- **Experiment 7** (c+d merged into one "REST Controller + CRUD" project, since the manual itself implements them as a single controller class)
- **Experiment 9** (a+b merged into "Create Project + Resource Model"; c+d merged into "REST Controller CRUD")
- **Experiment 10** (b+c merged into one "RequestBody + ResponseEntity CRUD" project, since the manual's own `ProductController` demonstrates both annotations together in a single class)

No sub-question's *content* was skipped or omitted — every index-table
item is implemented somewhere in the corresponding experiment folder;
only the folder boundaries were adjusted where the manual's own material
didn't divide cleanly.

## Minor / cosmetic corrections not itemized above

- Standardized every project on **Spring Boot 3.3.4** and **Java 17**
  (the manual did not consistently pin exact versions across
  experiments).
- Confirmed and preserved `jakarta.persistence.*` imports throughout
  (correct for Spring Boot 3.x); the manual did not contain any stray
  legacy `javax.persistence.*` imports, but this was explicitly checked
  for and is called out here for completeness.
- Removed an unused `lombok` dependency listed as "optional" in the
  manual's Experiment 1(b) dependency list, since no class in that
  sub-question uses any Lombok annotation.
