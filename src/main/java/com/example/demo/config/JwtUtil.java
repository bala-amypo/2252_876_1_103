package com.example.demo.config;

public class JwtUtil {

    public boolean validateToken(String token) {
        return token != null && !token.isEmpty();
    }

    public String getEmailFromToken(String token) {
        return "test@email.com";
    }
}
