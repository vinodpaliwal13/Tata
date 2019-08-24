package come.actitime.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import come.actitime.genric.WaitStatementLib;

public class ActiveProjAndCustPage extends BasePage{               //extends as this is common 

	@FindBy(css="input[value='Create New Customer']")
	private WebElement createNewCustBtn;
	
	@FindBy(className="successmsg")     //verifying that customer  has been added  ,so storing here as it is very dynamic
	private WebElement successMsg;   //common message  already stored for delete and create we can use the same mesage 
	
	
	@FindBy(name="selectedCustomer")       // to delete exit customer 
	private WebElement custDropdown;
	
	@FindBy(name="//input[contains(@value, 'show')]")  //to click on show button
	private WebElement showBtn;
	
	@FindBy(xpath="//td[contains(@id, 'customerNameCell')]//a[contains(@href, 'customer)]")  //to click on show button
	private List<WebElement> customer;  // can also use weblemnets and webelment , giving only on element
	
	
	public ActiveProjAndCustPage(WebDriver driver){
		super(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCreateNewCustBtn(){
		
		createNewCustBtn.click();
		
	}
	
	
	public void verifyCreateCustMsg(String customerName){
		Assert.assertTrue(successMsg.isDisplayed());
		String createCustMsg=successMsg.getText();   ///to verify the customer name whether it is craeting same name or not 
		
		
		Assert.assertTrue(createCustMsg.contains(customerName));    // in assert contains reurn type is boolean
		Reporter.log(createCustMsg, true);
		
	}
	
	
	
	
	public void selectCustomer(String customerName){
		Select sel =new Select(custDropdown);
		sel.selectByVisibleText(customerName);
		showBtn.click();
		
		WaitStatementLib.isSleep(1);
		
int allCustomer=customer.size();
System.out.println("total customer displayed"+allCustomer);
		for(int i=0; i<allCustomer; i++){
			if(customer.get(i).getText().equals(customerName)){
				customer.get(i).click();
			}
		}
	}
	
	
	public void verifyDeleteCustMsg() {
		String expMsg="customer has been succesfully deleted.";
		String actMsg=successMsg.getText();
		Assert.assertEquals(actMsg, expMsg);
		Reporter.log("delete msg is verified");
		
	}
	
	
	
}
