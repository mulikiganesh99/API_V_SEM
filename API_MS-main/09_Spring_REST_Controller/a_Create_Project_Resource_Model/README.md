# Experiment 9 — Spring REST Controller
## Sub-question (a): Create the project and define the User resource model

*(Covers manual index items a and b, which the manual body presents as one continuous "Procedure" section.)*

### Aim
Bootstrap the project and define the `User` POJO resource used by the controller in sub-question b.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
a_Create_Project_Resource_Model/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   └── model/User.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/UserModelTest.java
```

### How to Run
```bash
mvn clean spring-boot:run
```

### Verification
```bash
mvn clean test
```

### Manual Corrections Applied
None.
