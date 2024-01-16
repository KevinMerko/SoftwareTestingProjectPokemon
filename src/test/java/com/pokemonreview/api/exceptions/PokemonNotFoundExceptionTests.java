package com.pokemonreview.api.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PokemonNotFoundExceptionTests {

    @Test
    public void testExceptionMessage() {
        // Arrange
        String errorMessage = "Pokemon not found";

        // Act & Assert
        PokemonNotFoundException exception = assertThrows(PokemonNotFoundException.class, () -> {
            throw new PokemonNotFoundException(errorMessage);
        });

        assertEquals(errorMessage, exception.getMessage());
    }
}