package com.hero.patterns.behavioral.chainofresponsibility;

public class ReportRequest {

    public enum ConfidentialityLevel {
        PUBLIC, INTERNAL, CONFIDENTIAL, TOP_SECRET
    }

    private final String reportName;
    private final String requestedBy;
    private final ConfidentialityLevel level;

    public ReportRequest(String reportName, String requestedBy,
                         ConfidentialityLevel level) {
        this.reportName = reportName;
        this.requestedBy = requestedBy;
        this.level = level;
    }

    public String getReportName() { return reportName; }
    public String getRequestedBy() { return requestedBy; }
    public ConfidentialityLevel getLevel() { return level; }

    @Override
    public String toString() {
        return "Report: " + reportName +
                " | Level: " + level +
                " | Requested by: " + requestedBy;
    }
}