package Step_definitions;

import org.openqa.selenium.WebDriver;
import PageObject.activityPageComponenets;
import Utility.CommonHelper;
import io.cucumber.java.en.*;

public class verifyTotalHoursInUserCardStep {

	public WebDriver driver;
	public activityPageComponenets activity;

	public verifyTotalHoursInUserCardStep() {
		driver = CommonHelper.driver;
		activity = new activityPageComponenets(driver);
	}

	@When("Switch to other {string}")
	public void switch_to_other(String orgName) throws InterruptedException {
		activity.changeTheOrganization(orgName);
	}

	@When("select the {string} in the leftside menubar")
	public void select_the_in_the_leftside_menubar(String title) throws InterruptedException {
		activity.selectTitle(title);
	}

	@When("click on {string} screenshot")
	public void click_on_screenshot(String name) throws InterruptedException {
		activity.viewScreenshot(name);
	}

	@Then("Verify the total hours in the user card")
	public void verify_the_total_hours_in_the_user_card() {
		activity.verifyHours();
	}

}
