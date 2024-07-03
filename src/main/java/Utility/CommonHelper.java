package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonHelper {
	
	public static WebDriver driver;

	public CommonHelper() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Softsuave\\git\\SeleniumWithCucumber\\Resources\\testConfig.properties");
		Properties prop = new Properties();
		prop.load(fis);
		CONSTANT.URL = prop.getProperty("url");
		CONSTANT.BROWSER = prop.getProperty("browser");
		CONSTANT.EMAIL = prop.getProperty("email");
		CONSTANT.PASSWORD = prop.getProperty("password");
	}
	
	public static void clearTextbox(WebElement textfield) {
		textfield.sendKeys(Keys.CONTROL + "a");
		textfield.sendKeys(Keys.BACK_SPACE);
	}
}
