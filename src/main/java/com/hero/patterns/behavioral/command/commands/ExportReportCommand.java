package com.hero.patterns.behavioral.command.commands;

import com.hero.patterns.behavioral.command.Command;
import com.hero.patterns.behavioral.command.receiver.ReportReceiver;

public class ExportReportCommand implements Command {
    private final ReportReceiver receiver;
    private final String reportName;
    private final String format;

    public ExportReportCommand(ReportReceiver receiver, String reportName, String format) {
        this.receiver = receiver;
        this.reportName = reportName;
        this.format = format;
    }

    @Override
    public void execute() {
        receiver.exportReport(reportName, format);
    }

    @Override
    public void undo() {
        System.out.println("  [COMMAND] Undoing export of: " + reportName);
        receiver.undoExport(reportName, format);
    }

    @Override
    public String getDescription() {
        return "Export report: " + reportName + " as " + format;
    }
}
