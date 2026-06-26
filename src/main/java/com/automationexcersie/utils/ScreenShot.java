package com.automationexcersie.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

    public static void takeScreenshot(WebDriver driver, String screenshotName) {

        if (driver == null) {
            System.out.println("Driver is null. Screenshot not taken.");
            return;
        }

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            File folder = new File("test-output/screenshots");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            File destination = new File("test-output/screenshots/" + screenshotName + "_" + time + ".png");

            FileHandler.copy(source, destination);

            System.out.println("Screenshot saved successfully: " + destination.getPath());

        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}