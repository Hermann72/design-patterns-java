package com.hero.patterns.behavioral.observer;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

public class ReportEventManager implements ReportSubject{

    private final List<ReportObserver> observers = new ArrayList<>();
    @Override
    public void register(ReportObserver observer) {
        observers.add(observer);
        System.out.println(" [SUBJECT] Registered: " +
                observer.getClass().getSimpleName());
    }

    @Override
    public void remove(ReportObserver observer) {
        observers.remove(observer);
        System.out.println(" [SUBJECT] Removed: " +
                observer.getClass().getSimpleName());
    }

    @Override
    public void notifyObservers(String reportName, String reportType, String userId) {
        System.out.println("  [SUBJECT] Notifying " + observers.size() + " observers...");
        // The Subject doesn't know who they are — it only notifies them
        observers.forEach(observer ->
                observer.update(reportName, reportType, userId)
        );
    }

    public void generateReport(String reportName, String reportType, String userId) {
        System.out.println("\n  [SUBJECT] Generating report: " + reportName);
        System.out.println("  [SUBJECT] Report generated successfully");
        notifyObservers(reportName, reportType, userId);
    }
}
