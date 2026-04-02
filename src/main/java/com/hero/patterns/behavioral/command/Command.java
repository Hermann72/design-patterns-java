package com.hero.patterns.behavioral.command;

public interface Command {
    void execute();
    void undo();
    String getDescription();
}
