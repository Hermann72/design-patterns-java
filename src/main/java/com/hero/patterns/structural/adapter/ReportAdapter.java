package com.hero.patterns.structural.adapter;

public class ReportAdapter implements ReportGenerator {

    // Composition — contains a reference to the legacy system
    private final LegacyReportSystem legacySystem;

    public ReportAdapter(LegacyReportSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public void generate(String title, String content) {
        // Translate the modern call into the format that the legacy system understands.
        String legacyData = legacySystem.getReportData(content);
        String result = legacySystem.generateTextReport(title, legacyData);
        System.out.println("  [Adapter] Translating modern call to legacy system...");
        System.out.println(result);
    }

    @Override
    public String getFormat() {
        return "LEGACY-TXT";
    }
}