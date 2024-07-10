package Step_definitions;

import org.openqa.selenium.WebDriver;
import PageObject.inviteMemberPageComponents;
import Utility.CommonHelper;
import io.cucumber.java.en.*;

public class inviteMemberStep {

	WebDriver driver;
	public inviteMemberPageComponents invite;

	public inviteMemberStep() {
		driver = CommonHelper.driver;
		invite = new inviteMemberPageComponents(driver);
	}

	@When("invite user with {string} and {string}")
	public void invite_user_with_and(String emailAddress, String role) {
		invite.inviteMember(emailAddress, role);
	}

	@When("resend the invitation {string}")
	public void resend_the_invitation(String emailId) {
		invite.members(emailId);
	}

}
