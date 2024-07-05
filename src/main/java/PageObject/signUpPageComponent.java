package PageObject;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.github.javafaker.Faker;
import Utility.CommonHelper;
import Utility.ExplicitWait;
import Utility.Page_factory;

public class signUpPageComponent extends Page_factory {

	public static WebDriver driver;
	public static ExplicitWait wait;
	public String DummyEmail;

	public signUpPageComponent(WebDriver driver) {
		super(driver);
		wait = new ExplicitWait(driver);
	}

	@FindBy(xpath = "//input[@name=\"email\"]")
	WebElement emailIdTextfiled;

	@FindBy(xpath = "//label[text()='First name']/..//input")
	WebElement firstNameTextfiled;

	@FindBy(xpath = "//label[text()='Last name']/..//input")
	WebElement lastNameTextfiled;

	@FindBy(xpath = "//label[text()='Password']/..//input")
	WebElement passwordTextfiled;

	@FindBy(xpath = "//label[text()='Confirm password']/..//input")
	WebElement confirmPasswordTextfiled;

	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement signUp;

	@FindBy(xpath = "//a[text()='Sign up']")
	WebElement signUpLink;

	@FindBy(xpath = "//div[contains(@class,'MuiAlert-message')]")
	WebElement messagePopup;

	@FindBy(xpath = "//label[text()='Email ID']/..//p/span")
	WebElement emailTextbox;

	@FindBy(xpath = "//label[text()='First name']/..//p/span")
	WebElement firstNameTextbox;

	@FindBy(xpath = "//label[text()='Last name']/..//p/span")
	WebElement lastNameTextbox;

	@FindBy(xpath = "//label[text()='Password']/..//p/span")
	WebElement passwordTextbox;

	@FindBy(xpath = "//label[text()='Confirm password']/..//p/span")
	WebElement confirmPasswordTextbox;

	public void signUpLink() {
		signUpLink.click();
		DummyEmail = Faker.instance().name().firstName();
	}

	public void signUpButton() {
		signUp.click();
	}

	public void fillTheFields(String emailId, String firstName, String lastName, String password,
			String confirmPassword) {
		emailIdTextfiled.sendKeys(DummyEmail + emailId);
		firstNameTextfiled.sendKeys(firstName);
		lastNameTextfiled.sendKeys(lastName);
		passwordTextfiled.sendKeys(password);
		confirmPasswordTextfiled.sendKeys(confirmPassword);
	}

	public void clearEnteredValues() throws InterruptedException {
		CommonHelper.clearTextbox(emailIdTextfiled);
		assertEquals(emailTextbox.getText().stripTrailing(), "Please enter your email");
		CommonHelper.clearTextbox(firstNameTextfiled);
		assertEquals(firstNameTextbox.getText().stripTrailing(), "Please enter your first name");
		CommonHelper.clearTextbox(lastNameTextfiled);
		assertEquals(lastNameTextbox.getText().stripTrailing(), "Please enter your last name");
		CommonHelper.clearTextbox(passwordTextfiled);
		assertEquals(passwordTextbox.getText().stripTrailing(), "Please enter your password");
		CommonHelper.clearTextbox(confirmPasswordTextfiled);
		assertEquals(confirmPasswordTextbox.getText().stripTrailing(), "Please enter your confirm password");
	}

	public void verifyErrorMessage() {
		assertEquals(emailTextbox.getText().stripTrailing(), "Please enter a valid email address");
		assertEquals(firstNameTextbox.getText().stripTrailing(), "Please enter valid first name");
		assertEquals(lastNameTextbox.getText().stripTrailing(), "Please enter valid last name");
		assertEquals(passwordTextbox.getText().stripTrailing(),
				"The password should include minimum 8 characters, 1 uppercase, 1 special character, 1 number, 1 lowercase");
		assertEquals(confirmPasswordTextbox.getText().stripTrailing(), "Confirm password should match with password");
	}
}
