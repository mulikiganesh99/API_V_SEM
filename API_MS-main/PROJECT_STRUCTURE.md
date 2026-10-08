# Project Structure

This document shows the complete folder tree for `API_Microservices_Lab`,
covering all 10 experiments and their 40 sub-question projects. Every
leaf folder is an **independent, self-contained Maven project** with its
own `pom.xml`, full Java source (`src/main/java/...`), configuration
(`src/main/resources/...`), tests (`src/test/java/...`), and a
`README.md`.

(`target/` build output directories are omitted below; each `mvn
package`/`spring-boot:run` invocation regenerates them locally. `src/...`
Java source paths are abbreviated to just the file name for readability —
the full path in every project is
`src/main/java/com/example/demo/...` for main sources and
`src/test/java/com/example/demo/...` for tests.)

## Summary

| # | Experiment | Sub-questions |
|---|---|---|
| 1 | Setting Up Spring Framework | a, b, c (3) |
| 2 | Spring Modules | a, b, c (3) |
| 3 | Spring Boot Autowiring & Logging | a, b, c, d (4) |
| 4 | Spring Boot AOP Advices | a, b, c, d, e (5) |
| 5 | Spring Data JPA | a, b, c, d, e, f (6) |
| 6 | Pagination & Sorting with JPA | a, b, c, d (4) |
| 7 | RESTful Web Service | a, b, c, d (4) |
| 8 | SOAP Web Service | a, b, c, d, e (5) |
| 9 | Spring REST Controller | a, b, c (3) |
| 10 | @RequestBody / ResponseEntity | a, b, c (3) |
| **Total** | **10 experiments** | **40 sub-question projects** |

See `ERRORS_AND_CORRECTIONS.md` for the full list of manual bugs found
and fixed, and for the reasoning behind the few places where adjacent
index-table letters were combined into one sub-folder because the
manual's own body content presented them as a single, inseparable
implementation.

## Full Tree

