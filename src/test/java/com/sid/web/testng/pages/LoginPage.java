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

	@FindBy(id = "email")
	private WebElement txtEmail;

	@FindBy(id = "passwd")
	private WebElement txtPassword;

	@FindBy(id = "SubmitLogin")
	private WebElement btnSignIn;

	@FindBy(css = ".center_column > .alert.alert-danger")
	private WebElement eleErrorMsg;

	String expectedAuthFailMsg = "There is 1 error\n" + "Authentication failed.";

	public void login(String userName, String password) {
		txtEmail.sendKeys(userName);
		txtPassword.sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(btnSignIn));
		btnSignIn.click();

	}

	public void verifyErrorMsg(String message) {
		Assert.assertEquals(eleErrorMsg.getText(), message);

	}

}
