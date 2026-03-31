package com.hero.patterns.structural.proxy;

public class RealReportService implements ReportService {
    @Override
    public String generateReport(String reportType, String userId) {
        System.out.println("  [REAL SERVICE] Generating report: " + reportType +
                " for user: " + userId);
        simulateExpensiveOperation();
        String result = """
                === REPORT: %s ===
                Generated for: %s
                Data: Revenue $500,000 | Units: 1,200 | Growth: 12%%
                ==============================
                """.formatted(reportType, userId);
        System.out.println("  [REAL SERVICE] Report generated successfully");
        return result;
    }

    private void simulateExpensiveOperation() {
        try {
            System.out.println("  [REAL SERVICE] Querying database...");
            Thread.sleep(1000); // Simulate expensive operation
            System.out.println("  [REAL SERVICE] Processing data...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

