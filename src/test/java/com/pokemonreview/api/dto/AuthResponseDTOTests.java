package com.pokemonreview.api.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AuthResponseDTOTests {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        String accessToken = "testAccessToken";

        // Act
        AuthResponseDTO authResponseDTO = new AuthResponseDTO(accessToken);

        // Assert
        assertNotNull(authResponseDTO);
        assertEquals(accessToken, authResponseDTO.getAccessToken());
        assertEquals("Bearer ", authResponseDTO.getTokenType());
    }
}
