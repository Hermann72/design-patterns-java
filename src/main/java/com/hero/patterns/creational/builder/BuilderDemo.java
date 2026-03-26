package com.hero.patterns.creational.builder;

import com.hero.patterns.creational.builder.Report;

import java.time.LocalDate;

public class BuilderDemo {

    public static void run() {
        System.out.println("=== Builder Pattern ===\n");

        // Simple Report — only required attributes
        Report simpleReport = Report.builder("Monthly Summary", "Carlos Pérez")
                .generatedDate(LocalDate.now())
                .includePageNumbers(true)
                .build();

        System.out.println("-- Simple report --");
        System.out.println(simpleReport);

        // Complete Report — All attributes
        Report fullReport = Report.builder("Q1 Sales Report", "María González")
                .watermark("CONFIDENTIAL")
                .footer("Acme Corp © 2025")
                .generatedDate(LocalDate.of(2025, 3, 31))
                .includeCharts(true)
                .includePageNumbers(true)
                .addSection("Executive Summary")
                .addSection("Regional Analysis")
                .addSection("Conclusions")
                .build();

        System.out.println("-- Full report --");
        System.out.println(fullReport);

        // Demonstrate validation in build()
        System.out.println("-- Validation in build() --");
        try {
            Report invalidReport = Report.builder("Invalid Report", "Test")
                    .includeCharts(true) // charts without sections — must fail
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }

        // Demonstrate immutability
        System.out.println("\n-- Immutability --");
        try {
            fullReport.getSections().add("Unauthorized section");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify the report after build() — immutability guaranteed ✓");
        }
    }
}