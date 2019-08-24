package come.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustInfoPage {

	@FindBy(xpath="//input[@value='Delete This Customer']")
	private WebElement delThisCustBtn;
	
	@FindBy(id="deleteButton")
	private WebElement delCustConfirmBtn;
	
	public EditCustInfoPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	
	public void deleteCustomer(){
		delThisCustBtn.click();
		delCustConfirmBtn.click();
	}
	
	
	
}
