package Tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testBase.TestBase;

public class MytheresaTests extends TestBase {

	// Automation Script : Verify No JavaScript Error present on Mytheresa Home Page
	@Test(enabled = true)
	public void VerifyNoJavaScriptErronOnMytheresaHomePage() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

		for (LogEntry entry : logEntries) {
			if (entry != null) {
				test.log(Status.FAIL, "Java Script Errors on Mytheresa Site "+entry.getMessage());				
			} else {
				test.log(Status.PASS, "No Java Script Errors on Mytheresa Site");
			}
		}

	}

	// Automation Script : Verify Broken Links on Mytheresa Home Page
	@Test(enabled = false)
	public void verifyBrokenLinkOnMytheresaHomePage() {
		HttpURLConnection huc = null;
		int respCode = 200;
		String url = driver.getCurrentUrl();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		while (it.hasNext()) {

			url = it.next().getAttribute("href");
			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				respCode = huc.getResponseCode();
				if (respCode >= 400) {								
					System.out.println("Broken link : " + url);
				}

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	// Automation Script : Verify User Login Functionality on Mytheresa UI Application
	@Test(enabled = true)
	public void VerifyUserLoginOnMytheresa() throws Exception {
		test.log(Status.PASS, "Application launched successfully");
		mytheresaHomePage.loginToMytheresaApplication(userName, password);
		mytheresaHomePage.verifyUserLogin();
		test.log(Status.PASS, "User "+ userName+" logged in successfully");
	}

}
