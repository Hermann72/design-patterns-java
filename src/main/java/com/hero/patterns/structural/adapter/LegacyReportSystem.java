package com.hero.patterns.structural.adapter;

public class LegacyReportSystem {

    // Legacy System — we can not modify this code
    public String generateTextReport(String reportName, String data) {
        return """
                *** LEGACY REPORT SYSTEM ***
                Report Name: %s
                -------------------------
                Data: %s
                *** END OF REPORT ***
                """.formatted(reportName, data);
    }

    public String getReportData(String source) {
        // Simulates getting data from a legacy source
        return "Raw data from legacy source: " + source;
    }
}