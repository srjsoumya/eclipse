package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Vanilla {
	/* WebElement for zeroCents Text Box */
	@FindBy(id = "zeroCents")
	WebElement cent;
	
	/* WebElement for Phone Text Box */
	@FindBy(id = "phone")
	WebElement ph;
	
	/* WebElement for only numbers Text Box */
	@FindBy(id = "numbers")
	WebElement only;
	
	/**
	 * Method to give data to phone text field
	 * @param phone take the phone no as argument
	 */
	public void editPhone(String phone)
	{
		 ph.sendKeys(phone);
		
	}
	/**
	 * Method to give data to zerocent text field
	 * @param zero take the zerocent no as argument
	 */
	public void editCent(String zero)
	{
		 cent.sendKeys(zero);
	}
	/**
	 *Method to give data to onlynumber text field
	 * @param numb take the onlynumber no as argument
	 */
	public void editNumber(String numb)
	{
		 only.sendKeys(numb); 
	}
	
	/**
	 * Method to get data of Phone Text field
	 * @return String value present in phone text Field
	 */
	public String getPhone()
	{
		return ph.getAttribute("value");
		
	}
	/**
	 * Method to get data of ZeroCent Text field
	 * @return String value present in ZeroCent text Field
	 */
	public String getCent()
	{
		return cent.getAttribute("value");
	}
	/**
	 * Method to get data of OnlyNumber Text field
	 * @return String value present in OnlyNumber text Field
	 */
	public String getNumber()
	{
		return only.getAttribute("value"); 
	}
	

}
