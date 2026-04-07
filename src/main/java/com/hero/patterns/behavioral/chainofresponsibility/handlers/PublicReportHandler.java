package com.hero.patterns.behavioral.chainofresponsibility.handlers;

import com.hero.patterns.behavioral.chainofresponsibility.ReportHandler;
import com.hero.patterns.behavioral.chainofresponsibility.ReportRequest;

public class PublicReportHandler extends ReportHandler {

    @Override
    protected boolean canHandle(ReportRequest request) {
        return request.getLevel() == ReportRequest.ConfidentialityLevel.PUBLIC;
    }

    @Override
    protected void process(ReportRequest request) {
        System.out.println("  [PUBLIC HANDLER] Approving public report access");
        System.out.println("  [PUBLIC HANDLER] " + request.getRequestedBy() +
                " can access: " + request.getReportName());
        System.out.println("  [PUBLIC HANDLER] No restrictions applied ✓");
    }

    @Override
    protected String getHandlerName() {
        return "PUBLIC HANDLER";
    }
}