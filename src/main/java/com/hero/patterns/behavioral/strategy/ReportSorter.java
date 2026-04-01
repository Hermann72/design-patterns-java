package com.hero.patterns.behavioral.strategy;

import com.hero.patterns.behavioral.strategy.strategies.SortByNameStrategy;

import java.util.List;

public class ReportSorter {

    // Reference to the interface — never to a specific class
    private SortStrategy strategy;

    public ReportSorter() {
        this.strategy = new SortByNameStrategy();
    }

    // Dynamic runtime strategy change
    public void setStrategy(SortStrategy strategy) {
        System.out.println("  [CONTEXT] Switching strategy to: " + strategy.getStrategyName());
        this.strategy = strategy;
    }

    // Context delegates — it doesn't know or care how things are ordered
    public List<ReportData> sort(List<ReportData> reports) {
        System.out.println("  [CONTEXT] Executing: " + strategy.getStrategyName());
        return strategy.sort(reports);
    }
}
