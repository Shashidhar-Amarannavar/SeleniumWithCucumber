package PageObject;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utility.CONSTANT;
import Utility.CommonHelper;
import Utility.ExplicitWait;
import Utility.Page_factory;

public class loginPageComponents extends Page_factory {

	public static WebDriver driver;
	public static ExplicitWait wait;
	public static String actualText;

	public loginPageComponents(WebDriver driver) {
		super(driver);
		wait = new ExplicitWait(driver);
	}

	@FindBy(xpath = "//input[@name='email']")
	WebElement emailTextfield;

	@FindBy(id = "password")
	WebElement passwordTextfield;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class,'MuiAlert-message')]")
	WebElement toastMessage;

	@FindBy(xpath = "//label[text()='Email ID']/..//p/span")
	WebElement emailValidation;

	@FindBy(xpath = "//label[text()='Password']/..//p/span")
	WebElement passwordValidation;
	
	@FindBy(xpath = "//button[@title=\"Close\"]")
	WebElement close;
	
	@FindBy(xpath = "//a[text()='Forgot password?']")
	WebElement forgotPassword;
	
	@FindBy(xpath = "//button[text()='Reset Password']")
	WebElement ResetPasswordButton;

	public void loginToApp() {
		wait.waitForVisibility(emailTextfield);
		emailTextfield.sendKeys(CONSTANT.EMAIL);
		passwordTextfield.sendKeys(CONSTANT.PASSWORD);
		loginButton.click();
	}

	public void loginToApp(String email, String password) {
		wait.waitForVisibility(emailTextfield);
		emailTextfield.sendKeys(email);
		passwordTextfield.sendKeys(password);
		loginButton.click();
	}

	public void getMessage(String expectedText) {
		wait.waitForVisibility(toastMessage);
		assertEquals(expectedText, toastMessage.getText());
		close.click();
	}

	public void enterEmailAndPassword(String email, String password) {
		if (email.isEmpty() && !password.isEmpty()) {
			passwordTextfield.sendKeys(password);
			CommonHelper.clearTextbox(passwordTextfield);
			actualText = passwordValidation.getText().trim();
		} else if (!email.isEmpty() && password.isEmpty()) {
			emailTextfield.clear();
			emailTextfield.sendKeys(email);
			actualText = emailValidation.getText().trim();
		} else {
			emailTextfield.sendKeys("passing null value");
			CommonHelper.clearTextbox(emailTextfield);
			actualText = emailValidation.getText().trim();
		}
	}

	public void validateMessage(String expectedText) {
		assertEquals(expectedText, actualText);
	}
	
	public void clickOnForgotPassword(String email) {
		wait.waitForVisibility(forgotPassword);
		forgotPassword.click();
		wait.waitForVisibility(emailTextfield);
		emailTextfield.click();
		emailTextfield.sendKeys(email);
		CommonHelper.clearTextbox(emailTextfield);
		emailTextfield.sendKeys(email);
	}
	
	public void clickOnResetPassword() {
		ResetPasswordButton.click();
	}
	
	public void VerifyEmailValidation(String expectedText) {
		wait.waitForVisibility(emailValidation);
		String actualText = emailValidation.getText().stripTrailing();
		assertEquals(actualText, expectedText);
	}
}
