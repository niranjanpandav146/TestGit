package reusableComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {

	// Common to method to click on button on UI
	public void buttonClick(WebElement ele) {
		try {
			ele.click();
			System.out.print("Click Success" + ele);
		} catch (Exception e) {
			System.out.print(" " + e.getMessage());
		}

	}

	// Common to method to provide input for textbox on UI
	public void inputTextbox(WebElement ele, String text) {
		try {
			ele.sendKeys(text);
			System.out.print("Input Success" + ele);
		} catch (Exception e) {
			System.out.print(" " + e.getMessage());
		}

	}

	// Common to method to hover over UI element
	public void hoverOverElement(WebDriver driver, WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		} catch (Exception e) {
			System.out.print(" " + e.getMessage());
		}

	}

	// Common to method to get text from UI element
	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText().trim().toString();
	}

	// Common to method to wait for UI element
	public void WaitForElement(WebDriver driver, WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			System.out.print(" " + e.getMessage());
		}

	}

}
