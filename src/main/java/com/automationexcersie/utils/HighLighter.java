package com.automationexcersie.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighLighter {

    public static void highlight(WebDriver driver, WebElement element) {
        if (driver != null && element != null) {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                
                // 1. Apply the highlight styles
                js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red; background: yellow;');", element);
                
                // 2. Pause briefly so human eyes can see it
                Thread.sleep(250);
                
                // 3. Revert the styles back to normal
                js.executeScript("arguments[0].setAttribute('style', 'border: none; background: none;');", element);
                
            } catch (Exception e) {
                System.out.println("Highlighter Exception encountered: " + e.getMessage());
            }
        }
    }
}