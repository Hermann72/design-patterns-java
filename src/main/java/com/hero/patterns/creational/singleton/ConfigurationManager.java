package com.hero.patterns.creational.singleton;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {
    // volatile guarantees visibility between threads
    private static volatile ConfigurationManager instance;
    private final Map<String, String> properties;
    // Private constructor — no one can do new ConfigurationManager()
    private ConfigurationManager() {
        properties = new HashMap<>();
        loadProperties();
    }

    // A single instance, thread-safe with Double-Checked Locking
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    private void loadProperties() {
        // We simulate loading configuration
        // (in real life it would come from a .properties file or environment variables)
        properties.put("db.url", "jdbc:mysql://localhost:3306/mydb");
        properties.put("db.username", "admin");
        properties.put("db.maxConnections", "10");
        properties.put("app.environment", "development");
        properties.put("app.version", "1.0.0");
    }
    public String getProperty(String key) {
        return properties.getOrDefault(key, "");
    }
    public void setProperty(String key, String value) {
        properties.put(key, value);
    }
}
