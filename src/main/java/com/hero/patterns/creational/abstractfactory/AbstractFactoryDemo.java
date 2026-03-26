package com.hero.patterns.creational.abstractfactory;

import com.hero.patterns.creational.abstractfactory.command.Command;
import com.hero.patterns.creational.abstractfactory.connection.Connection;
import com.hero.patterns.creational.abstractfactory.factories.DatabaseFactory;
import com.hero.patterns.creational.abstractfactory.factories.MySqlFactory;
import com.hero.patterns.creational.abstractfactory.factories.PostgreSqlFactory;
import com.hero.patterns.creational.abstractfactory.transaction.Transaction;

public class AbstractFactoryDemo {

    private static void runDatabaseOperations(DatabaseFactory factory) {
        System.out.println("--- Creating components with: "
                + factory.getClass().getSimpleName() + " ---\n");

        Connection connection = factory.createConnection();
        Command command = factory.createCommand();
        Transaction transaction = factory.createTransaction();

        System.out.println("Connection info: " + connection.getConnectionInfo());
        connection.connect();

        System.out.println();
        transaction.begin();
        command.execute("SELECT * FROM users WHERE active = true");
        command.execute("UPDATE users SET last_login = NOW()");
        transaction.commit();

        System.out.println();
    }

    public static void run() {
        System.out.println("=== Abstract Factory Pattern ===\n");

        // Simulates decision when starting the app according to configuration
        String dbEngine = "mysql"; // It would come from an environment variable

        DatabaseFactory factory = switch (dbEngine) {
            case "mysql" -> new MySqlFactory();
            case "postgresql" -> new PostgreSqlFactory();
            default -> throw new IllegalArgumentException("Unsupported engine: " + dbEngine);
        };

        runDatabaseOperations(factory);

        // We switched to PostgreSQL — run DatabaseOperations() makes no difference at all
        System.out.println("Switching to PostgreSQL...\n");
        runDatabaseOperations(new PostgreSqlFactory());
    }
}
