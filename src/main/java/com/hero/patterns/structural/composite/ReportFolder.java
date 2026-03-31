package com.hero.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;


public class ReportFolder implements ReportComponent {

    private final String name;
    private final List<ReportComponent> children = new ArrayList<>();

    public ReportFolder(String name) {
        this.name = name;
    }
    public void add(ReportComponent component) {
        children.add(component);
    }

    public void remove(ReportComponent component) {
        children.remove(component);
    }
    @Override
    public void display(String indent) {
        System.out.println(indent + "[DIR] " + name +
                " [" + children.size() + " items, " + getSize() + "KB total]");
        // Natural recursion — each child knows how to present themselves
        children.forEach(child -> child.display(indent + "   "));
    }

    @Override
    public int getSize() {
        // Recursive addition — works regardless of the depth of the tree
        return children.stream()
                .mapToInt(ReportComponent::getSize)
                .sum();
    }

    @Override
    public String getName() {
        return name;
    }
}
