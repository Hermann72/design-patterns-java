package com.hero.patterns.structural.facade;

import com.hero.patterns.structural.facade.services.*;

import java.util.List;

public class ReportFacadeImpl implements ReportFacade {

    private final AuthenticationService authService;
    private final DataService dataService;
    private final ReportFormatterService formatterService;
    private final EmailService emailService;
    private final AuditService auditService;

    public ReportFacadeImpl() {
        this.authService = new AuthenticationService();
        this.dataService = new DataService();
        this.formatterService = new ReportFormatterService();
        this.emailService = new EmailService();
        this.auditService = new AuditService();
    }
    @Override
    public void generateAndSendReport(String userId, String reportType, String recipientEmail) {
        System.out.println("\n  >>> Starting report pipeline <<<");

        // Step 1 — Authentication
        if (!authService.authenticate(userId)) {
            System.out.println("  [FACADE] Access denied for user: " + userId);
            auditService.log(userId, "REPORT_DENIED", "Invalid user");
            return;
        }

        // Step 2 — Getting data
        List<String> data = dataService.fetchData(reportType);

        // Step 3 — Formatting report
        String role = authService.getRole(userId);
        String formatted = formatterService.format(
                reportType + " Report", userId + " (" + role + ")", data
        );

        // Step 4 — Sending by email
        emailService.send(recipientEmail, reportType + " Report", formatted);

        // Step 5 — Perform Auditing
        auditService.log(userId, "REPORT_GENERATED", "Type: " + reportType);

        System.out.println("  >>> Pipeline completed successfully <<<\n");
    }
}
