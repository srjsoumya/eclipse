package maven_selenium_project;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CheckBrokenLink {
	public static WebDriver driver;
	static int cnt = 1;

	public static void checkConnection(String url) {
		try {
			URL link = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) link.openConnection();
			conn.setConnectTimeout(3000);
			conn.connect();
			if (conn.getResponseCode() == 200)
				System.out.println(cnt++ + " " + url + "== " + conn.getResponseMessage());
			if (conn.getResponseCode() == 404)
				System.out.println(cnt++ + " " + url + "== " + conn.getResponseMessage());
		} catch (Exception e) {
			System.out.println("Empty Link");

		}
	}

	@Test
	public void checkBrokenLinkTest() {
		System.setProperty("webdriver.gecko.driver", "/home/soumyavaio/selenium/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
		List<WebElement> lst = driver.findElements(By.tagName("a"));
		System.out.println("Total number of link is " + lst.size());

		for (int i = 0; i < lst.size(); i++) {
			WebElement wb = lst.get(i);
			String url = wb.getAttribute("href");
			checkConnection(url);
		}
		driver.close();

	}

}
