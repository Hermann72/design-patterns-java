package com.hero.patterns.creational.abstractfactory.factories;

import com.hero.patterns.creational.abstractfactory.command.Command;
import com.hero.patterns.creational.abstractfactory.command.MySqlCommand;
import com.hero.patterns.creational.abstractfactory.connection.Connection;
import com.hero.patterns.creational.abstractfactory.connection.MySqlConnection;
import com.hero.patterns.creational.abstractfactory.transaction.MySqlTransaction;
import com.hero.patterns.creational.abstractfactory.transaction.Transaction;

public class MySqlFactory implements DatabaseFactory {

    @Override
    public Connection createConnection() {
        return new MySqlConnection();
    }

    @Override
    public Command createCommand() {
        return new MySqlCommand();
    }

    @Override
    public Transaction createTransaction() {
        return new MySqlTransaction();
    }
}
