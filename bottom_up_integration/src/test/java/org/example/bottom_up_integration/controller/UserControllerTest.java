package org.example.bottom_up_integration.controller;

import org.example.bottom_up_integration.entities.User;
import org.example.bottom_up_integration.services.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testGetUserProfile() throws Exception {
        User user = new User("ahurein", "ahurein@gmail.com");
        when(userService.getUserByUsername("ahurein")).thenReturn(Optional.of(user));

        mockMvc.perform(MockMvcRequestBuilders.get("/profile/ahurein"))
                .andExpect(status().isOk())
                .andExpect(view().name("user-profile"))
                .andExpect(MockMvcResultMatchers.model().attribute("user", Matchers.hasProperty("username", Matchers.is("ahurein"))));
    }

    @Test
    void testRegisterUser() throws Exception {
        mockMvc.perform(post("/register")
                        .param("username", "ahurein")
                        .param("email", "ahurein@gmail.com"))
                .andExpect(status().isOk())
                .andExpect(view().name("registration-success"));
    }
}