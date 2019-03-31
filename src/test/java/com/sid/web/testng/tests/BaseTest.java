package com.sid.web.testng.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.sid.web.testng.utils.BrowserFactory;
import com.sid.web.testng.utils.PropertyUtil;

public class BaseTest {
	protected WebDriver driver;
	protected Pages pages;
	PropertyUtil prop = new PropertyUtil("src/test/resources/config.properties");

	@BeforeClass
	public void setup() {

		// Create a Chrome driver. All test classes use this.
		// driver = new ChromeDriver();
		try {
			driver = BrowserFactory.getDriver("chrome");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Maximize Window
		driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
