package com.hero.patterns.behavioral.observer;

public interface ReportObserver {
    void update(String reportName, String reportType, String userId);
}
