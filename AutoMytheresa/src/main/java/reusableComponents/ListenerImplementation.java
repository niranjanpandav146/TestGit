package reusableComponents;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import testBase.ObjectRepo;

public class ListenerImplementation extends ObjectRepo implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case " + result.getMethod().getMethodName() + " Passed");

	}

	public void onTestFailure(ITestResult result) {

		try {
			test.log(Status.FAIL, "Test Case " + result.getMethod().getMethodName() + " Failed");
			test.log(Status.FAIL, result.getThrowable());
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String screenshotPath = System.getProperty("user.dir") + "/Reports/Screenshots/Screenshot.jpeg";
			File dest = new File(screenshotPath);
			FileUtils.copyFile(src, dest);
			test.addScreenCaptureFromPath(screenshotPath, "FailedScreenshot");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		extent = ExtentSetup.setupExtentReport();
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
