package com.pokemonreview.api.controller;
import com.pokemonreview.api.controllers.AuthController;
import com.pokemonreview.api.dto.AuthResponseDTO;
import com.pokemonreview.api.dto.LoginDto;
import com.pokemonreview.api.dto.RegisterDto;
import com.pokemonreview.api.models.Role;
import com.pokemonreview.api.models.UserEntity;
import com.pokemonreview.api.repository.RoleRepository;
import com.pokemonreview.api.repository.UserRepository;
import com.pokemonreview.api.security.JWTGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTests {

    @InjectMocks
    private AuthController authController;
    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JWTGenerator jwtGenerator;


    @Test
    public void testLogin() {
        // Arrange
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername("testUser");
        loginDto.setPassword("testPassword");

        Authentication authentication = Mockito.mock(Authentication.class);
        when(authenticationManager.authenticate(any()))
                .thenReturn(authentication);
        when(jwtGenerator.generateToken(authentication))
                .thenReturn("testToken");

        // Act
        ResponseEntity<AuthResponseDTO> responseEntity = authController.login(loginDto);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody().getTokenType().startsWith("Bearer "));
    }

    @Test
    public void testRegister() {
        // Arrange
        RegisterDto registerDto = new RegisterDto();
        registerDto.setUsername("newUser");
        registerDto.setPassword("newPassword");

        when(userRepository.existsByUsername("newUser"))
                .thenReturn(false);

        Role role = new Role();
        role.setName("USER");
        when(roleRepository.findByName("USER"))
                .thenReturn(Optional.of(role));

        UserEntity savedUser = new UserEntity();
        savedUser.setId(1);
        savedUser.setUsername("newUser");
        savedUser.setPassword("encodedPassword");
        savedUser.setRoles(Collections.singletonList(role));

        when(userRepository.save(any()))
                .thenReturn(savedUser);

        // Act
        ResponseEntity<String> responseEntity = authController.register(registerDto);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("User registered success!", responseEntity.getBody());
    }
}
