package PageObject;

import static org.junit.Assert.assertEquals;
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
	
	@FindBy(xpath = "//div[contains(@class,'MuiAlert-message')]")
	WebElement toastMessage;
	
	public void loginToApp() {
		wait.waitForVisibility(email);
		email.sendKeys(CONSTANT.EMAIL);
		password.sendKeys(CONSTANT.PASSWORD);
		loginButton.click();
	}
	
	public void getMessage(String expectedText) throws InterruptedException {
		wait.waitForVisibility(toastMessage);
		assertEquals(expectedText,toastMessage.getText());
		Thread.sleep(4000);
		System.out.println(toastMessage.getText());
	}
}
