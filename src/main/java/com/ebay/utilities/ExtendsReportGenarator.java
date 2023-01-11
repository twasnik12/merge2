package com.ebay.utilities;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendsReportGenarator {

	public static ExtentReports extent;

	public static ExtentReports extentreprts() {

		String str = "C:\\Users\\Tathagat\\eclipse-workspace\\ebay\\Reports";

		ExtentSparkReporter reporter = new ExtentSparkReporter(str);

		reporter.config().setDocumentTitle("ebay Services Project");

		reporter.config().setReportName("ebay Automation");

		reporter.config().setTheme(Theme.DARK);

		ExtentReports extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Project Name", "ebay Services Automation");

		extent.setSystemInfo("User Name", "Tathagat Wasnik");

		extent.setSystemInfo("EmpId", "CZ107");

		extent.setSystemInfo("Environment", "Automation Testing");

		extent.setSystemInfo("State Demo", " All State is Passed");

		return extent;
	}
}