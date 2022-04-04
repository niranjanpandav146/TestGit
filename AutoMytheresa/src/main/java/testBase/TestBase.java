package testBase;

import java.util.logging.Level;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import POM.MytheresaHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import reusableComponents.PropertiesOperations;

public class TestBase extends ObjectRepo {

	public String userName = "";
	public String password = "";

	public void setUpTest(String browserName) throws Exception {
		String url = getURLByEnv(PropertiesOperations.getPropertyValueByKey("env"));
		userName = PropertiesOperations.getPropertyValueByKey("userName");
		password = PropertiesOperations.getPropertyValueByKey("password");

		if (browserName.equalsIgnoreCase("chrome")) {
			LoggingPreferences logPreferences = new LoggingPreferences();
			logPreferences.enable(LogType.BROWSER, Level.ALL);
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setCapability(CapabilityType.LOGGING_PREFS, logPreferences);
			// options.addArguments("--headless"); // Runs chrome browser in headless mode
			driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);

	}

	public void closeBrowser() {
		driver.quit();
	}

	//Method to set application URL based on environment variable[env]
	public String getURLByEnv(String env) {
		String url = "";

		if (env.equalsIgnoreCase("test"))
			url = "https://test.mytheresa.com/en-de/men.html";
		else if (env.equalsIgnoreCase("staging"))
			url = "https://staging.mytheresa.com/en-de/men.html";
		else if (env.equalsIgnoreCase("local"))
			url = "https://local.mytheresa.com/en-de/men.html";
		else if (env.equalsIgnoreCase("prod"))
			url = "https://www.mytheresa.com/en-de/men.html";
		return url;
	}

	@Parameters("browserName")
	@BeforeMethod
	public void setupMethod(String browserName) throws Exception {
		setUpTest(browserName);
		mytheresaHomePage = new MytheresaHomePage();
	}

	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

}
