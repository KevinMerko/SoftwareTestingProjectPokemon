package com.pokemonreview.api.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleTests {

    @Test
    public void testGetterAndSetterMethods() {
        // Arrange
        Role role = new Role();
        role.setId(1);
        role.setName("ROLE_USER");

        // Act & Assert
        assertEquals(1, role.getId());
        assertEquals("ROLE_USER", role.getName());
    }
}
