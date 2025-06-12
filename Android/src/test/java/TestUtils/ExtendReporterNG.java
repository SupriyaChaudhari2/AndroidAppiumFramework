package TestUtils;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtendReporterNG {
	static ExtentReports extent;
	
	public static ExtentReports  getreporterobject()
	{
		
		//ExtentReports, ExtentSparkReporter;
		String path = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "index.html";
;
	    ExtentSparkReporter	reporter = new 	ExtentSparkReporter(path); 
		reporter.config().setReportName("Mobile Automation Result");
		reporter.config().setDocumentTitle("Test Result");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Supriya Chaudhari");
		return extent;
	}

}
