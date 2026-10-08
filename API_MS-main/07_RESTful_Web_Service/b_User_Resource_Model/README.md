# Experiment 7 — RESTful Web Service
## Sub-question (b): Define a resource class (User)

### Aim
Define the `User` POJO resource used by the REST controller in the next sub-question.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
b_User_Resource_Model/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   └── model/User.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/UserModelTest.java
```

### Verification Steps
```bash
mvn clean test
```
`UserModelTest` checks the constructor and all getters/setters.

### Manual Corrections Applied
None.
