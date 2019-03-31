package com.sid.web.testng.utils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	private static final org.apache.logging.log4j.Logger logger = LogManager
			.getLogger(BrowserFactory.class.getSimpleName());

	public static WebDriver getDriver(String browserType) throws Exception {
		WebDriver driver = null;
		String driverPath = null;
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current relative path is: " + s);

		if (browserType.contentEquals("chrome")) {
			driverPath = getPlatformSpecificDriverPath();
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		} else if (browserType.contentEquals("firefox")) {
			s = s + "/exefiles/mac/geckodriver";
			System.setProperty("webdriver.gecko.driver", s);
			driver = new FirefoxDriver();
		}

		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("Browser Selected for testing " + browserType);
		System.out.println("Browser Driver path " + driverPath);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		return driver;

	}

	public static String getOSName() {

		String OSName = null;
		String name = System.getProperty("os.name").toLowerCase();
		String version = System.getProperty("os.version").toLowerCase();
		String architecture = System.getProperty("os.arch").toLowerCase();
		String datamodel = System.getProperty("sun.arch.data.model");

		logger.info("OS: " + name);
		logger.info("Version: " + version);
		logger.info("Architecture: " + architecture);
		logger.info("Data Model: " + datamodel);
		if ((name.indexOf("win") >= 0)) {
			OSName = "windows";
		} else if ((name.indexOf("mac") >= 0)) {
			OSName = "mac";
		} else if (name.indexOf("nix") >= 0 || name.indexOf("nux") >= 0 || name.indexOf("aix") > 0) {

			if (architecture.contains("32") || datamodel.contentEquals("32"))
				OSName = "linux32bit";
			else
				OSName = "linux64bit";
			logger.info("Linux Architecture: " + architecture);
			logger.info("Linux Data Model: " + datamodel);
		} else
			OSName = "other";
		return OSName;
	}

	public static String getPlatformSpecificDriverPath() {

		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		logger.info("Current relative path is: " + s);
		String os = getOSName();
		switch (os) {
		case "windows":
			s = s + "\\exefiles\\win\\chromedriver.exe";
			break;
		case "mac":
			s = s + "/exefiles/mac/chromedriver";
			break;
		case "linux32bit":
			s = s + "/exefiles/linux32/chromedriver";
			break;
		case "linux64bit":
			s = s + "/exefiles/linux64/chromedriver";
			break;
		default:
			s = s + "/exefiles/linux64/chromedriver";

		}
		logger.info("Current driver path is: " + s);
		return s;
	}

	public static void main(String[] arg) {
		System.out.println("Windows Chrome Path : " + getPlatformSpecificDriverPath());

	}

}
