package com.pokemonreview.api.dto;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PokemonDtoTests {

    @Test
    public void testBuilder() {
        // Arrange
        int id = 1;
        String name = "Pikachu";
        String type = "Electric";

        // Act
        PokemonDto pokemonDto = PokemonDto.builder()
                .id(id)
                .name(name)
                .type(type)
                .build();

        // Assert
        assertNotNull(pokemonDto);
        assertEquals(id, pokemonDto.getId());
        assertEquals(name, pokemonDto.getName());
        assertEquals(type, pokemonDto.getType());
    }

    @Test
    public void testGettersAndSetters() {
        // Arrange
        PokemonDto pokemonDto = new PokemonDto();

        // Act
        pokemonDto.setId(2);
        pokemonDto.setName("Bulbasaur");
        pokemonDto.setType("Grass/Poison");

        // Assert
        assertNotNull(pokemonDto);
        assertEquals(2, pokemonDto.getId());
        assertEquals("Bulbasaur", pokemonDto.getName());
        assertEquals("Grass/Poison", pokemonDto.getType());
    }
}
