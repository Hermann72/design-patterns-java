package com.hero.patterns.behavioral.command.commands;

import com.hero.patterns.behavioral.command.Command;
import com.hero.patterns.behavioral.command.receiver.ReportReceiver;

public class DeleteReportCommand implements Command {
    private final ReportReceiver receiver;
    private final String reportName;

    public DeleteReportCommand(ReportReceiver receiver, String reportName) {
        this.receiver = receiver;
        this.reportName = reportName;
    }

    @Override
    public void execute() {
        receiver.deleteReport(reportName);
    }

    @Override
    public void undo() {
        System.out.println("  [COMMAND] Undoing deletion of: " + reportName);
        receiver.createReport(reportName);
    }

    @Override
    public String getDescription() {
        return "Delete report: " + reportName;
    }
}
