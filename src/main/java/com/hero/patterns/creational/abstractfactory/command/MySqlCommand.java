package com.hero.patterns.creational.abstractfactory.command;

public class MySqlCommand implements Command{
    @Override
    public void execute(String sql) {
        System.out.println("  [MySQL] Executing: " + sql);
        System.out.println("  [MySQL] Using MySQL-specific query optimizer");
    }
}