```
API_Microservices_Lab/
├── PROJECT_STRUCTURE.md
├── ERRORS_AND_CORRECTIONS.md
│
├── 01_Setting_Up_Spring_Framework/
│   ├── a_Create_Spring_Boot_Application/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../HelloController.java
│   │   └── src/.../DemoApplicationTests.java
│   ├── b_Project_Structure_Dependencies/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../HelloController.java
│   │   └── src/.../DemoApplicationTests.java
│   └── c_Hello_World/
│       ├── pom.xml
│       ├── README.md
│       ├── src/.../DemoApplication.java
│       ├── src/.../HelloController.java
│       └── src/.../HelloControllerTest.java
│   
├── 02_Spring_Modules/
│   ├── a_Explore_Spring_Modules/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../ModuleInfoController.java
│   │   └── src/.../DemoApplicationTests.java
│   ├── b_JDBC_Data_Access/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../SpringJdbcApplication.java
│   │   ├── src/.../Product.java
│   │   ├── src/.../ProductRepository.java
│   │   └── src/.../ProductRepositoryTest.java
│   └── c_Spring_MVC_Web_Application/
│       ├── pom.xml
│       ├── README.md
│       ├── src/.../SpringMvcApplication.java
│       ├── src/.../PortalController.java
│       └── src/.../PortalControllerTest.java
│   
├── 03_Spring_Boot_Autowiring_Logging/
│   ├── a_Create_Spring_Boot_Project/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   └── src/.../DemoApplicationTests.java
│   ├── b_Employee_EmployeeService_Autowiring/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../Employee.java
│   │   ├── src/.../EmployeeService.java
│   │   └── src/.../EmployeeServiceAutowiringTest.java
│   ├── c_Logback_Logging/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../Employee.java
│   │   ├── src/.../EmployeeService.java
│   │   └── src/.../EmployeeServiceLoggingTest.java
│   └── d_Testing_AutoWiring_Logging/
│       ├── pom.xml
│       ├── README.md
│       ├── src/.../DemoApplication.java
│       ├── src/.../Employee.java
│       ├── src/.../EmployeeService.java
│       └── src/.../EmployeeServiceTest.java
│   
├── 04_Spring_Boot_AOP_Advices/
│   ├── a_Create_Spring_Boot_Project/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   └── src/.../DemoApplicationTests.java
│   ├── b_Student_StudentService/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../Student.java
│   │   ├── src/.../StudentService.java
│   │   └── src/.../StudentServiceTest.java
│   ├── c_AOP_Aspect_Before/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../LoggingAspect.java
│   │   ├── src/.../Student.java
│   │   ├── src/.../StudentService.java
│   │   └── src/.../LoggingAspectTest.java
│   ├── d_Apply_Advice_Main_Config/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../LoggingAspect.java
│   │   ├── src/.../Student.java
│   │   ├── src/.../StudentService.java
│   │   └── src/.../DemoApplicationTests.java
│   └── e_Test_AOP_Functionality/
│       ├── pom.xml
│       ├── README.md
│       ├── src/.../DemoApplication.java
│       ├── src/.../LoggingAspect.java
│       ├── src/.../Student.java
│       ├── src/.../StudentService.java
│       └── src/.../StudentAopTest.java
│   
├── 05_Spring_Data_JPA/
│   ├── a_Create_Project/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   └── src/.../DemoApplicationTests.java
│   ├── b_JPA_Dependency/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   └── src/.../DemoApplicationTests.java
│   ├── c_Database_Configuration/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   └── src/.../DemoApplicationTests.java
│   ├── d_Entity_User/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../User.java
│   │   └── src/.../UserEntityTest.java
│   ├── e_Repository_UserRepository/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../User.java
│   │   ├── src/.../UserRepository.java
│   │   └── src/.../UserRepositoryTest.java
│   └── f_CRUD_Test/
│       ├── pom.xml
│       ├── README.md
│       ├── src/.../DemoApplication.java
│       ├── src/.../User.java
│       ├── src/.../UserRepository.java
│       └── src/.../UserCrudTest.java
│   
├── 06_Pagination_Sorting_JPA/
│   ├── a_Repository_Pagination/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../User.java
│   │   ├── src/.../UserRepository.java
│   │   └── src/.../UserRepositoryPagingTest.java
│   ├── b_Pageable_Sort/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../User.java
│   │   ├── src/.../UserRepository.java
│   │   ├── src/.../UserService.java
│   │   └── src/.../UserServiceTest.java
│   ├── c_Test_Pagination_Sorting/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../User.java
│   │   ├── src/.../UserRepository.java
│   │   ├── src/.../UserService.java
│   │   └── src/.../UserPaginationTest.java
│   └── d_Custom_Query_Sorting/
│       ├── pom.xml
│       ├── README.md
│       ├── src/.../DemoApplication.java
│       ├── src/.../User.java
│       ├── src/.../UserRepository.java
│       └── src/.../UserCustomQueryTest.java
│   
├── 07_RESTful_Web_Service/
│   ├── a_Create_Project/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   └── src/.../DemoApplicationTests.java
│   ├── b_User_Resource_Model/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../User.java
│   │   └── src/.../UserModelTest.java
│   ├── c_REST_Controller_CRUD/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../UserController.java
│   │   ├── src/.../User.java
│   │   └── src/.../UserControllerTest.java
│   └── d_Postman_Curl_Testing/
│       ├── pom.xml
│       ├── README.md
│       ├── src/.../DemoApplication.java
│       ├── src/.../UserController.java
│       ├── src/.../User.java
│       └── src/.../UserControllerTest.java
│   
├── 08_SOAP_Web_Service/
│   ├── a_Create_Project/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   └── src/.../DemoApplicationTests.java
│   ├── b_Service_Interface/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../SoapUser.java
│   │   ├── src/.../UserService.java
│   │   └── src/.../DemoApplicationTests.java
│   ├── c_Service_Implementation/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../SoapUser.java
│   │   ├── src/.../UserService.java
│   │   ├── src/.../UserServiceImpl.java
│   │   └── src/.../UserServiceImplTest.java
│   ├── d_WSDL_Endpoint_Config/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../WebServiceConfig.java
│   │   ├── src/.../UserEndpoint.java
│   │   ├── src/.../SoapUser.java
│   │   ├── src/.../UserService.java
│   │   ├── src/.../UserServiceImpl.java
│   │   └── src/.../WsdlAvailabilityTest.java
│   └── e_SoapUI_Testing/
│       ├── pom.xml
│       ├── README.md
│       ├── sample-request.xml
│       ├── src/.../DemoApplication.java
│       ├── src/.../WebServiceConfig.java
│       ├── src/.../UserEndpoint.java
│       ├── src/.../SoapUser.java
│       ├── src/.../UserService.java
│       ├── src/.../UserServiceImpl.java
│       └── src/.../SoapEndpointIntegrationTest.java
│   
├── 09_Spring_REST_Controller/
│   ├── a_Create_Project_Resource_Model/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../User.java
│   │   └── src/.../UserModelTest.java
│   ├── b_REST_Controller_CRUD/
│   │   ├── pom.xml
│   │   ├── README.md
│   │   ├── src/.../DemoApplication.java
│   │   ├── src/.../UserController.java
│   │   ├── src/.../User.java
│   │   └── src/.../UserControllerTest.java
│   └── c_Postman_Curl_Testing/
│       ├── pom.xml
│       ├── README.md
│       ├── src/.../DemoApplication.java
│       ├── src/.../UserController.java
│       ├── src/.../User.java
│       └── src/.../UserControllerTest.java
│   
└── 10_RequestBody_ResponseEntity/
    ├── a_REST_Controller_Setup/
    │   ├── pom.xml
    │   ├── README.md
    │   ├── src/.../DemoApplication.java
    │   ├── src/.../Product.java
    │   └── src/.../ProductModelTest.java
    ├── b_RequestBody_ResponseEntity_CRUD/
    │   ├── pom.xml
    │   ├── README.md
    │   ├── src/.../DemoApplication.java
    │   ├── src/.../ProductController.java
    │   ├── src/.../Product.java
    │   └── src/.../ProductControllerTest.java
    └── c_Postman_Curl_Testing/
        ├── pom.xml
        ├── README.md
        ├── src/.../DemoApplication.java
        ├── src/.../ProductController.java
        ├── src/.../Product.java
        └── src/.../ProductControllerTest.java
    
```
