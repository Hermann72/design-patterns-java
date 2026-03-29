package com.hero.patterns.creational;

import com.hero.patterns.creational.abstractfactory.AbstractFactoryDemo;
import com.hero.patterns.creational.builder.BuilderDemo;
import com.hero.patterns.creational.factory.FactoryMethodDemo;
import com.hero.patterns.creational.prototype.PrototypeDemo;
import com.hero.patterns.creational.singleton.SingletonDemo;
import com.hero.patterns.structural.adapter.AdapterDemo;
import com.hero.patterns.structural.decorator.DecoratorDemo;
import com.hero.patterns.structural.facade.FacadeDemo;

public class Main {
  public static void main(String[] args) {
    SingletonDemo.run();
    System.out.println("\n" + "=".repeat(40) + "\n" );
    FactoryMethodDemo.run();
    System.out.println("\n" + "=".repeat(40) + "\n" );
    AbstractFactoryDemo.run();
    System.out.println("\n" + "=".repeat(40) + "\n" );
    BuilderDemo.run();
    System.out.println("\n" + "=".repeat(40) + "\n" );
    PrototypeDemo.run();
    System.out.println("\n" + "=".repeat(40) + "\n" );
    AdapterDemo.run();
    System.out.println("\n" + "=".repeat(40) + "\n" );
    DecoratorDemo.run();
    System.out.println("\n" + "=".repeat(40) + "\n" );
    FacadeDemo.run();
  }
}

