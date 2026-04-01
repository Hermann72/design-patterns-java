package com.hero.patterns.behavioral.strategy;

import java.time.LocalDate;

public class ReportData {

    private final String name;
    private final double amount;
    private final LocalDate date;
    private final String region;

    public ReportData(String name, double amount, LocalDate date, String region) {
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.region = region;
    }

    public String getName() { return name; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public String getRegion() { return  region; }

    @Override
    public String toString() {
        return "%-30s | $%10.2f | %s | %s"
                .formatted(name, amount, date, region);
    }
}
