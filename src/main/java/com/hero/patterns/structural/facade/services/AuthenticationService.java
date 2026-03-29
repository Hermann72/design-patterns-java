package com.hero.patterns.structural.facade.services;

public class AuthenticationService {

    public boolean authenticate(String userId) {
        System.out.println("  [AUTH] Validating user: " + userId);
        // Simulates validation against database
        boolean isValid = userId != null && !userId.isBlank();
        System.out.println("  [AUTH] User " + userId + ": " + (isValid ? "authorized" : "rejected"));
        return isValid;
    }

    public String getRole(String userId) {
        // Simulates rol consultation
        return userId.startsWith("admin") ? "ADMIN" : "USER";
    }
}
