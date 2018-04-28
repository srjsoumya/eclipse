package maven_selenium_project;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class IrctcTest {
	public static WebDriver driver;
	@Test
	public void newTab() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver","/home/soumyavaio/selenium/geckodriver");
		driver=new FirefoxDriver();
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		WebElement tourism=driver.findElement(By.linkText("Tourism"));
		act.moveToElement(tourism).perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Cab")).click();
		
		Set <String> winId=driver.getWindowHandles();
		System.out.println(winId.size());
		
		
	}

}
