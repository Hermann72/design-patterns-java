package com.hero.patterns.behavioral.strategy;

import com.hero.patterns.behavioral.strategy.strategies.SortByAmountStrategy;
import com.hero.patterns.behavioral.strategy.strategies.SortByDateStrategy;


import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class StrategyDemo {

    public static void run() {
        System.out.println("=== Strategy Pattern ===\n");

        // Reports dataset
        List<ReportData> reports = List.of(
                new ReportData("Sales Q3 2025",    480_000, LocalDate.of(2025, 9, 30),  "North"),
                new ReportData("Annual HR 2025",   125_000, LocalDate.of(2025, 12, 31), "Central"),
                new ReportData("Sales Q1 2025",    500_000, LocalDate.of(2025, 3, 31),  "South"),
                new ReportData("Tech Infra 2025",  320_000, LocalDate.of(2025, 6, 15),  "North"),
                new ReportData("Sales Q4 2025",    710_000, LocalDate.of(2025, 12, 31), "East"),
                new ReportData("Marketing Q2",     215_000, LocalDate.of(2025, 6, 30),  "West")
        );

        // Context with default strategy
        ReportSorter sorter = new ReportSorter();

        // Strategy 1 — by name (default)
        System.out.println("-- Strategy: Sort by Name --");
        printReports(sorter.sort(reports));

        // Dynamic change — by date
        System.out.println("-- Strategy: Sort by Date --");
        sorter.setStrategy(new SortByDateStrategy());
        printReports(sorter.sort(reports));

        // Dynamic change — by amount
        System.out.println("-- Strategy: Sort by Amount --");
        sorter.setStrategy(new SortByAmountStrategy());
        printReports(sorter.sort(reports));

        // Demonstrate that adding a new strategy does not affect anything existing.
        System.out.println("-- Adding new Strategy: Sort by Region --");
        sorter.setStrategy(new SortStrategy() {
            @Override
            public List<ReportData> sort(List<ReportData> reports1) {
                return reports1.stream()
                        .sorted(Comparator.comparing(ReportData::getRegion))
                        .toList();
            }

            @Override
            public String getStrategyName() {
                return "Sort by Region (A-Z)";
            }
        });
        printReports(sorter.sort(reports));

    }

    private static void printReports(List<ReportData> reports) {
        System.out.println("  " + "-".repeat(65));
        reports.forEach(r -> System.out.println("  " + r));
        System.out.println("  " + "-".repeat(65) + "\n");
    }
}