package com.sid.web.testng.tests;

import org.testng.annotations.Test;
import com.sid.web.testng.core.BaseTest;

public class LoginTest extends BaseTest {

	@Test
	public void validLogin() {

		String loginUrl = prop.getValue("login_url");
		pages.homePage.goToUrl(loginUrl);

		pages.homePage.verifyTitle(prop.getValue("homepage_title"));

		pages.homePage.clickSignInLink();
		pages.loginPage.verifyTitle(prop.getValue("loginpage_title"));

		pages.loginPage.login(prop.getValue("email"), prop.getValue("password"));

		pages.dashBoardPage.verifyTitle(prop.getValue("dashboardpage_title"));
		pages.dashBoardPage.verifyUserName(prop.getValue("username"));

		pages.dashBoardPage.logout();
		pages.loginPage.verifyTitle(prop.getValue("loginpage_title"));

	}
}
