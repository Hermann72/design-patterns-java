package com.hero.patterns.creational;

import com.hero.patterns.creational.abstractfactory.AbstractFactoryDemo;
import com.hero.patterns.creational.builder.BuilderDemo;
import com.hero.patterns.creational.factory.FactoryMethodDemo;
import com.hero.patterns.creational.singleton.SingletonDemo;

public class Main {
  public static void main(String[] args) {
    SingletonDemo.run();
    System.out.println("\n" + "=".repeat(40) + "\n" );
    FactoryMethodDemo.run();
    System.out.println("\n" + "=".repeat(40) + "\n" );
    AbstractFactoryDemo.run();
    System.out.println("\n" + "=".repeat(40) + "\n" );
    BuilderDemo.run();
  }
}

