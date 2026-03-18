package com.hero.patterns.creational.factory.reports;

import com.hero.patterns.creational.factory.Report;

public class PdfReport implements Report {
    @Override
    public void generate() {
        System.out.println("Generating a report in PDF format...");
        System.out.println(" - Applying margins and styles");
        System.out.println(" - Embedding fonts");
        System.out.println(" - PDF report successfully generated");
    }

    @Override
    public String getFormat() {
        return "PDF";
    }
}
