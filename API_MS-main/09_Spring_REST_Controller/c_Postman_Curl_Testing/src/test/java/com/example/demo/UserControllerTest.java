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
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void fullCrudLifecycle() throws Exception {
        String newUserJson = "{\"name\":\"Diana Prince\",\"email\":\"diana@example.com\"}";

        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(newUserJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Diana Prince"));

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Rahul Kumar"));

        String updateJson = "{\"name\":\"Rahul Updated\",\"email\":\"rahul.updated@aditya.edu.in\"}";
        mockMvc.perform(put("/users/1").contentType(MediaType.APPLICATION_JSON).content(updateJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Rahul Updated"));

        mockMvc.perform(delete("/users/2"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/users/2"))
                .andExpect(status().isNotFound());
    }
}
