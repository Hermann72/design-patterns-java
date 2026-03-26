package com.hero.patterns.creational.abstractfactory.connection;

public class PostgreSqlConnection implements Connection {
    @Override
    public void connect() {
        System.out.println("  [PostgreSQL] Establishing connection on port 5432...");
        System.out.println("  [PostgreSQL] Using MVCC engine");
    }

    @Override
    public String getConnectionInfo() {
        return "PostgreSQL 15 -> localhost:5432";
    }
}
