package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllUsersReturnsSeededUsers() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void getUserByIdReturns404WhenMissing() throws Exception {
        mockMvc.perform(get("/api/users/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void fullCrudLifecycle() throws Exception {
        String newUserJson = "{\"name\":\"Charlie Brown\",\"email\":\"charlie@example.com\"}";

        mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON).content(newUserJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Charlie Brown"));

        String updateJson = "{\"name\":\"Rahul Updated\",\"email\":\"rahul.updated@aditya.edu.in\"}";
        mockMvc.perform(put("/api/users/1").contentType(MediaType.APPLICATION_JSON).content(updateJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Rahul Updated"));

        mockMvc.perform(delete("/api/users/2"))
                .andExpect(status().isOk());
    }
}
