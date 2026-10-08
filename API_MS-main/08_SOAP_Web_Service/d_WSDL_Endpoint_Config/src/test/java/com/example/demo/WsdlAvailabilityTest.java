package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WsdlAvailabilityTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void wsdlIsExposedAndContainsExpectedElements() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/ws/users.wsdl", String.class);
        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getBody().contains("GetUserRequest"));
        assertTrue(response.getBody().contains("GetUserResponse"));
    }
}
