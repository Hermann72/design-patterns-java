package com.hero.patterns.creational.factory.reports;

import com.hero.patterns.creational.factory.Report;

public class CsvReport implements Report {
    @Override
    public void generate() {
        System.out.println("Generating a report in CSV format...");
        System.out.println("  - Delimiting fields");
        System.out.println("  - Escaping special characters");
        System.out.println("  - CSV report successfully generated");
    }

    @Override
    public String getFormat() {
        return "CSV";
    }
}
