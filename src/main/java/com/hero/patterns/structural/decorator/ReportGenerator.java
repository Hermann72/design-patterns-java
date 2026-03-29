package com.hero.patterns.structural.decorator;

public interface ReportGenerator {
    String generate(String title, String content);
    String getFormat();
}
