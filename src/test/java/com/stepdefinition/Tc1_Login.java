package com.stepdefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.libglobal.BaseClass;
import com.pom.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Tc1_Login extends BaseClass {

	LoginPage l;

	@Given("user should be in the login page")
	public void userShouldBeInTheLoginPage() {
		
	}

	@When("user should enter valid email and password")
	public void userShouldEnterValidEmailAndPassword() {

		l = new LoginPage();

		WebElement emailField = l.getEmailField();
		WebElement passwordField = l.getPasswordField();

		enterText(emailField, "intern@taqtics.co");
		enterText(passwordField, "TestIntern@123");
	}

	@When("user should click in the login button")
	public void userShouldClickInTheLoginButton() {
		l = new LoginPage();
		WebElement loginButton = l.getLoginButton();
		clickElement(loginButton);
	}

	@Then("users should be redirected to the dashboard page")
	public void usersShouldBeRedirectedToTheDashboardPage() {
		System.out.println("Im in dashboard");

		l = new LoginPage();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement dashBoardText = l.getDashBoardText();

		Assert.assertTrue("Dashboard View", dashBoardText.isDisplayed());
		
		
	}

	@When("user should enter valid email and an invalid password")
	public void userShouldEnterValidEmailAndAnInvalidPassword() {
		l = new LoginPage();
		WebElement emailField = l.getEmailField();
		WebElement passwordField = l.getPasswordField();

		enterText(emailField, "admin@gmail.com");
		enterText(passwordField, "admin");
	}

	@When("user should click on the login button")
	public void userShouldClickOnTheLoginButton() {
		l = new LoginPage();
		WebElement loginButton = l.getLoginButton();
		clickElement(loginButton);
	}

	@Then("user should see an error message")
	public void userShouldSeeAnErrorMessage() {
		System.out.println("Invalid login details");
		
		l = new LoginPage();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement dashBoardText = l.getDashBoardText();
		
		Assert.assertEquals("Invalid email or password", "Process & Workflow", dashBoardText);
		
		
	}

}
