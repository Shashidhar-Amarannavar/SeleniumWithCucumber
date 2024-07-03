package Step_definitions;

import org.openqa.selenium.WebDriver;

import PageObject.SignUpPageComponent;
import Utility.CommonHelper;
import io.cucumber.java.en.*;

public class signUpStep {
	
	static WebDriver driver;
	static SignUpPageComponent signUp;
	
	public signUpStep(){
		driver = CommonHelper.driver;
		signUp = new SignUpPageComponent(driver);
	}
	
	@When("user in lagin page and click on signUp")
	public void user_in_lagin_page_and_click_on_sign_up() {
		signUp.signUpLink();
	}

	@When("enter {string},{string},{string},{string}, and {string}")
	public void fill_the_fields(String emailId, String firstName, String lastName, String password, String confirmPassword) throws InterruptedException {
		signUp.fillTheFields(emailId, firstName, lastName, password, confirmPassword);
	}

	@When("click on signUp button")
	public void click_on_sign_up_button() {
		signUp.signUpButton();
	}

	@When("navigate to login page")
	public void navigate_to_login_page() {
	    driver.navigate().back();
	}
	
	@Then("enter blank values in all textbox and verify the error message")
	public void removeEnteredValues() throws InterruptedException {
		signUp.clearEnteredValues();
	}

}
