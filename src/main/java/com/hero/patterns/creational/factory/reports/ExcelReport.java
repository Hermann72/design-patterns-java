package com.hero.patterns.creational.factory.reports;

import com.hero.patterns.creational.factory.Report;

public class ExcelReport implements Report {
    @Override
    public void generate() {
        System.out.println("Generating a report in Excel format...");
        System.out.println("  - Creating spreadsheets");
        System.out.println("  - Applying formulas");
        System.out.println("  - Excel report successfully generated");
    }

    @Override
    public String getFormat() {
        return "EXCEL";
    }
}
