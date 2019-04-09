package com.sid.web.testng.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.sid.web.testng.utils.BrowserFactory;
import com.sid.web.testng.utils.PropertyUtil;

public abstract class BaseTest {
	protected WebDriver driver;
	protected Pages pages;
	protected PropertyUtil prop = new PropertyUtil("src/test/resources/config.properties");

	@BeforeClass
	public void setup() {

		// Create a Chrome driver. All test classes use this.

		try {
			driver = BrowserFactory.getDriver("chrome");
			pages = new Pages(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Maximize Window
		//driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
