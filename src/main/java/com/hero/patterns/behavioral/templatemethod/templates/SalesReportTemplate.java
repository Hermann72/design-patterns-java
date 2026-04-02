package com.hero.patterns.behavioral.templatemethod.templates;

import com.hero.patterns.behavioral.templatemethod.ReportTemplate;

public class SalesReportTemplate extends ReportTemplate {

    @Override
    protected String fetchData() {
        System.out.println("  [SALES] Fetching sales data from CRM...");
        return "Q1: $500,000 | Q2: $620,000 | Q3: $480,000 | Q4: $710,000";
    }

    @Override
    protected String formatReport(String data) {
        System.out.println("  [SALES] Formatting as sales dashboard...");
        return """
                ==========================================
                SALES REPORT
                ------------------------------------------
                %s
                ------------------------------------------
                Total Annual: $2,310,000
                Growth vs last year: +12%%
                ==========================================
                """.formatted(data);
    }

    // Override the hook to add extra behavior when exporting
    @Override
    protected void export(String formattedReport) {
        super.export(formattedReport); // Base export
        System.out.println("  [SALES] Sending copy to Sales Manager via email...");
    }
}