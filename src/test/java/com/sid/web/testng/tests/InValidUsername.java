package com.sid.web.testng.tests;

import org.testng.annotations.Test;
import com.sid.web.testng.core.BaseTest;

public class InValidUsername extends BaseTest {

	@Test
	public void validLogin() {

		long id = Thread.currentThread().getId();
		System.out.println("LoginTest Class. Thread id is: " + id);

		String loginUrl = prop.getValue("test_url");
		pages.homePage.goToUrl(loginUrl);

		pages.homePage.verifyTitle(prop.getValue("homepage_title"));

		pages.homePage.clickLogInLink();
		pages.loginPage.verifyHeader(prop.getValue("loginpage_title"));

		pages.loginPage.login("InvalidUsername", prop.getValue("password"));

		pages.loginPage.verifyErrorMsg(prop.getValue("invalid_username_message"));

	}
}
