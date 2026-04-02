package com.hero.patterns.behavioral.command.commands;

import com.hero.patterns.behavioral.command.Command;
import com.hero.patterns.behavioral.command.receiver.ReportReceiver;

public class CreateReportCommand implements Command {

    private final ReportReceiver receiver;
    private final String reportName;

    public CreateReportCommand(ReportReceiver receiver, String reportName) {
        this.receiver = receiver;
        this.reportName = reportName;
    }
    @Override
    public void execute() {
        receiver.createReport(reportName);
    }

    @Override
    public void undo() {
        System.out.println("  [COMMAND] Undoing creation of: " + reportName);
        receiver.deleteReport(reportName);
    }

    @Override
    public String getDescription() {
        return "Create report: " + reportName;
    }
}
