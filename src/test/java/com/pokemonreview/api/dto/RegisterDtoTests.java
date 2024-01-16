package com.pokemonreview.api.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RegisterDtoTests {

    @Test
    public void testDefaultConstructorAndGetters() {
        // Arrange & Act
        RegisterDto registerDto = new RegisterDto();

        // Assert
        assertNotNull(registerDto);
        assertEquals(null, registerDto.getUsername());
        assertEquals(null, registerDto.getPassword());
    }

    @Test
    public void testParameterizedConstructorAndGetters() {
        // Arrange
        String username = "testUser";
        String password = "testPassword";

        // Act
        RegisterDto registerDto = new RegisterDto();
        registerDto.setUsername(username);
        registerDto.setPassword(password);

        // Assert
        assertNotNull(registerDto);
        assertEquals(username, registerDto.getUsername());
        assertEquals(password, registerDto.getPassword());
    }
}
