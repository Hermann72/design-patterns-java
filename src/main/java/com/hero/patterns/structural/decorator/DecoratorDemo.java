package com.hero.patterns.structural.decorator;

public class DecoratorDemo {

    public static void run() {
        System.out.println("=== Decorator Pattern ===\n");

        // 1. Basic report without decorators
        System.out.println("-- Basic report --");
        ReportGenerator basic = new BasicReportGenerator();
        System.out.println("Format: " + basic.getFormat());
        System.out.println(basic.generate("Sales Q1", "Revenue: $500,000"));

        // 2. Logging only
        System.out.println("-- With Logging --");
        ReportGenerator withLogging = new LoggingDecorator(
                new BasicReportGenerator()
        );
        System.out.println("Format: " + withLogging.getFormat());
        System.out.println(withLogging.generate("Sales Q1", "Revenue: $500,000"));

        // 3. Logging + encryption
        System.out.println("-- With Logging + Encryption --");
        ReportGenerator withLoggingAndEncryption = new EncryptionDecorator(
                new LoggingDecorator(
                        new BasicReportGenerator()
                )
        );
        System.out.println("Format: " + withLoggingAndEncryption.getFormat());
        System.out.println(withLoggingAndEncryption.generate("Sales Q1", "Revenue: $500,000"));

        // Demonstrate flexibility — different order, same result
        System.out.println("-- Logging + Compression (sin encryption) --");
        ReportGenerator withoutEncryption = new CompressionDecorator(
                new LoggingDecorator(
                        new BasicReportGenerator()
                )
        );
        System.out.println("Format: " + withoutEncryption.getFormat());
        System.out.println(withoutEncryption.generate("Sales Q1", "Revenue: $500,000"));
    }
}

