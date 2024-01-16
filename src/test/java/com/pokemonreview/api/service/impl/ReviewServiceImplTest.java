package com.pokemonreview.api.service.impl;

import com.pokemonreview.api.dto.ReviewDto;
import com.pokemonreview.api.exceptions.PokemonNotFoundException;
import com.pokemonreview.api.models.Pokemon;
import com.pokemonreview.api.models.Review;
import com.pokemonreview.api.repository.PokemonRepository;
import com.pokemonreview.api.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReviewServiceImplTest {

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private PokemonRepository pokemonRepository;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createReview_ValidPokemonId_ShouldCreateReview() {
        // Arrange
        int pokemonId = 1;
        ReviewDto reviewDto = new ReviewDto();
        Pokemon pokemon = new Pokemon();
        Review savedReview = new Review();
        savedReview.setId(1);

        when(pokemonRepository.findById(pokemonId)).thenReturn(Optional.of(pokemon));
        when(reviewRepository.save(any(Review.class))).thenReturn(savedReview);

        // Act
        ReviewDto result = reviewService.createReview(pokemonId, reviewDto);

        // Assert
        assertNotNull(result);
        assertEquals(savedReview.getId(), result.getId());
    }

    @Test
    void createReview_InvalidPokemonId_ShouldThrowException() {
        // Arrange
        int pokemonId = 1;
        ReviewDto reviewDto = new ReviewDto();

        when(pokemonRepository.findById(pokemonId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(PokemonNotFoundException.class, () -> reviewService.createReview(pokemonId, reviewDto));
    }
}
