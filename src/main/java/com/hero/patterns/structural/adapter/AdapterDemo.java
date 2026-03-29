package com.hero.patterns.structural.adapter;

import java.util.List;

public class AdapterDemo {

    // The client only knows ReportGenerator — they never know if it's legacy or modern.
    private static void processReport(ReportGenerator generator,
                                      String title, String content) {
        System.out.println("Format: " + generator.getFormat());
        generator.generate(title, content);
    }

    public static void run() {
        System.out.println("=== Adapter Pattern ===\n");

        // Modern generator — directly implements the interface
        ReportGenerator modernGenerator = new ReportGenerator() {
            @Override
            public void generate(String title, String content) {
                System.out.println("  [Modern] Generating report: " + title);
                System.out.println("  [Modern] Content: " + content);
                System.out.println("  [Modern] Report generated successfully\n");
            }

            @Override
            public String getFormat() {
                return "MODERN-JSON";
            }
        };

        // Legacy system adapted — the client doesn't know it's legacy.
        LegacyReportSystem legacySystem = new LegacyReportSystem();
        ReportGenerator adaptedLegacy = new ReportAdapter(legacySystem);

        // They are both used in exactly the same way — that's the Adapter.
        List<ReportGenerator> generators = List.of(modernGenerator, adaptedLegacy);

        System.out.println("-- Processing reports with different generators --\n");
        generators.forEach(generator ->
                processReport(generator, "Q1 Sales Report", "Sales data 2025")
        );

        // Demonstrate that the customer never knows what they're talking about
        System.out.println("-- Client code never changes regardless of generator --");
        System.out.println("Same interface, different implementations ✓");
    }
}