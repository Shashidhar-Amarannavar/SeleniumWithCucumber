package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page_factory {
	
	public Page_factory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
