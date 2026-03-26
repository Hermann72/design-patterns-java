package com.hero.patterns.creational.abstractfactory.connection;

public class MySqlConnection implements Connection {

    @Override
    public void connect() {
        System.out.println("  [MySQL] Establishing connection on port 3306...");
        System.out.println("  [MySQL] Using InnoDB engine");
    }

    @Override
    public String getConnectionInfo() {
        return "MySQL 8.0 -> localhost:3306";
    }
}
