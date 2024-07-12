package PageObject;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utility.CommonHelper;
import Utility.ExplicitWait;
import Utility.Page_factory;

public class tasksPageComponents extends Page_factory{
	
	public WebDriver driver;
	public ExplicitWait wait;
	
	public tasksPageComponents(WebDriver driver) {
		super(driver);
		wait = new ExplicitWait(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//button[text()='Add Task']")
	WebElement addTask;

	@FindBy(xpath = "(//div[text()='Task Name *']/..//input)[1]")
	WebElement taskName;

	@FindBy(xpath = "(//div[text()='Task Name *']/..//input)[2]")
	WebElement description;

	@FindBy(xpath = "//button[text()='Create']")
	WebElement createButton;

	@FindBy(xpath = "//li[text()='Edit']")
	WebElement editButton;

	@FindBy(xpath = "//li[text()='Delete']")
	WebElement deleteButton;

	@FindBy(css = "[name=\"submitText\"]")
	WebElement yesButton;

	@FindBy(xpath = "(//div[text()='Task Name *']/..//p)[1]")
	WebElement tasknameErrorText;

	public void createTask(String taskname) {
		wait.waitForVisibility(addTask);
		addTask.click();
		taskName.sendKeys(taskname);
		createButton.click();	
	}

	public void editTask(String taskname, String expectedText) {
		wait.waitForVisibility(By.xpath("//td[text()='" + taskname + "']/..//button"));
		driver.findElement(By.xpath("//td[text()='" + taskname + "']/..//button")).click();
		editButton.click();
		CommonHelper.clearTextbox(taskName);
		String actutalText = tasknameErrorText.getText().stripTrailing();
		assertEquals(actutalText, expectedText);
		taskName.sendKeys(taskname + "s");
		createButton.click();
	}

	public void deleteTask(String taskname) {
		wait.waitForVisibility(By.xpath("//td[text()='" + taskname+ "s" + "']/..//button"));
		driver.findElement(By.xpath("//td[text()='" + taskname+ "s" + "']/..//button")).click();
		deleteButton.click();
		yesButton.click();
	}

}
