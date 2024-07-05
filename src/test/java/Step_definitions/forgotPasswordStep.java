package Step_definitions;

import org.openqa.selenium.WebDriver;

import PageObject.loginPageComponents;
import Utility.CommonHelper;
import io.cucumber.java.en.*;

public class forgotPasswordStep {
	
	static WebDriver driver;
	static loginPageComponents login;
	
	public forgotPasswordStep() {
		driver = CommonHelper.driver;
		login = new loginPageComponents(driver);
	}
	
	@When("user in login page and click forgot password and enter {string}")
	public void user_in_login_page_and_click_forgot_password_and_enter(String email) {
		login.clickOnForgotPassword(email);
	}

	@When("click on reset password")
	public void click_on_reset_password() {
		login.clickOnResetPassword();
	}
	
	@Then("Verify the email {string}")
	public void verify_the_email(String expectedText) {
		login.VerifyEmailValidation(expectedText);
	}
}
