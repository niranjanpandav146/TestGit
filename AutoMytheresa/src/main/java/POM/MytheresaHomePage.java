package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;

import testBase.TestBase;

public class MytheresaHomePage extends TestBase {

	@FindBy(id = "myaccount")
	WebElement link_myAccount;

	@FindBy(id = "email")
	WebElement txt_email;

	@FindBy(id = "pass")
	WebElement txt_password;

	@FindBy(id = "send2")
	WebElement button_login;

	@FindBy(xpath = "//p[@class='welcome-msg']")
	WebElement welcomText;

	public MytheresaHomePage() {
		PageFactory.initElements(driver, this);
	}

	// Method to click on MyAccount Link
	public void clickMyAccountLink() {
		common.hoverOverElement(driver, link_myAccount);
	}

	// Method to provide email on Login
	public void setTextToEmailBox(String text) {
		common.inputTextbox(txt_email, text);
	}

	// Method to provide password on Login
	public void setTextToPasswordBox(String text) {
		common.inputTextbox(txt_password, text);
	}

	// Method to click on Login button
	public void clickLoginButton() {
		common.buttonClick(button_login);
	}

	// Method to verify User login
	public void verifyUserLogin() {
		common.WaitForElement(driver, welcomText);
		String text = common.getElementText(driver, welcomText);
		if (text.contains("Niranjan")) {
			System.out.println("User Logged In Successfully");
		}
	}

	// End-To-End Login Method for Mytheresa Application
	public void loginToMytheresaApplication(String email, String password) {
		try {
			clickMyAccountLink();
			test.log(Status.PASS, "User hover over my account");
			setTextToEmailBox(email);
			test.log(Status.PASS, "User entered userName");
			setTextToPasswordBox(password);
			test.log(Status.PASS, "User entered password");
			clickLoginButton();
		} catch (Exception e) {
			System.out.print(" " + e.getMessage());
		}

	}

}
