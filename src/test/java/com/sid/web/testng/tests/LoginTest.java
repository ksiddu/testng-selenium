package com.sid.web.testng.tests;

import org.testng.annotations.Test;

import com.sid.web.testng.pages.*;

public class LoginTest extends BaseTest {

	@Test
	public void validLogin() {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		// Click on sign in link
		String loginUrl = prop.getValue("login_url");
		homePage.goToUrl(loginUrl);

		homePage.verifyTitle(prop.getValue("homepage_title"));

		homePage.clickSignInLink();
		loginPage.verifyTitle(prop.getValue("loginpage_title"));

		loginPage.login(prop.getValue("email"), prop.getValue("password"));

		dashBoardPage.verifyTitle(prop.getValue("dashboardpage_title"));
		dashBoardPage.verifyUserName(prop.getValue("username"));

		dashBoardPage.logout();
		loginPage.verifyTitle(prop.getValue("loginpage_title"));

	}
}
