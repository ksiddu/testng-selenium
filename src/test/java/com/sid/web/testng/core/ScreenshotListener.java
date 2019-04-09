package com.sid.web.testng.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ScreenshotListener extends TestListenerAdapter {

	@Override
	public void onTestFailure(ITestResult result) {
		Object currentClass = result.getInstance();
		WebDriver webDriver = ((BaseTest) currentClass).driver;
		Path currentRelativePath = Paths.get("");
		String screenshotPath = currentRelativePath.toAbsolutePath().toString() + "/screenShots/";
		String screenShotName = screenshotPath + UUID.randomUUID().toString() + ".png";

		if (webDriver != null) {

			File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File(screenShotName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
