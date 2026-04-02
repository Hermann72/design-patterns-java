package com.hero.patterns.behavioral.observer.observers;

import com.hero.patterns.behavioral.observer.ReportObserver;

import java.time.LocalDateTime;

public class DashboardObserver implements ReportObserver {
    @Override
    public void update(String reportName, String reportType, String userId) {
        System.out.println("  [DASHBOARD] Updating metrics panel...");
        System.out.println("  [DASHBOARD] New report available: " + reportName);
        System.out.println("  [DASHBOARD] Timestamp: " + LocalDateTime.now());
        System.out.println("  [DASHBOARD] Panel updated successfully");
    }
}
