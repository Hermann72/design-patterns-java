package com.hero.patterns.behavioral.strategy;

import java.util.List;

public interface SortStrategy {
    List<ReportData> sort(List<ReportData> reports);
    String getStrategyName();
}
