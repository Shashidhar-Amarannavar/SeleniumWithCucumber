package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Softsuave\\git\\SeleniumWithCucumber\\Features\\LoginPage\\Login.feature", glue = {
		"Step_definitions", "Base" }, monochrome = true, dryRun = false, plugin = { "pretty",
				"html:target/cucumber-reports.html" })

public class RunTest {

}
