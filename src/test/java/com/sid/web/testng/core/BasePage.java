package com.sid.web.testng.core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	private static final int TIMEOUT = 10;
	private static final int POLLING = 100;
	private static final int PAGE_LOAD_TIMEOUT = 30;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(driver, this);
	}

	// Wait Wrapper Method
	// protected void waitVisibility(WebElement elementBy) {
	// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
	// }

	protected void isExist(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected void isNotExist(By locator) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	protected void conatinsText(By locator, String text) {
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
		// wait.until(ExpectedConditions.visibilityOf(element))
	}

	// wait.u
	protected void AcceptAlert() {

		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	protected void DismissAlert() {

		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}

	protected String GetAlertText() {

		Alert alert = driver.switchTo().alert();

		return alert.getText();

	}

	public void goToUrl(String url) {
		driver.get(url);
	}

	public void verifyTitle(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	}

	public void verifyText(WebElement ele, String text) {
		Assert.assertEquals(ele.getText(), text);
	}

}
