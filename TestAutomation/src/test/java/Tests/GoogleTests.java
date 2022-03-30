package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTests {
	
	WebDriver driver =null;
	@BeforeTest
	public void setUpTest()
	{
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void googleSearch()
	{
		driver.get("https://google.co.in");		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
