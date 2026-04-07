package com.hero.patterns.behavioral.chainofresponsibility;

import com.hero.patterns.behavioral.chainofresponsibility.handlers.ConfidentialReportHandler;
import com.hero.patterns.behavioral.chainofresponsibility.handlers.InternalReportHandler;
import com.hero.patterns.behavioral.chainofresponsibility.handlers.PublicReportHandler;
import com.hero.patterns.behavioral.chainofresponsibility.handlers.TopSecretReportHandler;

public class ChainDemo {

    public static void run() {
        System.out.println("=== Chain of Responsibility Pattern ===\n");

        // Building the chain — order matters
        PublicReportHandler publicHandler = new PublicReportHandler();
        InternalReportHandler internalHandler = new InternalReportHandler();
        ConfidentialReportHandler confidentialHandler = new ConfidentialReportHandler();
        TopSecretReportHandler topSecretHandler = new TopSecretReportHandler();

        // Fluid chaining — setNext() returns the next handler
        publicHandler
                .setNext(internalHandler)
                .setNext(confidentialHandler)
                .setNext(topSecretHandler);

        // All requests enter through the first handler
        System.out.println("-- Request 1: PUBLIC report --");
        publicHandler.handle(new ReportRequest(
                "Marketing Brochure", "juan", ReportRequest.ConfidentialityLevel.PUBLIC));

        System.out.println("\n-- Request 2: INTERNAL report --");
        publicHandler.handle(new ReportRequest(
                "HR Headcount", "maria", ReportRequest.ConfidentialityLevel.INTERNAL));

        System.out.println("\n-- Request 3: CONFIDENTIAL report --");
        publicHandler.handle(new ReportRequest(
                "Sales Strategy", "carlos", ReportRequest.ConfidentialityLevel.CONFIDENTIAL));

        System.out.println("\n-- Request 4: TOP SECRET report --");
        publicHandler.handle(new ReportRequest(
                "M&A Analysis", "ceo_pedro", ReportRequest.ConfidentialityLevel.TOP_SECRET));

        // Demonstrate default routine — no handler string for this level
        System.out.println("\n-- Request 5: No handler available (broken chain) --");
        ReportHandler onlyPublic = new PublicReportHandler(); // Sin next
        onlyPublic.handle(new ReportRequest(
                "Board Report", "analyst", ReportRequest.ConfidentialityLevel.CONFIDENTIAL));

        // Demonstrate decoupling
        System.out.println("\n-- Chain guarantees --");
        System.out.println("Client always sends to first handler ✓");
        System.out.println("Client never knows which handler processed the request ✓");
        System.out.println("Adding new levels never modifies existing handlers ✓");
    }
}