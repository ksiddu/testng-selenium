package com.sid.web.testng.core;

import org.openqa.selenium.WebDriver;

import com.sid.web.testng.pages.DashBoardPage;
import com.sid.web.testng.pages.HomePage;
import com.sid.web.testng.pages.LoginPage;

public class Pages {
	
	public HomePage homePage;
    public LoginPage loginPage;
    public DashBoardPage dashBoardPage;
    
	public Pages(WebDriver driver) {
		 homePage = new HomePage(driver);
		 loginPage = new LoginPage(driver);
		 dashBoardPage = new DashBoardPage(driver);
		
	}

}
