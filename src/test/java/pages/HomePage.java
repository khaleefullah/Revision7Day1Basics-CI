package pages;

import base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	private By winterToursMenu = By.linkText("Alaska Winter Tours");

	public WinterToursPage openWinterToursPage() {
		waitAndClick(winterToursMenu);
		return new WinterToursPage(driver);
	}
}
