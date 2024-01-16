package com.pokemonreview.api.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserEntityTests {

    @Test
    public void testGetterAndSetterMethods() {
        // Arrange
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1);
        userEntity.setUsername("testUser");
        userEntity.setPassword("testPassword");

        Role role = new Role();
        role.setId(1);
        role.setName("ROLE_USER");

        // Act
        userEntity.getRoles().add(role);

        // Assert
        assertEquals(1, userEntity.getId());
        assertEquals("testUser", userEntity.getUsername());
        assertEquals("testPassword", userEntity.getPassword());
        assertEquals(1, userEntity.getRoles().size());
        assertEquals(role, userEntity.getRoles().get(0));
    }

    @Test
    public void testUserRoleRelationship() {
        // Arrange
        UserEntity userEntity = new UserEntity();
        Role role = new Role();
        role.setId(1);
        role.setName("ROLE_USER");

        // Act
        userEntity.getRoles().add(role);

        // Assert
        assertEquals(1, userEntity.getRoles().size());
        assertEquals(role, userEntity.getRoles().get(0));
    }
}
