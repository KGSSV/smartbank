package com.brillio;

import com.brillio.util.JwtUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JwtUtilTest {

    private JwtUtil jwtUtil;
    private UserDetails userDetails;

    @BeforeEach
    public void setup() {
        jwtUtil = new JwtUtil();
        userDetails = mock(UserDetails.class);
        when(userDetails.getUsername()).thenReturn("testUser");
    }

    @Test
    public void testExtractUsername() {
        String token = jwtUtil.generateToken(userDetails);
        String username = jwtUtil.extractUsername(token);
        Assertions.assertEquals("testUser", username);
    }

    @Test
    public void testExtractExpiration() {
        String token = jwtUtil.generateToken(userDetails);
        Date expiration = jwtUtil.extractExpiration(token);
        Assertions.assertNotNull(expiration);
    }

    @Test
    public void testExtractClaim() {
        String token = jwtUtil.generateToken(userDetails);
        String claim = jwtUtil.extractClaim(token, claims -> claims.get("claimKey", String.class));
        Assertions.assertNull(claim);
    }

    @Test
    public void testIsTokenExpired() {
        String token = jwtUtil.generateToken(userDetails);
        boolean isExpired = jwtUtil.isTokenExpired(token);
        Assertions.assertFalse(isExpired);
    }
    @Test
    public void testGenerateToken() {
        String token = jwtUtil.generateToken(userDetails);
        Assertions.assertNotNull(token);
    }
    @Test
    public void testValidateToken() {
        String token = jwtUtil.generateToken(userDetails);
        boolean isValid = jwtUtil.validateToken(token, userDetails);
        Assertions.assertTrue(isValid);
    }
}
