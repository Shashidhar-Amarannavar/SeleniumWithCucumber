package Step_definitions;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

import PageObject.LoginComponents;
import Utility.CONSTANT;
import Utility.CommonHelper;
import io.cucumber.java.en.*;

public class loginStep {
	
	static WebDriver driver;
	static LoginComponents loginComponents;
	
	public loginStep() throws IOException {
		driver = CommonHelper.driver;
		loginComponents = new LoginComponents(driver);
	}
	
	@Given("User launch the browser and hit the URL")
	public void launch() throws InterruptedException {
	    driver.get(CONSTANT.URL);
	    Thread.sleep(5000);
	    
	}

	@When("user is in login page and enter the email and password")
	public void email_and_password() {
		loginComponents.loginToApp();
	}

	@Then("Verify {string}")
	public void verifySuccessMessage(String string) {
	   
	}

}
