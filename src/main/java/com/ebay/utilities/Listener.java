package com.ebay.utilities;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ebay.commons.BaseClass;

public class Listener extends BaseClass implements ITestListener {

	ExtentReports extent = ExtendsReportGenarator.extentreprts();

	ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();

		public void onTestSuccess(ITestResult result) {
	
			ObjectRepo.test.log(Status.PASS, "TEST CASE IS PASS");
	
			ObjectRepo.test.addScreenCaptureFromBase64String(getCapture(), "test case passed ");
			System.out.println("********Test is succesful**********" + result.getName());
	
		}

	public void onTestStart(ITestResult result) {
		ObjectRepo.test = extent
				.createTest(result.getTestClass().getName() + "==" + result.getMethod().getMethodName());
		extenttest.set(ObjectRepo.test);
		System.out.println("********Test Started**********" + result.getName());

	}

	public void onTestFailure(ITestResult result) {

		ObjectRepo.test.log(Status.FAIL, "TEST CASE FAIL & EXCEPTION IS  :" + result.getThrowable());
		String src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

		ObjectRepo.test.addScreenCaptureFromBase64String(src,
				"test case fail       ==" + " Web Element vanish and ditached fro the current DOM: ");

	}

	public void onTestSkipped(ITestResult result) {
		ObjectRepo.test.log(Status.SKIP, "TEST CASE IS SKIP");

		ObjectRepo.test.addScreenCaptureFromBase64String(getCapture(), "test case skip ");
		System.out.println("Test Case Skipped Details are =====" + result.getName());

	}

	public void onFinish(ITestContext context) {
		extent.flush();

	}

	public String getCapture() {

		String file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		return file;
	}

}