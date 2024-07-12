package Step_definitions;

import org.openqa.selenium.WebDriver;
import PageObject.tasksPageComponents;
import Utility.CommonHelper;
import io.cucumber.java.en.*;

public class taskStep {
	
	WebDriver driver;
	public tasksPageComponents tasks;

	public taskStep() {
		driver = CommonHelper.driver;
		tasks = new tasksPageComponents(driver);
	}
	
	@When("create new {string}")
	public void new_task(String taskname) {
		tasks.createTask(taskname);
	}

	@And("delete the {string}")
	public void deleteTasks(String taskname) {
		tasks.deleteTask(taskname);
	}

	@And("edit the {string} and verify {string}")
	public void editTasks(String taskname, String validationText) {
		tasks.editTask(taskname, validationText);
	}
}
