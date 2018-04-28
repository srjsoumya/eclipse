package testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericlibrary.GenericLib;
import objectrepository.Vanilla;

public class VanillaMaster {
	public static WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.gecko.driver", "resource/geckodriver");
		Reporter.log("Open the Browser");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void openlink() {
		Reporter.log("open the link in the browser");
		driver.get("https://vanilla-masker.github.io/vanilla-masker/demo.html");
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

	@Test(dataProvider = "phone")
	public void phone(String number) {
		Reporter.log("Enter phone number to phone text field");
		GenericLib lib = PageFactory.initElements(driver, GenericLib.class);
		String expResult = lib.phoneNumber(number);
		Vanilla van = PageFactory.initElements(driver, Vanilla.class);
		van.editPhone(number);
		Reporter.log("Retrive the data from text field");
		String actResult = van.getPhone();
		Assert.assertEquals(expResult, actResult);
	}

	@DataProvider
	public Object[] phone() throws EncryptedDocumentException, InvalidFormatException, IOException {
		GenericLib lib = PageFactory.initElements(driver, GenericLib.class);
		Object[] objArr = new Object[4];
		for (int i = 0; i < 4; i++)
			objArr[i] = lib.getExcelData("phone", i, 0);
		return objArr;
	}

	@Test(dataProvider = "onlynumber")
	public void onlynumber(String cent) {
		Reporter.log("Enter string to onlynumber text field");
		GenericLib lib = PageFactory.initElements(driver, GenericLib.class);
		String expResult = lib.onlyNumber(cent);
		Vanilla van = PageFactory.initElements(driver, Vanilla.class);
		van.editNumber(cent);
		Reporter.log("Retrive the data from text field");
		String actResult = van.getNumber();
		Assert.assertEquals(expResult, actResult);
	}

	@DataProvider
	public Object[] onlynumber() throws EncryptedDocumentException, InvalidFormatException, IOException {
		GenericLib lib = PageFactory.initElements(driver, GenericLib.class);
		Object[] objArr = new Object[5];
		for (int i = 0; i < 5; i++)
			objArr[i] = lib.getExcelData("onlynumber", i, 0);
		return objArr;
	}

	@Test(dataProvider = "zerocent")
	public void zerocent(String zero) {
		Reporter.log("Enter string to zerocent text field");
		GenericLib lib = PageFactory.initElements(driver, GenericLib.class);
		String expResult = lib.zerocent(zero);
		Vanilla van = PageFactory.initElements(driver, Vanilla.class);
		van.editCent(zero);
		Reporter.log("Retrive the data from text field");
		String actResult = van.getCent();
		Assert.assertEquals(expResult, actResult);
	}

	@DataProvider
	public Object[] zerocent() throws EncryptedDocumentException, InvalidFormatException, IOException {
		GenericLib lib = PageFactory.initElements(driver, GenericLib.class);
		Object[] objArr = new Object[8];
		for (int i = 0; i < 8; i++)
			objArr[i] = lib.getExcelData("zerocent", i, 0);
		return objArr;
	}

}
