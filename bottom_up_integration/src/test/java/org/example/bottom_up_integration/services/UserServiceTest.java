package org.example.bottom_up_integration.services;

import org.example.bottom_up_integration.entities.User;
import org.example.bottom_up_integration.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testRegisterUser() {
        User user = new User("Ahurein", "ahurein@gmail.com");
        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = userService.registerUser(user);
        assertNotNull(result);
        assertEquals(user.getUsername(), result.getUsername());
    }

    @Test
    void testGetUserByUsername() {
        User user = new User("Ahurein", "ahurein@gmail.com");
        when(userRepository.findByUsername("Ahurein")).thenReturn(Optional.of(user));

        Optional<User> result = userService.getUserByUsername("Ahurein");
        assertTrue(result.isPresent());
        assertEquals(user.getUsername(), result.get().getUsername());
    }
}