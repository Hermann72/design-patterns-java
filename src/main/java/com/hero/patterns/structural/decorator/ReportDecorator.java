package com.hero.patterns.structural.decorator;

public abstract class ReportDecorator implements ReportGenerator {

    // Reference to the wrapped component
    protected final ReportGenerator wrapped;
    public ReportDecorator(ReportGenerator wrapped) {
        this.wrapped = wrapped;
    }

    // Delegates by default to the wrapped component
    // Subclasses override to add behavior
    @Override
    public String generate(String title, String content) {
        return wrapped.generate(title, content);
    }

    @Override
    public String getFormat() {
        return wrapped.getFormat();
    }
}
