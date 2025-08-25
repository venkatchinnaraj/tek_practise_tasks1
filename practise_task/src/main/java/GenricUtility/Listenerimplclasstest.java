package GenricUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listenerimplclasstest extends BaseClass implements ITestListener,ISuiteListener{
	
	 public ExtentReports ereport;
	public ExtentTest test;
	
	
	

	@Override
	public void onStart(ISuite suite) {
		String time=new Date().toString().replace(" ","_").replace(":","_ ");
		ExtentSparkReporter spark =new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM test suite result");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);
		
		
		 ereport=new ExtentReports();
		ereport.attachReporter(spark);
		ereport.setSystemInfo("OS", "Windows-10");
		ereport.setSystemInfo("Browser", "chrome-138");
	}

	@Override
	public void onFinish(ISuite suite) {
		ereport.flush();
	}
	
	//onteststart execute before each testcase
	@Override
	public void onTestStart(ITestResult result) {
		 test=ereport.createTest(result.getName());
		// utilityclassobject.settest(test);
		 test.log(Status.INFO, result.getName()+"====>STARTED");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		 test.log(Status.PASS, result.getName()+"====>COMPLETED");
		
	}

	public void onTestFailure(ITestResult result) {
		
	String testname = result.getName();
		//TakesScreenshot ts=(TakesScreenshot)utilityclassobject.getDriver();
	TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
	String filepath = ts.getScreenshotAs(OutputType.BASE64);
	String time=new Date().toString().replace(" ","_").replace(".","_ ");
	test.addScreenCaptureFromBase64String(filepath,testname+"_"+time);
	 test.log(Status.FAIL, result.getName()+"====>FAILED");
	}
	
	

	}


