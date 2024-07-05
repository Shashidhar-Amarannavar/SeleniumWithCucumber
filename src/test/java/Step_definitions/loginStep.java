package Step_definitions;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import PageObject.loginPageComponents;
import Utility.CONSTANT;
import Utility.CommonHelper;
import io.cucumber.java.en.*;

public class loginStep {

	static WebDriver driver;
	static loginPageComponents loginComponents;

	public loginStep() throws IOException {
		driver = CommonHelper.driver;
		loginComponents = new loginPageComponents(driver);
	}

	@Given("User launch the browser and hit the URL")
	public void launch() throws InterruptedException {
		driver.get(CONSTANT.URL);
		Thread.sleep(2000);
	}

	@When("user is in login page and enter the email and password")
	public void email_and_password() {
		loginComponents.loginToApp();
	}

	@Then("Verify popup {string}")
	public void verifySuccessMessage(String expectedText) {
		loginComponents.getMessage(expectedText);
	}

	@When("user enter the {string} and {string}")
	public void user_enter_the_and(String email, String password) {
		loginComponents.loginToApp(email, password);
	}

	@When("user enter the wrong {string} and {string}")
	public void user_enter_the_wrong_and(String email, String password) {
		loginComponents.enterEmailAndPassword(email, password);
	}

	@Then("Verify the textfield validation {string}")
	public void verify_the_textbox(String expectedText) {
		loginComponents.validateMessage(expectedText);
	}
}
