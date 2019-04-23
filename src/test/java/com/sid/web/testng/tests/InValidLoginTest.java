package com.sid.web.testng.tests;

import org.testng.annotations.Test;

import com.sid.web.testng.core.BaseTest;

public class InValidLoginTest extends BaseTest {

	@Test
	public void inValidLogin() {

		long id = Thread.currentThread().getId();
		System.out.println("InValidLoginTest Class. Thread id is: " + id);

		String loginUrl = prop.getValue("login_url");
		pages.homePage.goToUrl(loginUrl);

		pages.homePage.verifyTitle(prop.getValue("homepage_title"));

		pages.homePage.clickSignInLink();
		pages.loginPage.verifyTitle(prop.getValue("loginpage_title"));

		pages.loginPage.login(prop.getValue("email"), "Invalid Password");

		pages.loginPage.verifyErrorMsg("There is 1 error\n" + "Authentication failed.");

	}
}
