package core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.edge.*;

import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public static WebDriver createDriver() {

		String browser = Config.getBrowser();
		String executionMode = Config.getExecutionMode();
		boolean headless = Config.isHeadless();

		switch (browser) {
		
		case "chrome":

			ChromeOptions chromeOptions = new ChromeOptions();

			if (headless) {
				chromeOptions.addArguments("--headless=new");
			}

			if (executionMode.equals("remote")) {
				return createRemoteDriver(chromeOptions);
			}

			WebDriverManager.chromedriver().setup();
			return new ChromeDriver(chromeOptions);

		case "firefox":

			FirefoxOptions firefoxOptions = new FirefoxOptions();

			if (headless) {
				firefoxOptions.addArguments("--headless=new");
			}

			if (executionMode.equals("remote")) {
				return createRemoteDriver(firefoxOptions);
			}

			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver(firefoxOptions);

		case "edge":

			EdgeOptions edgeOptions = new EdgeOptions();

			if (headless) {
				edgeOptions.addArguments("--headless=new");
			}

			if (executionMode.equals("remote")) {
				return createRemoteDriver(edgeOptions);
			}

			WebDriverManager.edgedriver().setup();
			return new EdgeDriver(edgeOptions);

		default:
			throw new IllegalArgumentException("Invalid browser passed : " + browser);
		}

	}

	public static WebDriver createRemoteDriver(Capabilities options) {

		try {
			return new RemoteWebDriver(new URL(Config.getGridUrl()), options);
		} catch (MalformedURLException e) {
			throw new RuntimeException("Remote driver is not created");
		}
	}
}
