package com.hero.patterns.structural.composite;

public interface ReportComponent {
    void display(String indent);
    int getSize();
    String getName();
}
