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
	
	@And("Delete the invited {string}")
	public void deleteInvitation(String emailId) {
		invite.deleteInvite(emailId);
	}

	@And("resend the invitation {string}")
	public void resendInvitation(String emailId) {
		invite.reInvite(emailId);
	}

	@And("invite user with {string}")
	public void invites(String emailId) {
		invite.members(emailId);
	}
}
