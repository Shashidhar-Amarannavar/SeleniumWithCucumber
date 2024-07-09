package PageObject;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utility.CONSTANT;
import Utility.ExplicitWait;
import Utility.Page_factory;

public class activityPageComponenets extends Page_factory {

	public WebDriver driver;
	public static ExplicitWait wait;
	public boolean userPresent = true;
	public boolean value;

	public activityPageComponenets(WebDriver driver) {
		super(driver);
		wait = new ExplicitWait(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//span[text()='Activity']")
	WebElement activity;

	@FindBy(xpath = "//p[text()='Activity']/following-sibling::div/p")
	WebElement totalHoursSection;

	@FindBy(xpath = "//header//button[@type=\"button\"]")
	WebElement switchOrgButton;
	
	public void selectTitle(String title) throws InterruptedException {
		wait.waitForVisibility(driver.findElement(By.xpath("//span[text()='" + title + "']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='" + title + "']")).click();
		Thread.sleep(3000);
	}

	public void viewScreenshot(String name) throws InterruptedException {
		try {
			value = driver
					.findElement(By.xpath("//p[text()='" + name
							+ "']/../../following-sibling::div//p[text()='Total Hours']/following-sibling::p"))
					.isDisplayed();
		} catch (NoSuchElementException e) {
		}
		if (value) {
			String hours = driver
					.findElement(By.xpath("//p[text()='" + name
							+ "']/../../following-sibling::div//p[text()='Total Hours']/following-sibling::p"))
					.getText();
			CONSTANT.TOTALHOURS = hours.split(" : ");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//p[text()='" + name + "']/../../a")).click();
		} else {
			userPresent = value;
		}
	}

	public void verifyHours() {
		if (userPresent) {
			wait.waitForVisibility(totalHoursSection);
			String actualHour = totalHoursSection.getText();
			String[] ActualHour = actualHour.split(" ");
			try {
				assertEquals(CONSTANT.TOTALHOURS[0] + CONSTANT.TOTALHOURS[1], ActualHour[2] + ActualHour[5] + " hrs");
			} catch (Exception e) {
				assertEquals(CONSTANT.TOTALHOURS[0] + CONSTANT.TOTALHOURS[1], "00" + ActualHour[2] + " hrs");
			}
		} else {
			System.out.println("User not found !!!");
		}
	}
	
	public void changeTheOrganization(String orgName) throws InterruptedException {
		wait.waitForVisibility(switchOrgButton);
		switchOrgButton.click();
		Thread.sleep(3000);
		wait.waitForVisibility(By.xpath("//div[@role=\"presentation\"]//p[text()='"+orgName+"']"));
		driver.findElement(By.xpath("//div[@role=\"presentation\"]//p[text()='"+orgName+"']")).click();
	}
}
