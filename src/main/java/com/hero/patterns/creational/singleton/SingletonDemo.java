package com.hero.patterns.creational.singleton;

public class SingletonDemo {

    public static void run() {
        System.out.println("=== Singleton Pattern ===\n");

        ConfigurationManager config1 = ConfigurationManager.getInstance();
        ConfigurationManager config2 = ConfigurationManager.getInstance();

        // To demonstrate that they are the same instance
        System.out.println("¿config1 == config2? " + (config1 == config2));
        System.out.println("config1 hashCode: " + config1.hashCode());
        System.out.println("config2 hashCode: " + config2.hashCode());

        // Use the settings
        System.out.println("\nPropiedades cargadas:");
        System.out.println("DB URL: " + config1.getProperty("db.url"));
        System.out.println("Entorno: " + config1.getProperty("app.environment"));

        // Modify from config2 and verify from config1 (same object)
        config2.setProperty("app.environment", "production");
        System.out.println("\nTras modificar desde config2:");
        System.out.println("Entorno desde config1: " + config1.getProperty("app.environment"));

        // Try using multiple threads
        System.out.println("\n--- Prueba multihilo ---");
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                ConfigurationManager cfg = ConfigurationManager.getInstance();
                System.out.println(Thread.currentThread().getName() +
                        " -> hashCode: " + cfg.hashCode());
            }).start();
        }
    }
}

