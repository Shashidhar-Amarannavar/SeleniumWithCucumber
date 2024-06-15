package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utility.CONSTANT;
import Utility.ExplicitWait;
import Utility.Page_factory;

public class LoginComponents extends Page_factory{
	
	public static WebDriver driver;
	public static ExplicitWait wait;

	public LoginComponents(WebDriver driver) {
		super(driver);
		wait = new ExplicitWait(driver);
	}
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginButton;
	
	public void loginToApp() {
		wait.waitForVisibility(email);
		email.sendKeys(CONSTANT.EMAIL);
		password.sendKeys(CONSTANT.PASSWORD);
		loginButton.click();
	}
}
