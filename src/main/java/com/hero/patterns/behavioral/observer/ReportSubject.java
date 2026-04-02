package com.hero.patterns.behavioral.observer;

public interface ReportSubject {
    void register(ReportObserver observer);
    void remove(ReportObserver observer);
    void notifyObservers(String reportName, String reportType, String userId);
}
