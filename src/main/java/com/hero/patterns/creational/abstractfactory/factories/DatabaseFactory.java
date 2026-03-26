package com.hero.patterns.creational.abstractfactory.factories;

import com.hero.patterns.creational.abstractfactory.command.Command;
import com.hero.patterns.creational.abstractfactory.connection.Connection;
import com.hero.patterns.creational.abstractfactory.transaction.Transaction;

public interface DatabaseFactory {
    Connection createConnection();
    Command createCommand();
    Transaction createTransaction();
}
