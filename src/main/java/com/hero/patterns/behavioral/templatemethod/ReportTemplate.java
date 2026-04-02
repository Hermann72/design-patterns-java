package com.hero.patterns.behavioral.templatemethod;

public abstract class ReportTemplate {

    // Template Method — final so that no one can modify the skeleton
    public final void generateReport(String userId) {
        System.out.println("  [TEMPLATE] Starting report generation pipeline...");
        authenticate(userId);
        String data = fetchData();
        String formatted = formatReport(data);
        export(formatted);
        System.out.println("  [TEMPLATE] Pipeline completed successfully\n");
    }

    // Fixed step — same for all reports
    private void authenticate(String userId) {
        System.out.println("  [TEMPLATE] Authenticating user: " + userId + " ... OK");
    }

    // Variable step — each subclass gets its own data
    protected abstract String fetchData();

    // Variable step — each subclass formats in its own way
    protected abstract String formatReport(String data);

    // Fixed step — the same for everyone, but subclasses can extend it (hook)
    protected void export(String formattedReport) {
        System.out.println("  [TEMPLATE] Exporting report...");
        System.out.println(formattedReport);
    }
}