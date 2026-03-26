package com.hero.patterns.creational.abstractfactory.transaction;

public class MySqlTransaction implements Transaction {
    @Override
    public void begin() {
        System.out.println("  [MySQL] BEGIN TRANSACTION");
    }

    @Override
    public void commit() {
        System.out.println("  [MySQL] COMMIT");
    }

    @Override
    public void rollback() {
        System.out.println("  [MySQL] ROLLBACK");
    }
}
