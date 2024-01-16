package com.pokemonreview.api.security;
import com.pokemonreview.api.security.SecurityConstants;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecurityConstantsTest {

    @Test
    public void testJwtExpiration() {
        // Arrange
        long expectedExpiration = 70000;

        // Act
        long actualExpiration = SecurityConstants.JWT_EXPIRATION;

        // Assert
        assertEquals(expectedExpiration, actualExpiration);
    }
}
