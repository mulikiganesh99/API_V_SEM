package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SoapEndpointIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void postingSampleSoapRequestReturnsExpectedUser() throws Exception {
        String soapRequest = Files.readString(Path.of("sample-request.xml"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_XML);
        HttpEntity<String> request = new HttpEntity<>(soapRequest, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:" + port + "/ws", HttpMethod.POST, request, String.class);

        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getBody().contains("Rahul Kumar"));
        assertTrue(response.getBody().contains("rahul@aditya.edu.in"));
    }
}
