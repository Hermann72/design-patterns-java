package com.hero.patterns.structural.facade;

public class FacadeDemo {

    public static void run() {
        System.out.println("=== Facade Pattern ===\n");

        // The client only knows ReportFacade — a single line of interaction
        ReportFacade facade = new ReportFacadeImpl();

        System.out.println("-- Request 1: Valid user, SALES report --");
        facade.generateAndSendReport("admin_carlos", "SALES", "carlos@acme.com");

        System.out.println("-- Request 2: Valid user, HR report --");
        facade.generateAndSendReport("maria_gonzalez", "HR", "maria@acme.com");

        System.out.println("-- Request 3: Invalid user --");
        facade.generateAndSendReport("", "SALES", "unknown@acme.com");

        // Demonstrate simplicity for the client
        System.out.println("-- Client perspective --");
        System.out.println("Client calls ONE method: generateAndSendReport()");
        System.out.println("Client knows ZERO subsystems: Auth, Data, Formatter, Email, Audit");
        System.out.println("Facade orchestrates everything internally ✓");
    }
}
