package com.automationexcersie.utils;

import org.testng.asserts.SoftAssert;

import org.testng.Assert;

public class AssertHelper {

    private SoftAssert softAssert;

    public AssertHelper() {
        softAssert = new SoftAssert();
    }

    // Hard Assert Methods
    public void hardAssertEquals(Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public void hardAssertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    public void hardAssertFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }

    public void hardAssertNotNull(Object obj, String message) {
        Assert.assertNotNull(obj, message);
    }

    
    
    // Soft Assert Methods
    public void softAssertEquals(Object actual, Object expected, String message) {
        softAssert.assertEquals(actual, expected, message);
    }

    public void softAssertTrue(boolean condition, String message) {
        softAssert.assertTrue(condition, message);
    }

    public void softAssertFalse(boolean condition, String message) {
        softAssert.assertFalse(condition, message);
    }

    public void softAssertNotNull(Object obj, String message) {
        softAssert.assertNotNull(obj, message);
    }

    // Important for soft assert
    public void assertAll() {
        softAssert.assertAll();
    }
}
