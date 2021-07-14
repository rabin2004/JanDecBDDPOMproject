package step_definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.Main;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SignOnPageTest extends Main{
	WebElement usernameTxtField;
	WebElement passwordTxtField;
	WebElement submitBtn;

	@Given("registered user is in sign-on page")
	public void registered_user_is_in_sign_on_page() {
	    driver.findElement(By.linkText("SIGN-ON")).click();
	    Assert.assertEquals(driver.getTitle(), "Sign-on: Mercury Tours");
	}
	
	@Then("user should be able to see username textfield, password textfield and submit button")
	public void user_should_be_able_to_see_username_textfield_password_textfield_and_submit_button() {
		usernameTxtField = driver.findElement(By.name("userName"));
		passwordTxtField = driver.findElement(By.name("password"));
		submitBtn = driver.findElement(By.name("submit"));
		
		Assert.assertTrue(usernameTxtField.isDisplayed());
		Assert.assertTrue(passwordTxtField.isDisplayed());
		Assert.assertTrue(submitBtn.isDisplayed());
	}

	@And("username textfield, password textfield and submit button should be functional all times")
	public void username_textfield_password_textfield_and_submit_button_should_be_functional_all_times() {
		Assert.assertTrue(usernameTxtField.isEnabled());
		Assert.assertTrue(passwordTxtField.isEnabled());
		Assert.assertTrue(submitBtn.isEnabled());
	}



}
