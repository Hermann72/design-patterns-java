package com.hero.patterns.behavioral.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReportCommandInvoker {

    // History of executed commands — Deque functions as a stack (LIFO)
    private final Deque<Command> history = new ArrayDeque<>();

    public void executeCommand(Command command) {
        System.out.println("  [INVOKER] Executing: " + command.getDescription());
        command.execute();
        history.push(command); // Save history
    }

    public void undo() {
        if (history.isEmpty()) {
            System.out.println("  [INVOKER] Nothing to undo");
            return;
        }
        Command lastCommand = history.pop(); // Take the last one executed
        System.out.println("  [INVOKER] Undoing: " + lastCommand.getDescription());
        lastCommand.undo();
    }

    public void printHistory() {
        if (history.isEmpty()) {
            System.out.println("  [INVOKER] History is empty");
            return;
        }
        System.out.println("  [INVOKER] Command history (" + history.size() + " commands):");
        history.forEach(cmd -> System.out.println("    - " + cmd.getDescription()));
    }
}