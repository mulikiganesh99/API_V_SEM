# Experiment 8 — SOAP Web Service
## Sub-question (e): Test the SOAP web service using SoapUI

### Aim
Provide a ready-to-run copy of the SOAP service (identical to sub-question d) plus a sample SOAP request and a step-by-step SoapUI testing walkthrough.

### Requirements
JDK 17+, Maven 3.9+; [SoapUI](https://www.soapui.org/) (free/open-source edition) for GUI testing, or curl as a command-line alternative.

### Project Structure
```
e_SoapUI_Testing/
├── pom.xml
├── sample-request.xml         <- sample SOAP envelope used by both SoapUI and the automated test
├── src/main/java/com/example/demo/  (same as sub-question d)
├── src/main/resources/{application.properties,users.xsd}
└── src/test/java/com/example/demo/SoapEndpointIntegrationTest.java
```

### How to Run
```bash
mvn clean spring-boot:run
```

### Testing with SoapUI
1. Open SoapUI → **File → New SOAP Project**.
2. Set **Initial WSDL** to `http://localhost:8080/ws/users.wsdl` and click **OK** — SoapUI imports the operation and generates a default request.
3. Open the generated request, replace its body with the contents of `sample-request.xml` (or just set `<web:id>` to `1` or `2`).
4. Click **Submit** (the green play button). You should get back a `GetUserResponse` containing the matching user's `id`, `name`, and `email`.
5. Try `<web:id>99</web:id>` — the response should show `name = "Not Found"`, `email = "N/A"` (the endpoint's graceful fallback for unknown IDs, rather than a SOAP fault).

### Testing with curl (no SoapUI required)
```bash
curl -X POST http://localhost:8080/ws \
  -H "Content-Type: text/xml;charset=UTF-8" \
  --data @sample-request.xml
```

### Expected SOAP Response (abridged)
```xml
<SOAP-ENV:Envelope ...>
  <SOAP-ENV:Body>
    <GetUserResponse xmlns="http://example.com/demo/webservice">
      <id>1</id>
      <name>Rahul Kumar</name>
      <email>rahul@aditya.edu.in</email>
    </GetUserResponse>
  </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

### Common Errors & Fixes
- **SoapUI can't import the WSDL** → confirm the app is running (`mvn spring-boot:run`) and the URL is exactly `http://localhost:8080/ws/users.wsdl`.
- Same `WsConfigurerAdapter` fix as sub-question d applies here too.

### Verification Steps
```bash
mvn clean test
```
`SoapEndpointIntegrationTest` posts the real `sample-request.xml` file to `/ws` over HTTP on a random test port and asserts the response body contains the expected user's name and email — an actual end-to-end SOAP round trip, not a mock.

### Manual Corrections Applied
Same `WsConfigurerAdapter` → `WsConfigurer` fix as sub-question d (see `ERRORS_AND_CORRECTIONS.md`). The manual described SoapUI testing only narratively/via screenshots; a concrete `sample-request.xml` and an automated equivalent test were added so this sub-question is independently runnable and verifiable without SoapUI installed.
