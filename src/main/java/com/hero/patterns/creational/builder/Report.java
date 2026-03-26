package com.hero.patterns.creational.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Report {

    // Required attributes
    private final String title;
    private final String author;

    // Optional attributes
    private final String watermark;
    private final String footer;
    private final LocalDate generatedDate;
    private final boolean includeCharts;
    private final boolean includePageNumbers;
    private final List<String> sections;

    // Private Builder — only the Builder can build a Report
    private Report(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.watermark = builder.watermark;
        this.footer = builder.footer;
        this.generatedDate = builder.generatedDate;
        this.includeCharts = builder.includeCharts;
        this.includePageNumbers = builder.includePageNumbers;
        this.sections = Collections.unmodifiableList(builder.sections);
    }

    // Only getters — immutable object, without setters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getWatermark() { return watermark; }
    public String getFooter() { return footer; }
    public LocalDate getGeneratedDate() { return generatedDate; }
    public boolean isIncludeCharts() { return includeCharts; }
    public boolean isIncludePageNumbers() { return includePageNumbers; }
    public List<String> getSections() { return sections; }

    @Override
    public String toString() {
        return """
                ==========================================
                Report: %s
                Author: %s
                Date: %s
                Watermark: %s
                Footer: %s
                Include charts: %s
                Include page numbers: %s
                Sections: %s
                ==========================================
                """.formatted(
                title,
                author,
                generatedDate != null ? generatedDate : "Not specified",
                watermark != null ? watermark : "None",
                footer != null ? footer : "None",
                includeCharts ? "Yes" : "No",
                includePageNumbers ? "Yes" : "No",
                sections.isEmpty() ? "None" : String.join(", ", sections)
        );
    }

    // Statico method to start the builder chain
    public static Builder builder(String title, String author) {
        return new Builder(title, author);
    }

    // ============================================
    // Builder class static, nested
    // Being a nested static class, can access
    // the Report's private constructor.
    // ============================================
    public static class Builder {

        // Required Attributes
        private final String title;
        private final String author;

        // Optional Attributes with default values
        private String watermark = null;
        private String footer = null;
        private LocalDate generatedDate = null;
        private boolean includeCharts = false;
        private boolean includePageNumbers = false;
        private List<String> sections = new ArrayList<>();

        // Builder only receives required attributes
        private Builder(String title, String author) {
            if (title == null || title.isBlank()) {
                throw new IllegalArgumentException("Title is required");
            }
            if (author == null || author.isBlank()) {
                throw new IllegalArgumentException("Author is required");
            }
            this.title = title;
            this.author = author;
        }

        // Each method returns 'this' to allow smooth chaining
        public Builder watermark(String watermark) {
            this.watermark = watermark;
            return this;
        }

        public Builder footer(String footer) {
            this.footer = footer;
            return this;
        }

        public Builder generatedDate(LocalDate date) {
            this.generatedDate = date;
            return this;
        }

        public Builder includeCharts(boolean includeCharts) {
            this.includeCharts = includeCharts;
            return this;
        }

        public Builder includePageNumbers(boolean includePageNumbers) {
            this.includePageNumbers = includePageNumbers;
            return this;
        }

        public Builder addSection(String section) {
            this.sections.add(section);
            return this;
        }

        // Build and validate the final object
        public Report build() {
            validate();
            return new Report(this);
        }

        private void validate() {
            if (includeCharts && sections.isEmpty()) {
                throw new IllegalStateException(
                        "A report with charts must have at least one section"
                );
            }
        }
    }
}
