package PageObject;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utility.CONSTANT;
import Utility.ExplicitWait;
import Utility.Page_factory;

public class reportPageComponents extends Page_factory {

	public WebDriver driver;
	public ExplicitWait wait;

	public reportPageComponents(WebDriver driver) {
		super(driver);
		wait = new ExplicitWait(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//p[text()='Report']/..//div[text()='Total Hours']/h1")
	WebElement totalHoursInReportPage;

	@FindBy(xpath = "(//p[text()='Report']/../div//div)[9]")
	WebElement selectUserDropdown;

	public void compareBothTotalHours(String userName) throws InterruptedException {
		if (CONSTANT.TOTALHOURS.length >= 0) {
			wait.waitForVisibility(selectUserDropdown);
			selectUserDropdown.click();
			driver.findElement(By.xpath("(//div[text()='" + userName + "'])[2]")).click();
			Thread.sleep(2000);
			String[] totalHours = totalHoursInReportPage.getText().split(" : ");
			assertEquals(CONSTANT.TOTALHOURS[0] + CONSTANT.TOTALHOURS[1], totalHours[0] + totalHours[1]);
		} else {
			System.out.println("User Don't have activity Hours.");
		}
	}

}
