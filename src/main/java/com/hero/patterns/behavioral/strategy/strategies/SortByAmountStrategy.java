package com.hero.patterns.behavioral.strategy.strategies;

import com.hero.patterns.behavioral.strategy.ReportData;
import com.hero.patterns.behavioral.strategy.SortStrategy;

import java.util.Comparator;
import java.util.List;

public class SortByAmountStrategy implements SortStrategy {
    @Override
    public List<ReportData> sort(List<ReportData> reports) {
        return reports.stream()
                .sorted(Comparator.comparing(ReportData::getAmount).reversed())
                .toList();
    }

    @Override
    public String getStrategyName() {
        return "Sort by Amount (highest first)";
    }
}
