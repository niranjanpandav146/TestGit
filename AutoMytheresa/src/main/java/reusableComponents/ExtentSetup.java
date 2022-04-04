package reusableComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.ObjectRepo;

public class ExtentSetup extends ObjectRepo {

	public static ExtentReports setupExtentReport() {
		String reportPath = System.getProperty("user.dir") + "/Reports/ExecutionReport.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(spark);

		spark.config().setDocumentTitle("TestGoogle");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("ReportName");

		return extent;

	}
}
