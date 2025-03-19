package com.ust.base;

import java.io.*;
import java.util.*;

public class PropertyLoader {
    private static final String CONFIG_DIR = "config"; // Folder where .properties files are stored
    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        File folder = new File(CONFIG_DIR);
        if (!folder.exists() || !folder.isDirectory()) {
            System.err.println("Config folder not found: " + CONFIG_DIR);
            return;
        }

        File[] files = folder.listFiles((dir, name) -> name.endsWith(".properties"));
        if (files != null) {
            for (File file : files) {
                try (InputStream input = new FileInputStream(file)) {
                    properties.load(input);
                    System.out.println("Loaded: " + file.getName());
                } catch (IOException e) {
                    System.err.println("Failed to load file: " + file.getName());
                }
            }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println("Property Value: " + getProperty("app.name")); // Example key
    }
}
