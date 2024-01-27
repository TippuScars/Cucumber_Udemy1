package stepDefinations;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class InvalidLogin {
	
	WebDriver driver;
	//Invalid Login 
	@Given("the user is on Login page")
	public void the_user_is_on_login_page() {
	    driver = new ChromeDriver();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    
	    
	}

	@When("the user enters invalid credentials\\(username: {string},password: {string})")
	public void the_user_enters_invalid_credentials_username_password(String email, String pswd){
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(email);
	    driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pswd);
	  
	}

	@When("the user clicks on login button")
	public void the_user_clicks_on_login_button() {
		 driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	   	}

	@Then("the user should not be displayed dashboard page")
	public void the_user_should_not_be_displayed_dashboard_page() {
		boolean status = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).isDisplayed();
		Assert.assertEquals(status, false);
	}

}
