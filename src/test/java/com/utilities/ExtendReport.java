package com.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtendReport implements ITestListener {
	

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	ReadConfig read = new ReadConfig();
	
	public void configureReport() {

		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "nopCommerce-" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);

		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		reports.setSystemInfo("Machine:", "Dell Pc");
		reports.setSystemInfo("OS", "windows 10");
		reports.setSystemInfo("browser:", read.setBrowser());
		reports.setSystemInfo("username:", "Abhishek Saykar");

		// configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("This is reports of Batch42 ");
		htmlReporter.config().setReportName("nopCommerce");
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	

	public void onTestStart(ITestResult result) {
	   
		System.out.println("Name of test method started:" + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of test method sucessfully executed:" + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the passed test case is: " + result.getName(), ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult result) {
		

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of test method skipped:" + result.getName() );  		

		test = reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + result.getName() ,ExtentColor.YELLOW));


	}

	public void onStart(ITestContext context) {

		configureReport();
		System.out.println("On Start method invoked....");

	}


	public void onFinish(ITestContext context) {

		System.out.println("On Finished method invoked....");
		reports.flush(); // it is mandatory to call flush method to ensure information is written to the
	}						// started reporter.
	
	
	

}
