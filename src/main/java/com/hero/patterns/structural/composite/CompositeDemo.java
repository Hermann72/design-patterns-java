package com.hero.patterns.structural.composite;

public class CompositeDemo {

    public static void run() {
        System.out.println("=== Composite Pattern ===\n");

        // Individual report (leafs)
        ReportLeaf salesQ1 = new ReportLeaf("Sales_Q1.pdf", "PDF", 120);
        ReportLeaf salesQ2 = new ReportLeaf("Sales_Q2.pdf", "PDF", 135);
        ReportLeaf salesQ3 = new ReportLeaf("Sales_Q3.pdf", "PDF", 98);
        ReportLeaf salesQ4 = new ReportLeaf("Sales_Q4.pdf", "PDF", 145);

        ReportLeaf hrAnnual = new ReportLeaf("HR_Annual.xlsx", "EXCEL", 230);
        ReportLeaf hrHeadcount = new ReportLeaf("HR_Headcount.xlsx", "EXCEL", 85);

        ReportLeaf techInfra = new ReportLeaf("Tech_Infrastructure.pdf", "PDF", 310);
        ReportLeaf techSecurity = new ReportLeaf("Tech_Security.pdf", "PDF", 275);

        // Folders by department
        ReportFolder salesFolder = new ReportFolder("Sales Reports");
        salesFolder.add(salesQ1);
        salesFolder.add(salesQ2);
        salesFolder.add(salesQ3);
        salesFolder.add(salesQ4);

        ReportFolder hrFolder = new ReportFolder("HR Reports");
        hrFolder.add(hrAnnual);
        hrFolder.add(hrHeadcount);

        ReportFolder techFolder = new ReportFolder("Tech Reports");
        techFolder.add(techInfra);
        techFolder.add(techSecurity);

        // Annual folder that contains all the folders — composite of composites
        ReportFolder annualFolder = new ReportFolder("Annual Reports 2025");
        annualFolder.add(salesFolder);
        annualFolder.add(hrFolder);
        annualFolder.add(techFolder);

        // Display all the hierarchy — only one call, any depth
        System.out.println("-- Full report hierarchy --");
        annualFolder.display("");

        // The client treats a leaf and a folder the same.
        System.out.println("\n-- Uniform treatment: leaf vs folder --");
        System.out.println("Calling display() on a leaf:");
        salesQ1.display("  ");
        System.out.println("Calling display() on a folder:");
        salesFolder.display("  ");

        // Sizes calculated recursively
        System.out.println("\n-- Recursive size calculation --");
        System.out.println("salesQ1 size: " + salesQ1.getSize() + "KB");
        System.out.println("salesFolder size: " + salesFolder.getSize() + "KB");
        System.out.println("annualFolder total size: " + annualFolder.getSize() + "KB");

        // Prove that there is no instanceof anywhere
        System.out.println("\n-- No instanceof checks needed --");
        System.out.println("Client calls display() and getSize() uniformly ✓");
        System.out.println("Polymorphism handles the rest ✓");
    }
}
