package com.sid.web.testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sid.web.testng.core.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText = "Form Authentication")
	private WebElement linkLogIn;

	public void clickLogInLink() {
		linkLogIn.click();
	}

}
