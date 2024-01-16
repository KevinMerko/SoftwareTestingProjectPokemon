package com.pokemonreview.api.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonTests {

    @Test
    public void testGetterAndSetterMethods() {
        // Arrange
        Pokemon pokemon = new Pokemon();
        pokemon.setId(1);
        pokemon.setName("Pikachu");
        pokemon.setType("Electric");

        Review review = new Review();
        review.setId(1);
        review.setStars(5);
        review.setTitle("Great Pokemon!");

        // Act
        pokemon.getReviews().add(review);

        // Assert
        assertEquals(1, pokemon.getId());
        assertEquals("Pikachu", pokemon.getName());
        assertEquals("Electric", pokemon.getType());
        assertEquals(1, pokemon.getReviews().size());
        assertEquals(review, pokemon.getReviews().get(0));
    }
}
