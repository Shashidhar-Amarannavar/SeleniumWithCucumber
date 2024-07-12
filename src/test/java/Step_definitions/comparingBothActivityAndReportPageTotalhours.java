package Step_definitions;

import org.openqa.selenium.WebDriver;

import PageObject.reportPageComponents;
import Utility.CommonHelper;
import io.cucumber.java.en.Then;

public class comparingBothActivityAndReportPageTotalhours {

	public WebDriver driver;
	public reportPageComponents report;
	
	public comparingBothActivityAndReportPageTotalhours() {
		driver=CommonHelper.driver;
		report = new reportPageComponents(driver);
	}

	@Then("select the {string} and compare both page total hours")
	public void compareTotalhours(String userName) throws InterruptedException {
		report.compareBothTotalHours(userName);
	}
}
