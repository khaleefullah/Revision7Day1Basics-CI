package rough;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingAllLinks {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.alaskatrips.com");
		
		// Collect all the anchor tags
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for (WebElement link : links) {
			@Nullable
			String url = link.getAttribute("href");
			System.out.println(url);
		}
		
		driver.quit();
	}

}
