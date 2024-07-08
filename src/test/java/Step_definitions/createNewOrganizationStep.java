package Step_definitions;

import org.openqa.selenium.WebDriver;
import PageObject.organizationPageComponents;
import Utility.CommonHelper;
import io.cucumber.java.en.*;

public class createNewOrganizationStep {
	
	public WebDriver driver;
	public organizationPageComponents org;

	
	public createNewOrganizationStep() {
		driver = CommonHelper.driver;
		org = new organizationPageComponents(driver);
	}
	
	@When("create new organization {string},{string} and {string}")
	public void create_new_organization_and(String organizationName, String description, String location) throws InterruptedException {
		org.createOrganization(organizationName, description, location);
	}

	@When("click on submit")
	public void click_on_submit() {
		org.clickOnSubmit();
	}

	@Then("Verify {string} and {string} validation message")
	public void verify_and_validation_message(String string, String string2, String organization, String description) {
		org.validateMessages(organization, description);
	}

	@Then("edit the organization {string},{string} and {string}")
	public void edit_the_organization_and(String string, String string2, String string3, String oldname, String newName, String description) throws InterruptedException {
		org.editOrganization(oldname,newName, description);
	}

	@When("Switch to second organization")
	public void switch_to_second_organization(String name) throws InterruptedException {
		org.deleteOrg(name);
	}

	@Then("delete organization {string}")
	public void delete_organization(String string, String name) throws InterruptedException {
		org.deleteOrg(name);
	}
}
