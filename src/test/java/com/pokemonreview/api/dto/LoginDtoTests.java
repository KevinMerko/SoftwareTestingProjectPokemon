package com.pokemonreview.api.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginDtoTests {

    @Test
    public void testDefaultConstructorAndGetters() {
        // Arrange & Act
        LoginDto loginDto = new LoginDto();

        // Assert
        assertNotNull(loginDto);
        assertEquals(null, loginDto.getUsername());
        assertEquals(null, loginDto.getPassword());
    }

    @Test
    public void testParameterizedConstructorAndGetters() {
        // Arrange
        String username = "testUser";
        String password = "testPassword";

        // Act
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername(username);
        loginDto.setPassword(password);

        // Assert
        assertNotNull(loginDto);
        assertEquals(username, loginDto.getUsername());
        assertEquals(password, loginDto.getPassword());
    }
}
