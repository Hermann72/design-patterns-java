package com.hero.patterns.structural.facade.services;

import java.time.LocalDateTime;

public class AuditService {
    public void log(String userId, String action, String details) {
        System.out.println("  [AUDIT] " + LocalDateTime.now() +
                " | User: " + userId +
                " | Action: " + action +
                " | Details: " + details);
    }
}
