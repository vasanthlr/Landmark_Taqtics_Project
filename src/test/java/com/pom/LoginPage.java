package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.libglobal.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement emailField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(xpath = "//span[text()='Log in']")
	WebElement loginButton;

	@FindBy(xpath = "//span[text()='Process & Workflow']")
	WebElement dashBoardText;
	
	@FindBy(xpath = "//span[text()='Not Found']")
	WebElement notFoundText;

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getDashBoardText() {
		return dashBoardText;
	}
	
	public WebElement getNotFoundText() {
		return notFoundText;
	}

}
