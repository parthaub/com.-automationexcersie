package com.automationexcersie.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("[TestListener] Test STARTED:" + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("[TestListener] Test SUCCESS" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("[TestListener] Test FAILURE" + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("[TestListener] Test SKIPPED" + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("[TestListener] Test SUITE Start" + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("[TestListener] Test SUITE Finish" + context.getName());
	}}