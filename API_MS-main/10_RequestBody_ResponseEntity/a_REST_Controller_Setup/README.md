# Experiment 10 — @RequestBody and ResponseEntity
## Sub-question (a): Create the REST controller project and Product model

*(Covers manual index item a — project + resource setup, split out from the combined controller in item b so the model can be verified independently first.)*

### Aim
Bootstrap the project and define the `Product` resource used by the controller in sub-question b.

### Requirements
JDK 17+, Maven 3.9+

### Project Structure
```
a_REST_Controller_Setup/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java
│   └── model/Product.java
├── src/main/resources/application.properties
└── src/test/java/com/example/demo/ProductModelTest.java
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
