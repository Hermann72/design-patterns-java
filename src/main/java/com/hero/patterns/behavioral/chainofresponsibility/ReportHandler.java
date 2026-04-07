package com.hero.patterns.behavioral.chainofresponsibility;

public abstract class ReportHandler {

    // Reference to the next handler in the chain
    private ReportHandler next;

    // Return 'this' to allow smooth method chaining
    public ReportHandler setNext(ReportHandler next) {
        this.next = next;
        return next;
    }

    // Template Method — management skeleton
    public final void handle(ReportRequest request) {
        if (canHandle(request)) {
            process(request);
        } else if (next != null) {
            System.out.println("  [" + getHandlerName() + "] Cannot handle level: " +
                    request.getLevel() + " — passing to next handler...");
            next.handle(request);
        } else {
            // Default routine — no handler could handle it
            System.out.println("  [CHAIN] No handler available for: " + request);
            System.out.println("  [CHAIN] Request REJECTED — insufficient permissions");
        }
    }

    // Each handler decides if it can manage the request
    protected abstract boolean canHandle(ReportRequest request);

    // Specific logic of each handler
    protected abstract void process(ReportRequest request);

    // Handler name for logging
    protected abstract String getHandlerName();
}