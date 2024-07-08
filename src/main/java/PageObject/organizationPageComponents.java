package PageObject;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utility.CommonHelper;
import Utility.ExplicitWait;
import Utility.Page_factory;

public class organizationPageComponents extends Page_factory {

	public WebDriver driver;
	public static ExplicitWait wait;

	public organizationPageComponents(WebDriver driver) {
		super(driver);
		wait = new ExplicitWait(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//p[text()='+ Create New Organization']")
	WebElement createOrgButton;

	@FindBy(xpath = "//button[text()='Create a new Organization']")
	WebElement createNewOrg;

	@FindBy(xpath = "//input[@name=\"name\"]")
	WebElement orgName;

	@FindBy(xpath = "//textarea[@name=\"description\"]")
	WebElement orgDescription;

	@FindBy(xpath = "//label[text()='Organization Name *']/..//p//span")
	WebElement orgNameValidaton;

	@FindBy(xpath = "//label[text()='Organization Description *']/..//p//span")
	WebElement descriptionValidaton;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement submitButton;

	@FindBy(xpath = "//input[@type=\"file\"]")
	WebElement uploadLogo;

	@FindBy(xpath = "//button[@name=\"submitText\"]")
	WebElement yesButton;

	@FindBy(xpath = "//header//button[@type=\"button\"]")
	WebElement switchOrgButton;

	@FindBy(xpath = "(//div[@role=\"presentation\"]//div/div/p)[2]")
	WebElement selectSecondOrg;

	public void createOrganization(String organizationName, String description, String location)
			throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			wait.waitForVisibility(createOrgButton);
			js.executeScript("arguments[0].click();", createOrgButton);
		} catch (Exception e) {
			createNewOrg.click();
		}
		wait.waitForVisibility(orgName);
		orgName.sendKeys(organizationName);
		orgDescription.sendKeys(description);
		try {
			uploadLogo.sendKeys(location);
			Thread.sleep(2000);
		} catch (Exception e) {
			Thread.sleep(2000);
		}
	}

	public void clickOnSubmit() {
		submitButton.click();
	}

	public void deleteOrg(String orgName) throws InterruptedException {
		Thread.sleep(2000);
		wait.waitForVisibility(By.xpath("//p[text()='" + orgName + "']/../../..//div//p[text()='Delete']"));
		driver.findElement(By.xpath("//p[text()='" + orgName + "']/../../..//div//p[text()='Delete']")).click();
		yesButton.click();
	}

	public void validateMessages(String organizationName, String description) {
		wait.waitForVisibility(orgNameValidaton);
		String actualName = orgNameValidaton.getText().stripTrailing();
		assertEquals(actualName, organizationName);
		wait.waitForVisibility(descriptionValidaton);
		String actualText = descriptionValidaton.getText().stripTrailing();
		assertEquals(actualText, description);
	}

	public void editOrganization(String oldname, String newName, String description) throws InterruptedException {
		Thread.sleep(2000);
		wait.waitForVisibility(By.xpath("//p[text()='" + oldname + "']/../../..//div//p[text()='Edit']"));
		driver.findElement(By.xpath("//p[text()='" + oldname + "']/../../..//div//p[text()='Edit']")).click();
		wait.waitForVisibility(orgName);
		CommonHelper.clearTextbox(orgName);
		orgName.sendKeys(newName);
		orgDescription.sendKeys(description);
		submitButton.click();
	}

	public void changeToSecondOrg() {
		wait.waitForVisibility(switchOrgButton);
		switchOrgButton.click();
		wait.waitForVisibility(selectSecondOrg);
		selectSecondOrg.click();
	}
	
	public void changeTheOrganization(String orgName) throws InterruptedException {
		wait.waitForVisibility(switchOrgButton);
		switchOrgButton.click();
		Thread.sleep(3000);
		wait.waitForVisibility(By.xpath("//div[@role=\"presentation\"]//p[text()='"+orgName+"']"));
		driver.findElement(By.xpath("//div[@role=\"presentation\"]//p[text()='"+orgName+"']")).click();
	}
}
