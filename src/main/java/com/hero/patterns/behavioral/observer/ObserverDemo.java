package com.hero.patterns.behavioral.observer;

import com.hero.patterns.behavioral.observer.observers.AuditObserver;
import com.hero.patterns.behavioral.observer.observers.DashboardObserver;
import com.hero.patterns.behavioral.observer.observers.EmailObserver;

public class ObserverDemo {

    public static void run() {
        System.out.println("=== Observer Pattern ===\n");

        ReportEventManager manager = new ReportEventManager();

        // Register observers
        System.out.println("-- Registering observers --");
        EmailObserver emailObserver = new EmailObserver("admin@acme.com");
        DashboardObserver dashboardObserver = new DashboardObserver();
        AuditObserver auditObserver = new AuditObserver();

        manager.register(emailObserver);
        manager.register(dashboardObserver);
        manager.register(auditObserver);

        // Generate report — notify all observers
        System.out.println("\n-- Generating report 1: all observers active --");
        manager.generateReport("Sales Q1 2025", "SALES", "carlos");

        // Unsubscribe the dashboard
        System.out.println("\n-- Removing DashboardObserver --");
        manager.remove(dashboardObserver);

        // Generate another report — dashboard no longer receives notifications
        System.out.println("\n-- Generating report 2: dashboard unsubscribed --");
        manager.generateReport("HR Annual 2025", "HR", "maria");

        // Agregate a second email observer — without touching anything existing
        System.out.println("\n-- Adding second EmailObserver --");
        manager.register(new EmailObserver("manager@acme.com"));

        // Generate third report — two emails, one audit
        System.out.println("\n-- Generating report 3: two email observers --");
        manager.generateReport("Tech Infra 2025", "TECH", "carlos");

        // Demonstrate decoupling
        System.out.println("\n-- Decoupling demonstration --");
        System.out.println("ReportEventManager never imported EmailObserver directly");
        System.out.println("ReportEventManager never imported DashboardObserver directly");
        System.out.println("ReportEventManager never imported AuditObserver directly");
        System.out.println("It only knows ReportObserver interface ✓");
    }
}