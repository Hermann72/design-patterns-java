package com.hero.patterns.structural.facade;

public interface ReportFacade {
    void generateAndSendReport(String userId, String reportType, String recipientEmail);
}
