package com.hero.patterns.behavioral.chainofresponsibility.handlers;

import com.hero.patterns.behavioral.chainofresponsibility.ReportHandler;
import com.hero.patterns.behavioral.chainofresponsibility.ReportRequest;

public class InternalReportHandler extends ReportHandler {
    @Override
    protected boolean canHandle(ReportRequest request) {
        return request.getLevel() == ReportRequest.ConfidentialityLevel.INTERNAL;
    }

    @Override
    protected void process(ReportRequest request) {
        System.out.println("  [INTERNAL HANDLER] Verifying employee status...");
        System.out.println("  [INTERNAL HANDLER] " + request.getRequestedBy() +
                " is a verified employee");
        System.out.println("  [INTERNAL HANDLER] Access granted to: " +
                request.getReportName() + " ✓");
    }

    @Override
    protected String getHandlerName() {
        return "INTERNAL HANDLER";
    }
}
