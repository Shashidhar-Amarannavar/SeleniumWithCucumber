package PageObject;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utility.CommonHelper;
import Utility.ExplicitWait;
import Utility.Page_factory;

public class updateProfilePageComponents extends Page_factory {
	public ExplicitWait wait;

	public updateProfilePageComponents(WebDriver driver) {
		super(driver);
		wait = new ExplicitWait(driver);
	}

	@FindBy(xpath = "//header/div/div/div/div/div/div")
	WebElement profileButton;

	@FindBy(xpath = "//button[text()='update Profile']")
	WebElement updateProfileButton;

	@FindBy(xpath = "//label[text()='FirstName *']/..//input")
	WebElement firstName;

	@FindBy(xpath = "//label[text()='LastName *']/..//input")
	WebElement lastName;

	@FindBy(css = "[type=\"submit\"]")
	WebElement updateButton;

	@FindBy(xpath = "//div[text()='Update User Info']/../img")
	WebElement closeButton;

	@FindBy(css = "[data-testid=\"ClearIcon\"]")
	WebElement close;

	@FindBy(xpath = "//label[text()='FirstName *']/..//span[@class=\"errorText\"]")
	WebElement firstnameValidation;

	@FindBy(xpath = "//label[text()='LastName *']/..//span[@class=\"errorText\"]")
	WebElement lastnameValidation;

	@FindBy(css = "[data-testid=\"PhotoCameraIcon\"]")
	WebElement editPictureButton;

	@FindBy(xpath = "//li[text()='Add new']")
	WebElement addNewButton;

	@FindBy(xpath = "//li[text()='Remove']")
	WebElement removeButton;

	@FindBy(css = "[type=\"file\"]")
	WebElement fileUpload;

	@FindBy(css = "[name=\"submitText\"]")
	WebElement yesButton;

	public void updateName(String firstname) throws InterruptedException {
		wait.waitForVisibility(profileButton);
		profileButton.click();
		wait.waitForVisibility(updateProfileButton);
		updateProfileButton.click();
		wait.waitForVisibility(firstName);
		String name = firstName.getAttribute("value");
		firstName.sendKeys(firstname);
		updateButton.click();
		Thread.sleep(2000);
		updateProfileButton.click();
		Thread.sleep(2000);
		CommonHelper.clearTextbox(firstName);
		firstName.sendKeys(name);
		updateButton.click();
	}

	public void withoutUpdate() throws InterruptedException {
		Thread.sleep(3000);
		wait.waitForVisibility(updateProfileButton);
		updateProfileButton.click();
		updateButton.click();
		closeButton.click();
	}

	public void verifyValidation(String firstname, String lastname) {
		wait.waitForVisibility(profileButton);
		profileButton.click();
		wait.waitForVisibility(updateProfileButton);
		updateProfileButton.click();
		wait.waitForVisibility(firstName);
		CommonHelper.clearTextbox(firstName);
		CommonHelper.clearTextbox(lastName);
		assertEquals(firstnameValidation.getText().stripTrailing(), firstname);
		assertEquals(lastnameValidation.getText().stripTrailing(), lastname);

	}

	public void uploadFile(String path) throws InterruptedException {
		if (path.isEmpty()) {
			wait.waitForVisibility(profileButton);
			profileButton.click();
			wait.waitForVisibility(editPictureButton);
			editPictureButton.click();
			wait.waitForVisibility(addNewButton);
			addNewButton.click();
			try {
				Thread.sleep(2000);
				fileUpload.sendKeys(path);
				Thread.sleep(2000);
			} catch (Exception e) {
				Thread.sleep(2000);
			}
			updateButton.click();
		} else {
			fileUpload.sendKeys(path);
			updateButton.click();
		}
	}

	public void deleteProfilePhoto() {
		wait.waitForVisibility(profileButton);
		profileButton.click();
		wait.waitForVisibility(editPictureButton);
		editPictureButton.click();
		try {
			wait.waitForVisibility(removeButton);
			removeButton.click();
			yesButton.click();
		} catch (Exception e) {
			System.out.println("Current user don't have profile photo");
		}
	}

}
