package com.pokemonreview.api.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewTests {

    @Test
    public void testGetterAndSetterMethods() {
        // Arrange
        Review review = new Review();
        review.setId(1);
        review.setTitle("Great Review");
        review.setContent("This Pokemon is amazing!");
        review.setStars(5);

        Pokemon pokemon = new Pokemon();
        pokemon.setId(1);
        pokemon.setName("Pikachu");
        pokemon.setType("Electric");

        // Act
        review.setPokemon(pokemon);

        // Assert
        assertEquals(1, review.getId());
        assertEquals("Great Review", review.getTitle());
        assertEquals("This Pokemon is amazing!", review.getContent());
        assertEquals(5, review.getStars());
        assertEquals(pokemon, review.getPokemon());
    }
}
