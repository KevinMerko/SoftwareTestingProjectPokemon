package com.pokemonreview.api.exceptions;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ErrorObjectTests {

    // Tolerance in milliseconds for date comparison
    private static final long TOLERANCE_MILLIS = 1000; // 1 second

    @Test
    public void testGetterAndSetterMethods() {
        // Arrange
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(404);
        errorObject.setMessage("Not Found");
        errorObject.setTimestamp(new Date());

        // Act & Assert
        assertEquals(404, errorObject.getStatusCode());
        assertEquals("Not Found", errorObject.getMessage());

        // Use assertTrue with a custom message to check if the timestamps are close enough
        assertTrue(Math.abs(System.currentTimeMillis() - errorObject.getTimestamp().getTime()) < TOLERANCE_MILLIS,
                "Timestamps are not within tolerance");
    }
}
