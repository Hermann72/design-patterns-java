package com.hero.patterns.behavioral.command.receiver;

import java.util.ArrayList;
import java.util.List;

public class ReportReceiver {
    private final List<String> reports = new ArrayList<>();

    public void createReport(String reportName) {
        reports.add(reportName);
        System.out.println("  [RECEIVER] Report created: " + reportName);
        System.out.println("  [RECEIVER] Total reports: " + reports.size());
    }

    public void deleteReport(String reportName) {
        reports.remove(reportName);
        System.out.println("  [RECEIVER] Report deleted: " + reportName);
        System.out.println("  [RECEIVER] Total reports: " + reports.size());
    }

    public void exportReport(String reportName, String format) {
        System.out.println("  [RECEIVER] Exporting: " + reportName + " as " + format);
        System.out.println("  [RECEIVER] Export completed successfully");
    }

    public void undoExport(String reportName, String format) {
        System.out.println("  [RECEIVER] Undoing export: " + reportName + " [" + format + "]");
        System.out.println("  [RECEIVER] Export file removed");
    }

    public List<String> getReports() {
        return reports;
    }
}
