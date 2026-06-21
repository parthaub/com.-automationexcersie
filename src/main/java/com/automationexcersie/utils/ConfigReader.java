package com.automationexcersie.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            // Load the properties file into memory
            FileInputStream file = new FileInputStream("/Users/parthadebnath/eclipse-workspace/MyEclipse/com.automationexcersie/src/test/resources/configs/config.properties");
            properties = new Properties();
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
