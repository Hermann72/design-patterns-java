package com.hero.patterns.structural.decorator;

public class BasicReportGenerator implements ReportGenerator {
    @Override
    public String generate(String title, String content) {
        return """
                === REPORT ===
                Title: %s
                Content: %s
                === END ===
                """.formatted(title, content);
    }

    @Override
    public String getFormat() {
        return "BASIC";
    }
}
