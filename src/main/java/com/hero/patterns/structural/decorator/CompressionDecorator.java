package com.hero.patterns.structural.decorator;

public class CompressionDecorator extends ReportDecorator {
    public CompressionDecorator(ReportGenerator wrapped) {
        super(wrapped);
    }

    @Override
    public String generate(String title, String content) {
        String result = wrapped.generate(title, content); // Delegates first
        System.out.println("  [COMPRESSION] Compressing report...");
        int originalSize = result.getBytes().length;
        // We simulated compression — in real life you would use GZIPOutputStream
        String compressed = "[COMPRESSED:" + originalSize + "bytes->~" +
                (originalSize / 3) + "bytes] " +
                result.substring(0, Math.min(20, result.length())) + "...";
        return compressed;
    }

    @Override
    public String getFormat() {
        return wrapped.getFormat() + "+COMPRESSED";
    }
}
