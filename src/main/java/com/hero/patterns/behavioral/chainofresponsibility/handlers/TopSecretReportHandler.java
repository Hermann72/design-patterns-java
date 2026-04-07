package com.hero.patterns.behavioral.chainofresponsibility.handlers;

import com.hero.patterns.behavioral.chainofresponsibility.ReportHandler;
import com.hero.patterns.behavioral.chainofresponsibility.ReportRequest;

public class TopSecretReportHandler extends ReportHandler {
    @Override
    protected boolean canHandle(ReportRequest request) {
        return request.getLevel() == ReportRequest.ConfidentialityLevel.TOP_SECRET;
    }

    @Override
    protected void process(ReportRequest request) {
        System.out.println("  [TOP SECRET HANDLER] Verifying executive clearance...");
        System.out.println("  [TOP SECRET HANDLER] Enabling audit trail...");
        System.out.println("  [TOP SECRET HANDLER] Applying maximum restrictions...");
        System.out.println("  [TOP SECRET HANDLER] " + request.getRequestedBy() +
                " granted TOP SECRET access to: " + request.getReportName() + " ✓");
    }

    @Override
    protected String getHandlerName() {
        return "TOP SECRET HANDLER";
    }
}
