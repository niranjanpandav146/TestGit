package testBase;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import POM.MytheresaHomePage;
import reusableComponents.CommonMethods;

public class ObjectRepo {

	public static WebDriver driver;
	public static MytheresaHomePage mytheresaHomePage;
	public static ExtentReports extent;
	public static ExtentTest test;

	public CommonMethods common = new CommonMethods();

}
