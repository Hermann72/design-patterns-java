package com.hero.patterns.creational.abstractfactory.factories;

import com.hero.patterns.creational.abstractfactory.command.Command;
import com.hero.patterns.creational.abstractfactory.command.PostgreSqlCommand;
import com.hero.patterns.creational.abstractfactory.connection.Connection;
import com.hero.patterns.creational.abstractfactory.connection.PostgreSqlConnection;
import com.hero.patterns.creational.abstractfactory.transaction.PostgreSqlTransaction;
import com.hero.patterns.creational.abstractfactory.transaction.Transaction;

public class PostgreSqlFactory implements DatabaseFactory {
    @Override
    public Connection createConnection() {
        return new PostgreSqlConnection();
    }

    @Override
    public Command createCommand() {
        return new PostgreSqlCommand();
    }

    @Override
    public Transaction createTransaction() {
        return new PostgreSqlTransaction();
    }
}
