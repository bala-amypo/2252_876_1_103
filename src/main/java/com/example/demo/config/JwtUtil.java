package com.example.demo.config;

public class JwtUtil {

    public String generateToken(String username) {
        return "test-jwt-token";
    }

    public String extractUsername(String token) {
        return "test-user";
    }
}
