package com.automationexcersie.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(

	    features = "/Users/parthadebnath/eclipse-workspace/MyEclipse/com.automationexcersie/src/test/resources/features/login.feature",
	    glue = {
	        "com.automationexcersie.stepdefinitions", 
	        "com.automationexcersie.hooks" 
	        },
	    tags = "@regression",
	    plugin = {
	        "pretty",                                                    // Colorful console output
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	        "json:target/cucumber-reports/cucumber.json",
	        "html:target/cucumber-reports/cucumber.html"                  // Saves failed test paths for re-run
		    },

	    // monochrome = true removes ANSI color codes from console (cleaner in some terminals)
	    monochrome = true,

	    // Publish = true uploads results to Cucumber cloud (requires account — can set to false)
	    publish = false
	)
	public class TestRunner extends AbstractTestNGCucumberTests {

	  }


