package com.pokemonreview.api.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReviewNotFoundExceptionTests {

    @Test
    public void testExceptionMessage() {
        // Arrange
        String errorMessage = "Review not found";

        // Act & Assert
        ReviewNotFoundException exception = assertThrows(ReviewNotFoundException.class, () -> {
            throw new ReviewNotFoundException(errorMessage);
        });

        assertEquals(errorMessage, exception.getMessage());
    }
}
