package com.pokemonreview.api.service.impl;

import com.pokemonreview.api.dto.PokemonDto;
import com.pokemonreview.api.dto.PokemonResponse;
import com.pokemonreview.api.models.Pokemon;
import com.pokemonreview.api.repository.PokemonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PokemonServiceImplTest {

    @Mock
    private PokemonRepository pokemonRepository;

    @InjectMocks
    private PokemonServiceImpl pokemonService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPokemon_ShouldCreatePokemon() {
        // Arrange
        PokemonDto pokemonDto = new PokemonDto();
        pokemonDto.setName("Pikachu");
        pokemonDto.setType("Electric");

        Pokemon pokemon = new Pokemon();
        pokemon.setId(1);
        pokemon.setName("Pikachu");
        pokemon.setType("Electric");

        when(pokemonRepository.save(any(Pokemon.class))).thenReturn(pokemon);

        // Act
        PokemonDto result = pokemonService.createPokemon(pokemonDto);

        // Assert
        assertNotNull(result);
        assertEquals(pokemon.getId(), result.getId());
        assertEquals(pokemon.getName(), result.getName());
        assertEquals(pokemon.getType(), result.getType());
    }

    @Test
    void getAllPokemon_ShouldReturnPokemonResponse() {
        // Arrange
        int pageNo = 0;
        int pageSize = 10;

        Pokemon pokemon = new Pokemon();
        pokemon.setId(1);
        pokemon.setName("Pikachu");
        pokemon.setType("Electric");

        Page<Pokemon> pokemonPage = new PageImpl<>(Collections.singletonList(pokemon));
        when(pokemonRepository.findAll(any(PageRequest.class))).thenReturn(pokemonPage);

        // Act
        PokemonResponse result = pokemonService.getAllPokemon(pageNo, pageSize);

        // Assert
        assertNotNull(result);
        assertFalse(result.getContent().isEmpty());
        assertEquals(pokemon.getId(), result.getContent().get(0).getId());
        assertEquals(pokemon.getName(), result.getContent().get(0).getName());
        assertEquals(pokemon.getType(), result.getContent().get(0).getType());
    }
}
