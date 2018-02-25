package stepDefinitionPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import runnerPackage.TestRunner;

public class stepDefinition extends TestRunner{
	@Given("^I navigate to google homepage$")
	public void i_navigate_to_google_homepage(){
		driver.manage().window().maximize();

		driver.navigate().to("http://www.google.com");
		
	}

	@When("^I enter a keyword to search$")
	public void i_enter_a_keyword_to_search() throws InterruptedException {
		WebElement searchBox=driver.findElement(By.name("q"));
		//Thread.sleep(2000);
		searchBox.sendKeys("porsche");// +Keys.ENTER);
	}
	@When("^I click on the search button$")
	public void i_click_on_the_search_button() {
		WebElement searchBtn=driver.findElement(By.name("btnK"));
		searchBtn.click();
	}

	@Then("^I should be able to see the title contains the keyword$")
	public void i_should_be_able_to_see_the_title_contains_the_keyword() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(driver.getTitle().contains("porsche"));
	}
}
