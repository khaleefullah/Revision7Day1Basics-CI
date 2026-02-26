package base;

import core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import config.Config;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setup() {
		DriverFactory.initDriver();
		driver = DriverFactory.getDriver();
		driver.get(Config.getBaseUrl());

	}

	@AfterMethod
	public void teardown() {
		DriverFactory.quitDriver();
	}

}
