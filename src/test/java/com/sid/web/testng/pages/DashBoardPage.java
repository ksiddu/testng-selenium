package com.sid.web.testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.sid.web.testng.core.BasePage;

public class DashBoardPage extends BasePage {

	public DashBoardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = ".logout")
	private WebElement linkLogout;

	@FindBy(css = ".account")
	private WebElement linkMyAccount;

	public void logout() {
		linkLogout.click();

	}

	public void clickMyAccount() {
		linkMyAccount.click();

	}

	public void verifyUserName(String text) {
		Assert.assertTrue(linkMyAccount.isDisplayed());
		Assert.assertEquals(linkMyAccount.getText(), text);

	}

}
