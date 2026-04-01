package com.hero.patterns.behavioral.strategy.strategies;

import com.hero.patterns.behavioral.strategy.ReportData;
import com.hero.patterns.behavioral.strategy.SortStrategy;

import java.util.Comparator;
import java.util.List;

public class SortByNameStrategy implements SortStrategy {
    @Override
    public List<ReportData> sort(List<ReportData> reports) {
        return reports.stream()
                .sorted(Comparator.comparing(ReportData::getName))
                .toList();
    }

    @Override
    public String getStrategyName() {
        return "Sort by Name (A-Z)";
    }
}
