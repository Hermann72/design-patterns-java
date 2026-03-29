package com.hero.patterns.structural.adapter;

public interface ReportGenerator {
    void generate(String title, String content);
    String getFormat();
}
