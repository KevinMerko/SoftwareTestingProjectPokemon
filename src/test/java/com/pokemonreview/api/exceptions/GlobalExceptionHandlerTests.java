package com.pokemonreview.api.exceptions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class GlobalExceptionHandlerTests {

    @Test
    public void testHandlePokemonNotFoundException() {
        // Arrange
        PokemonNotFoundException exception = new PokemonNotFoundException("Pokemon not found");
        WebRequest request = mock(WebRequest.class);
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        // Act
        ResponseEntity<ErrorObject> responseEntity = handler.handlePokemonNotFoundException(exception, request);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Pokemon not found", responseEntity.getBody().getMessage());
        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getBody().getStatusCode());
        assertEquals(new Date().getClass(), responseEntity.getBody().getTimestamp().getClass());
    }

    @Test
    public void testHandleReviewNotFoundException() {
        // Arrange
        ReviewNotFoundException exception = new ReviewNotFoundException("Review not found");
        WebRequest request = mock(WebRequest.class);
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        // Act
        ResponseEntity<ErrorObject> responseEntity = handler.handleReviewNotFoundException(exception, request);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Review not found", responseEntity.getBody().getMessage());
        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getBody().getStatusCode());
        assertEquals(new Date().getClass(), responseEntity.getBody().getTimestamp().getClass());
    }

}
