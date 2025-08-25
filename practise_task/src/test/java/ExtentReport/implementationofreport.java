package ExtentReport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class implementationofreport {
	
	@Test
	public void createtest() {
		
		//spark report config
		ExtentSparkReporter spark =new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM test suite result");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);
		
		//add env info and create test
		ExtentReports ereport=new ExtentReports();
		ereport.attachReporter(spark);
		ereport.setSystemInfo("OS", "Windows-10");
		ereport.setSystemInfo("Browser", "chrome-138");
		
		//create extentTest object
		ExtentTest test=ereport.createTest("createtest");
		
		test.log(Status.INFO, "created");
		
		ereport.flush();
		
		
		
		
		
		
	}

}
