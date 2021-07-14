package step_definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.Main;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationFunctionalityTest extends Main{
	
	@Given("user is at registration page")
	public void user_is_at_registration_page() {
		driver.findElement(By.linkText("REGISTER")).click();
		Assert.assertEquals(driver.getTitle(), "Register: Mercury Tours");
	}

	@When("user provides firstName, lastName, phone number, email address, address, city, state, postal code, country, userName, password and confirm password")
	public void user_provides_first_name_last_name_phone_number_email_address_address_city_state_postal_code_country_user_name_password_and_confirm_password() {
		driver.findElement(By.name("firstName")).sendKeys("tom");
		driver.findElement(By.name("lastName")).sendKeys("Frisker");
		driver.findElement(By.name("phone")).sendKeys("123456789");
		driver.findElement(By.name("userName")).sendKeys("tomf@gmail.com");
		
		driver.findElement(By.name("address1")).sendKeys("123 Graham Ave");
		driver.findElement(By.name("city")).sendKeys("Brooklyn");
		driver.findElement(By.name("state")).sendKeys("NY");
		driver.findElement(By.name("postalCode")).sendKeys("12345");
		
		WebElement countryDropDown = driver.findElement(By.name("country"));
		Select select = new Select(countryDropDown);
		select.selectByVisibleText("India".toUpperCase());
		
		driver.findElement(By.name("email")).sendKeys("tomf");
		driver.findElement(By.name("password")).sendKeys("tf123");
		driver.findElement(By.name("confirmPassword")).sendKeys("tf123");	
	}

	@And("user clicks submit button")
	public void user_clicks_submit_button() {
		driver.findElement(By.name("submit")).click();
	}

	@Then("user should be registered")
	public void user_should_be_registered() {
		WebElement registrationSuccessfulMsg = driver.findElement(By.xpath
				("//table[@width='492']/tbody/tr[3]/td/p[3]"));
		Assert.assertTrue(registrationSuccessfulMsg.isDisplayed());	
	}
	
	@When("user hits enter tab")
	public void user_hits_enter_tab() {
		driver.findElement(By.name("submit")).sendKeys(Keys.ENTER);
	}
}
