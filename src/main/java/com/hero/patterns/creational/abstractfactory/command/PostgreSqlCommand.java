package com.hero.patterns.creational.abstractfactory.command;

public class PostgreSqlCommand implements Command {
    @Override
    public void execute(String sql) {
        System.out.println("  [PostgreSQL] Executing: " + sql);
        System.out.println("  [PostgreSQL] Using PostgreSQL query planner");
    }
}
