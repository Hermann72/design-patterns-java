package com.hero.patterns.creational.abstractfactory.transaction;

public interface Transaction {
    void begin();
    void commit();
    void rollback();
}
