package com.hero.patterns.behavioral.command;

import com.hero.patterns.behavioral.command.commands.CreateReportCommand;
import com.hero.patterns.behavioral.command.commands.DeleteReportCommand;
import com.hero.patterns.behavioral.command.commands.ExportReportCommand;
import com.hero.patterns.behavioral.command.receiver.ReportReceiver;

public class CommandDemo {

    public static void run() {
        System.out.println("=== Command Pattern ===\n");

        ReportReceiver receiver = new ReportReceiver();
        ReportCommandInvoker invoker = new ReportCommandInvoker();

        // Execute commands
        System.out.println("-- Executing commands --");
        invoker.executeCommand(new CreateReportCommand(receiver, "Sales Q1 2025"));
        System.out.println();
        invoker.executeCommand(new CreateReportCommand(receiver, "HR Annual 2025"));
        System.out.println();
        invoker.executeCommand(new ExportReportCommand(receiver, "Sales Q1 2025", "PDF"));
        System.out.println();
        invoker.executeCommand(new ExportReportCommand(receiver, "HR Annual 2025", "EXCEL"));
        System.out.println();
        invoker.executeCommand(new DeleteReportCommand(receiver, "HR Annual 2025"));

        // View history
        System.out.println("\n-- Command history --");
        invoker.printHistory();

        // Undo the last command — restore HR Annual 2025
        System.out.println("\n-- Undo last command (Delete HR Annual) --");
        invoker.undo();

        // Undo another one — undo export of HR Annual
        System.out.println("\n-- Undo again (Export HR Annual) --");
        invoker.undo();

        // View history updated
        System.out.println("\n-- Updated history --");
        invoker.printHistory();

        // Final status of reports
        System.out.println("\n-- Final report list --");
        System.out.println("  Reports: " + receiver.getReports());
    }
}