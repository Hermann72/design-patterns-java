package com.hero.patterns.structural.composite;

public class ReportLeaf implements ReportComponent {

    private final String name;
    private final String type;
    private final int sizeKb;

    public ReportLeaf(String name, String type, int sizeKb) {
        this.name = name;
        this.type = type;
        this.sizeKb = sizeKb;
    }
    @Override
    public void display(String indent) {
        System.out.println(indent + "[FILE] " + name + " [" + type + ", " + sizeKb + "KB]");
    }

    @Override
    public int getSize() {
        return sizeKb;
    }

    @Override
    public String getName() {
        return name;
    }
}
