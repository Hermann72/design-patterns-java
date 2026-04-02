package com.hero.patterns.behavioral.templatemethod.templates;

import com.hero.patterns.behavioral.templatemethod.ReportTemplate;

public class HRReportTemplate extends ReportTemplate {

    @Override
    protected String fetchData() {
        System.out.println("  [HR] Fetching headcount data from HRMS...");
        return "Headcount: 150 | New hires: 20 | Attrition: 5% | Avg salary: $45,000";
    }

    @Override
    protected String formatReport(String data) {
        System.out.println("  [HR] Formatting as HR summary...");
        return """
                ==========================================
                HR ANNUAL REPORT
                ------------------------------------------
                %s
                ------------------------------------------
                Department with most growth: Engineering
                Recommended action: Open 5 new positions
                ==========================================
                """.formatted(data);
    }
    // It does not override export() — it uses the template's base behavior.
}