package com.hero.patterns.creational.prototype;

import java.util.List;

public class PrototypeDemo {

    public static void run() {
        System.out.println("=== Prototype Pattern ===\n");

        // Creating the base prototype — expensive, one-time task
        System.out.println("Creating base prototype (expensive operation)...\n");
        DocumentTemplate baseTemplate = new DocumentTemplate(
                "Corporate Base Template",
                "Acme Corp — Confidential",
                "Page {page} of {total}",
                null,
                List.of("Introduction", "Development", "Conclusions"),
                new DocumentTemplate.DocumentStyle("Arial", 12, "#000000")
        );

        // Clone and customize for each department — cheap
        System.out.println("-- Cloning for Sales department --");
        DocumentTemplate salesTemplate = baseTemplate.clone()
                .withName("Sales Report Q1")
                .withWatermark("CONFIDENTIAL")
                .addSection("Sales Metrics")
                .withFooter("Sales Dept © 2025");
        System.out.println(salesTemplate);

        System.out.println("-- Cloning for HR department --");
        DocumentTemplate hrTemplate = baseTemplate.clone()
                .withName("HR Annual Report")
                .withWatermark("INTERNAL USE ONLY")
                .addSection("Headcount Analysis");
        hrTemplate.getStyle().withPrimaryColor("#0000FF");
        System.out.println(hrTemplate);

        // Demonstrate that the base prototype was NOT modified
        System.out.println("-- Base prototype remains unchanged --");
        System.out.println(baseTemplate);

        // Demonstrate Deep Copy — the lists are independent
        System.out.println("-- Deep Copy verification --");
        System.out.println("Base sections: " + baseTemplate.getSections());
        System.out.println("Sales sections: " + salesTemplate.getSections());
        System.out.println("HR sections: " + hrTemplate.getSections());
        System.out.println("\nSame list object? " +
                (baseTemplate.getSections() == salesTemplate.getSections()));
    }
}