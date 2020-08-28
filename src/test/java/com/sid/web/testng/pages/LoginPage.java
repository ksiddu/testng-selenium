package com.sid.web.testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.sid.web.testng.core.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = ".example h2")
	private WebElement headerLogInPage;

	@FindBy(id = "username")
	private WebElement txtEmail;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(className = "radius")
	private WebElement btnLogIn;

	@FindBy(id = "flash-messages")
	private WebElement eleErrorMsg;

	String expectedAuthFailMsg = "Your username is invalid!";

	public void login(String userName, String password) {
		txtEmail.sendKeys(userName);
		txtPassword.sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(btnLogIn));
		btnLogIn.click();

	}

	public void verifyErrorMsg(String message) {
		Assert.assertTrue(eleErrorMsg.getText().trim().contains(message));
	}

}
