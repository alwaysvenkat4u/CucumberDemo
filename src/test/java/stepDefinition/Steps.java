package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.LoginPage;

public class Steps {
	public WebDriver driver;
	public LoginPage lp;
	
	@Before()
	public void browserSetup() {
		System.out.println("Browser setup");
		
		
	   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
	   driver=new ChromeDriver();
	   lp=new LoginPage(driver);
	}

	@When("User navigate to URL {string}")
	public void user_navigate_to_url(String url) {
		driver.manage().window().maximize();
	    driver.get(url);
	}

	@And("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	   lp.setUserName(email);
	   lp.setPassword(password);
	}

	@And("Click on Login")
	public void click_on_login() {
	   lp.clickLogin();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
	   
		if(driver.getPageSource().contains("Login was unsuccessful")) {
			System.out.println("Login was unsuccessful");
			driver.close();
			Assert.assertTrue(false);
		}else {
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("User click on LogOut link")
	public void user_click_on_log_out_link() throws InterruptedException {
	    lp.clickLogout();
	    Thread.sleep(3000);
	}

	@After
	public void closeBrowser() {
		driver.quit();
	   
	}


}
