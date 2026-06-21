package com.automationexcersie.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	  
    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        if (driver != null) {
            try {
                // 1. Convert WebDriver object to TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) driver;
                
                // 2. Call getScreenshotAs method to create the image file
                File source = ts.getScreenshotAs(OutputType.FILE);
                
                // 3. Generate a timestamp so file names are unique
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                
                // 4. Create target destination path (Project_Root/screenshots/Name_Timestamp.png)
                File destination = new File("/test-output/screenshots"+ screenshotName + timestamp+ ".png");
                
                // 5. Copy file to the destination folder
                FileHandler.copy(source, destination);
                System.out.println("Screenshot captured successfully: " + destination.getAbsolutePath());
                
            } catch (IOException e) {
                System.out.println("Failed to save screenshot: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Screenshot exception encountered: " + e.getMessage());
            }
        }
    }
}
