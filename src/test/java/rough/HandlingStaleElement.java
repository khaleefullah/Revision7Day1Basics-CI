package rough;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingStaleElement {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.alaskatrips.com");
		/*
		 * // Find the element WebElement winterToursMenu =
		 * driver.findElement(By.linkText("Alaska Winter Tours")); // Refresh
		 * driver.navigate().refresh(); // Try to perform click (This click actions
		 * triggers org.openqa.selenium.StaleElementReferenceException)
		 * winterToursMenu.click(); Thread.sleep(2000); driver.quit();
		 */
		int maxTry = 0;
		while(maxTry<3) {
			try {
				WebElement element = driver.findElement(By.linkText("Alaska Winter Tours"));
				Thread.sleep(1000);
				//driver.navigate().refresh();
				Thread.sleep(1000);
				element.click();
				break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
				maxTry++;
				System.out.println("it wont come here");
			}
			
		} 
		driver.quit();
	}

}
