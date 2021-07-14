package step_definitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.Main;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFunctionalityTest extends Main{
	String expectedurl = "http://demo.guru99.com/test/newtours/index.php";
	String expectedMsg = "Login Successfully";
	
	@Given("registered user is in homepage")
	public void registered_user_is_in_homepage() {
		Assert.assertEquals(driver.getCurrentUrl(), expectedurl);
	}
	
	@When("user provides valid username and valid password")
	public void user_provides_valid_username_and_valid_password() {
		driver.findElement(By.name("userName")).sendKeys("test123");
		driver.findElement(By.name("password")).sendKeys("123");
	}
	
	@And("user clicks on submit button")
	public void user_clicks_on_submit_button() {
		driver.findElement(By.name("submit")).click();
	}
	
	@Then("user should be able to login and see login success message")
	public void user_should_be_able_to_login_and_see_login_success_message() {
		String actualMsg = driver.findElement(By.xpath("//table[@width='492']/tbody/tr[1]")).getText();
		Assert.assertEquals(actualMsg, expectedMsg);
	}
	
	// In cucumber -> duplicate scenario step's implementation or automation method will be reused
	
	@And("user hits enter button from keypad")
	public void user_hits_enter_button_from_keypad() {
	    driver.findElement(By.name("submit")).sendKeys(Keys.ENTER);
	}
	
	@When("user provides invalid username and valid password")
	public void user_provides_invalid_username_and_valid_password() {
		driver.findElement(By.name("userName")).sendKeys("tom12345");
		driver.findElement(By.name("password")).sendKeys("12345");
	}

	@Then("user should not be able to login and should see error message")
	public void user_should_not_be_able_to_login_and_should_see_error_message() {
		WebElement loginErrorMsg = driver.findElement(By.
				xpath("//input[@name='password']/following-sibling::span"));
		Assert.assertTrue(loginErrorMsg.isDisplayed());
	}
	
	@When("user provides valid credentials username {string} and password {string}")
	public void user_provides_valid_credentials_username_and_password(String username, String password) {
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
	@When("user provides valid credentials")
	public void user_provides_valid_credentials(DataTable credentials) {
		List<List<String>> data = credentials.asLists();
//		System.out.println(data.get(1).get(0));
//		System.out.println(data.get(1).get(1));
//		System.out.println(data.get(2).get(0));
//		System.out.println(data.get(2).get(1));
		
//		for(int i=1; i<data.size(); i++) {
//		driver.findElement(By.name("userName")).sendKeys(data.get(i).get(0));
//		driver.findElement(By.name("password")).sendKeys(data.get(i).get(1));
//		}
		
		driver.findElement(By.name("userName")).sendKeys(data.get(1).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(1).get(1));
	}
	
//	@When("user provides valid credentials {string} {int}")
//	public void user_provides_valid_credentials_test123(String username, Integer password) {
//		driver.findElement(By.name("userName")).sendKeys(username);
//		driver.findElement(By.name("password")).sendKeys(Integer.toString(password));
//	}

//	@When("^user provides valid credentials (.+) (.+)$") // expressions to recognize data
//	public void user_provides_valid_credentials(String validusername, String validpassword) {
//		driver.findElement(By.name("userName")).sendKeys(validusername);
//		driver.findElement(By.name("password")).sendKeys(validpassword);
//	}
	
	@When("^user provides valid credentials \"(.*)\" \"(.*)\"$") // expressions to recognize data
	public void user_provides_valid_credentials(String validusername, String validpassword) {
		driver.findElement(By.name("userName")).sendKeys(validusername);
		driver.findElement(By.name("password")).sendKeys(validpassword);
	}
	
//	@When("user provides valid credentials {string} {string}")
//	public void user_provides_valid_credentials(String validusername, String validpassword) {
//		driver.findElement(By.name("userName")).sendKeys(validusername);
//		driver.findElement(By.name("password")).sendKeys(validpassword);
//	}








	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
