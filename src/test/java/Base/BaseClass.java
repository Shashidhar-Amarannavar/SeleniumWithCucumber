package Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Utility.CONSTANT;
import Utility.CommonHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public BaseClass() throws IOException {
		CommonHelper common = new CommonHelper();
			
	}
	
	@Before
	public void launch() {
		switch ((CONSTANT.BROWSER).toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			CommonHelper.driver = driver;
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			break;
		case "firefox":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			CommonHelper.driver = driver;
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			CommonHelper.driver = driver;
			break;
		}
	}

	@After
	public void teardown() {
		driver.quit();
	}

}
