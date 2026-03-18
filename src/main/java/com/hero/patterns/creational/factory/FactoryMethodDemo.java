package com.hero.patterns.creational.factory;

import com.hero.patterns.creational.factory.factories.CsvReportFactory;
import com.hero.patterns.creational.factory.factories.ExcelReportFactory;
import com.hero.patterns.creational.factory.factories.PdfReportFactory;

import java.util.List;

public class FactoryMethodDemo {

    // The client works with the interface, never with concrete classes.
    private static void processReport(ReportFactory factory) {
        Report report = factory.createReport();
        System.out.println("Format: " + report.getFormat());
        report.generate();
        System.out.println();
    }

    public static void run() {
        System.out.println("=== Factory Method Pattern ===\n");

        List<ReportFactory> factories = List.of(
                new PdfReportFactory(),
                new ExcelReportFactory(),
                new CsvReportFactory()
        );

        factories.forEach(FactoryMethodDemo::processReport);

        // Demonstrate scalability: the processReport method never changes
        System.out.println("--- If XML arrives tomorrow, we'll just add: ---");
        System.out.println("  1. XmlReport implements Report");
        System.out.println("  2. XmlReportFactory implements ReportFactory");
        System.out.println("  3. processReport() It is not modified.");
    }
}
