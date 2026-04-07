package com.hero.patterns.behavioral.chainofresponsibility.handlers;

import com.hero.patterns.behavioral.chainofresponsibility.ReportHandler;
import com.hero.patterns.behavioral.chainofresponsibility.ReportRequest;

public class ConfidentialReportHandler extends ReportHandler {
    @Override
    protected boolean canHandle(ReportRequest request) {
        return request.getLevel() == ReportRequest.ConfidentialityLevel.CONFIDENTIAL;
    }

    @Override
    protected void process(ReportRequest request) {
        System.out.println("  [CONFIDENTIAL HANDLER] Verifying management clearance...");
        System.out.println("  [CONFIDENTIAL HANDLER] Applying access restrictions...");
        System.out.println("  [CONFIDENTIAL HANDLER] " + request.getRequestedBy() +
                " granted restricted access to: " + request.getReportName() + " ✓");
    }

    @Override
    protected String getHandlerName() {
        return "CONFIDENTIAL HANDLER";
    }
}
