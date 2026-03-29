package com.hero.patterns.structural.decorator;

import java.time.LocalDateTime;

public class LoggingDecorator extends ReportDecorator {
    public LoggingDecorator(ReportGenerator wrapped) {
        super(wrapped);
    }

    @Override
    public String generate(String title, String content) {
        System.out.println("  [LOG " + LocalDateTime.now() + "] Starting report generation: " + title);
        String result = wrapped.generate(title, content); // Delega al siguiente
        System.out.println("  [LOG " + LocalDateTime.now() + "] Report generation completed");
        return result;
    }

    @Override
    public String getFormat() {
        return wrapped.getFormat() + "+LOGGING";
    }
}
