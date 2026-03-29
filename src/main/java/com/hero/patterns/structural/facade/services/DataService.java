package com.hero.patterns.structural.facade.services;

import java.util.List;

public class DataService {

    public List<String > fetchData(String reportType) {
        System.out.println("  [DATA] Fetching data for report type: " + reportType);
        // Simulates a database query
        return switch (reportType) {
            case "SALES" -> List.of("Q1: $500,000", "Q2: $620,000", "Q3: $480,000", "Q4: $710,000");
            case "HR"    -> List.of("Headcount: 150", "New hires: 20", "Attrition: 5%");
            default      -> List.of("No data available for: " + reportType);
        };
    }
}
