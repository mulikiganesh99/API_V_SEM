# Experiment 8 — SOAP Web Service
## Sub-question (d): Create the WSDL, endpoint, and web service configuration

### Aim
Wire together an XSD schema (`users.xsd`), a `@PayloadRoot`-annotated `UserEndpoint`, and a `WebServiceConfig` that exposes an auto-generated WSDL at `/ws/users.wsdl` and a message endpoint at `/ws`.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
d_WSDL_Endpoint_Config/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   ├── model/SoapUser.java
│   ├── service/UserService.java, UserServiceImpl.java
│   ├── endpoint/UserEndpoint.java
│   └── config/WebServiceConfig.java
├── src/main/resources/
│   ├── application.properties
│   └── users.xsd
└── src/test/java/com/example/demo/WsdlAvailabilityTest.java
```

### Dependencies Used
`spring-boot-starter-web-services`, `wsdl4j`, `spring-boot-starter-test`

### Explanation
- `users.xsd` defines `GetUserRequest`/`GetUserResponse` elements under namespace `http://example.com/demo/webservice`.
- `UserEndpoint.handleGetUserRequest(...)` is invoked by Spring-WS whenever an inbound SOAP body's root element matches `{namespace}GetUserRequest`; it parses the `<id>` and builds a `GetUserResponse` DOM element by hand (this avoids needing a JAXB/XJC code-generation build step, keeping the Maven build simple and fully self-contained).
- `WebServiceConfig` registers `MessageDispatcherServlet` at `/ws/*` and a `DefaultWsdl11Definition` bean named `users`, which Spring-WS automatically publishes at `/ws/users.wsdl` (the bean name + `.wsdl` suffix is the convention Spring-WS uses to build the URL).

### How to Run
```bash
mvn clean spring-boot:run
```

### Endpoint / WSDL
| Purpose | URL |
|---|---|
| SOAP message endpoint | `http://localhost:8080/ws` |
| Auto-generated WSDL | `http://localhost:8080/ws/users.wsdl` |

### curl Example (fetch the WSDL)
```bash
curl http://localhost:8080/ws/users.wsdl
```

### Common Errors & Fixes
- **Manual bug — `WsConfigurerAdapter` is deprecated** (and removed in some Spring-WS releases) in favor of implementing the `WsConfigurer` interface directly, since all of its methods are Java 8 `default` no-ops. The manual's `WebServiceConfig extends WsConfigurerAdapter` compiles under older Spring-WS versions but triggers a deprecation warning and is fragile against future upgrades. **Fixed**: `WebServiceConfig implements WsConfigurer` directly here. See `ERRORS_AND_CORRECTIONS.md`.
- **`ClassNotFoundException` for `com.ibm.wsdl...` when fetching the WSDL** → make sure `wsdl4j` is on the classpath (already included in this pom).

### Verification Steps
```bash
mvn clean test
```
`WsdlAvailabilityTest` boots the app on a random port and fetches `/ws/users.wsdl` over real HTTP, asserting it contains `GetUserRequest`/`GetUserResponse` — genuine proof the WSDL is correctly generated and served.

### Manual Corrections Applied
- Replaced deprecated `WsConfigurerAdapter` with the `WsConfigurer` interface. See `ERRORS_AND_CORRECTIONS.md`.
