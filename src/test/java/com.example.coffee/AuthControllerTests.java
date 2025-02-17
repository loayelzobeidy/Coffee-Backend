package com.example.coffee;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.example.coffee.configurations.JwtProperties;
import com.example.coffee.entities.User;
import com.example.coffee.repositories.AuthenticationResponse;
import com.example.coffee.repositories.RefreshTokenRepository;
import com.example.coffee.repositories.UserRepository;
import com.example.coffee.requests.AuthenticationRequest;
import com.example.coffee.services.AuthenticationService;
import com.example.coffee.services.CustomUserDetailsService;
import com.example.coffee.services.TokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AuthControllerTests {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AuthenticationManager authManager;

    @Mock
    private CustomUserDetailsService userDetailsService;

    @Mock
    private TokenService tokenService;

    @Mock
    private RefreshTokenRepository refreshTokenRepository;

    @Mock
    private JwtProperties jwtProperties;

    @InjectMocks
    private AuthenticationService authService;

    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setup() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    public void testLogin() {
        String email = "test@gmail.com";
        String rawPassword = "password";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        User user = new User();
        user.setEmail(email);
        user.setPassword(encodedPassword);

        when(userRepository.findByEmail(email)).thenReturn(user);
        when(authManager.authenticate(any())).thenReturn(null);

        AuthenticationRequest authenticationRequest = new AuthenticationRequest(email, rawPassword);
        AuthenticationResponse authenticationResponse = authService.authentication(authenticationRequest);

        // Assert
        assertNotNull(authenticationResponse, "Authentication response should not be null");
        assertEquals(email, authenticationResponse.getEmail(), "Email should match the authenticated user");
        assertNotNull(authenticationResponse.getAccessToken(), "AccessToken should not be null");
    }
}
