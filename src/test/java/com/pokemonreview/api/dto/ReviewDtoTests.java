package com.pokemonreview.api.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ReviewDtoTests {

    @Test
    public void testBuilder() {
        // Arrange
        int id = 1;
        String title = "Great Review";
        String content = "This is an excellent review.";
        int stars = 5;

        // Act
        ReviewDto reviewDto = ReviewDto.builder()
                .id(id)
                .title(title)
                .content(content)
                .stars(stars)
                .build();

        // Assert
        assertNotNull(reviewDto);
        assertEquals(id, reviewDto.getId());
        assertEquals(title, reviewDto.getTitle());
        assertEquals(content, reviewDto.getContent());
        assertEquals(stars, reviewDto.getStars());
    }

    @Test
    public void testGettersAndSetters() {
        // Arrange
        ReviewDto reviewDto = new ReviewDto();

        // Act
        reviewDto.setId(2);
        reviewDto.setTitle("Another Review");
        reviewDto.setContent("This is another review.");
        reviewDto.setStars(4);

        // Assert
        assertNotNull(reviewDto);
        assertEquals(2, reviewDto.getId());
        assertEquals("Another Review", reviewDto.getTitle());
        assertEquals("This is another review.", reviewDto.getContent());
        assertEquals(4, reviewDto.getStars());
    }
}