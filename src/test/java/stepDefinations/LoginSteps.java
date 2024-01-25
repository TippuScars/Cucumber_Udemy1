package stepDefinations;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {
	WebDriver driver;
	
	@Given("the user is on the Login page")
	public void the_user_is_on_the_login_page() {
		driver = new ChromeDriver();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	}

	@When("the user enters valid credentials\\(username: {string}, password: {string})")
	public void the_user_enters_valid_credentials(String email, String pswd) {
	    driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(email);
	    driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pswd);
	}

	@Then("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() {
	    driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
    @Then("the user should be redirected to Dashboard page")
    public void the_user_should_be_redirected_to_Dashboard_page() {
    	boolean status = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).isDisplayed();
    	Assert.assertEquals(status, true);
    	
    }
    
    @Then("the user should see a welcome message")
	public void the_user_should_see_a_welcome_message() {
	   boolean status = driver.findElement(By.xpath("//p[normalize-space()='Time at Work']")).isDisplayed();
	   Assert.assertEquals(status, true);
	}


}
