package runnerPackage;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

@CucumberOptions(features={"features"}, glue={"stepDefinitionPackage"})
public class TestRunner extends AbstractTestNGCucumberTests {
	public static WebDriver driver;
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup(); //maven
		driver=new ChromeDriver();
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("-- System test initiated --");
		System.out.println("--------------------------------------------------------------------------------------------");

	}
	
	@AfterTest
	public void afterTest() throws InterruptedException {
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("-- test completed and tear down completed --");
		System.out.println("--------------------------------------------------------------------------------------------");

		Thread.sleep(2000);
		driver.close();
	}

}
