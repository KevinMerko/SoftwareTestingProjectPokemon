package com.pokemonreview.api.dto;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PokemonResponseTests {

    @Test
    public void testBuilder() {
        // Arrange
        List<PokemonDto> content = Arrays.asList(
                PokemonDto.builder().id(1).name("Pikachu").type("Electric").build(),
                PokemonDto.builder().id(2).name("Bulbasaur").type("Grass/Poison").build()
        );
        int pageNo = 1;
        int pageSize = 10;
        long totalElements = 2;
        int totalPages = 1;
        boolean last = true;

        // Act
        PokemonResponse pokemonResponse = new PokemonResponse(content, pageNo, pageSize, totalElements, totalPages, last);

        // Assert
        assertNotNull(pokemonResponse);
        assertEquals(content, pokemonResponse.getContent());
        assertEquals(pageNo, pokemonResponse.getPageNo());
        assertEquals(pageSize, pokemonResponse.getPageSize());
        assertEquals(totalElements, pokemonResponse.getTotalElements());
        assertEquals(totalPages, pokemonResponse.getTotalPages());
        assertEquals(last, pokemonResponse.isLast());
    }
}
