package com.hero.patterns.behavioral.observer.observers;

import com.hero.patterns.behavioral.observer.ReportObserver;

import java.time.LocalDateTime;

public class AuditObserver implements ReportObserver {
    @Override
    public void update(String reportName, String reportType, String userId) {
        System.out.println("  [AUDIT] Logging event...");
        System.out.println("  [AUDIT] " + LocalDateTime.now() +
                " | Report: " + reportName +
                " | Type: " + reportType +
                " | User: " + userId);
        System.out.println("  [AUDIT] Event logged successfully");
    }
}
