package Pranavraj.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReporterNg {
	
	public static ExtentReports reportObject() {
		
		String path=System.getProperty("user.dir")+"\\reports\\report.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("pranavrajFramework");
		reporter.config().setDocumentTitle("Web Automation");
		
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "pranav");
		return extent;
			
		
	}

}
