package rough;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingBrokenLinks {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.alaskatrips.com");

		// Collect all the anchor tags
		List<WebElement> links = driver.findElements(By.tagName("a"));

		// Extract the url
		for (WebElement link : links) {
			@Nullable
			String url = link.getAttribute("href");

			if (!url.isBlank() && !url.isEmpty() && url != null) {

				if (url.startsWith("http")) {

					try {
						HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();
						conn.connect();
						int responseCode = conn.getResponseCode();

						if (responseCode >= 400) {
							System.out.println(url + " -> is broken");
						} else {
							System.out.println(url + " -> is valid");
						}
						conn.disconnect();
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		driver.quit();
	}

}
