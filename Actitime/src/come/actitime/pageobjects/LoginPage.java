package come.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;


public class LoginPage {

	
	@FindBy(name="username")
	private WebElement unTxtBx;
	
	@FindBy(name="pwd")
	private WebElement pwdTxtBx;
	
	@FindBy(id="loginButton")
	private WebElement loginBtn;
	
	@FindBy(className="errormsg")       //storing error mesage in login page
	private WebElement invalidLoginMsg;
	
	
	
	public WebElement getInvalidLoginMsg() {                      //getter message is written to get webelement
		return invalidLoginMsg;
	}


	public void setInvalidLoginMsg(WebElement invalidLoginMsg) {
		this.invalidLoginMsg = invalidLoginMsg;
	}


	//constuctor
	public LoginPage(WebDriver driver){
	PageFactory.initElements(driver, this);
	
	}
	//reusable method
	
	
	public void login(String username, String password){
		
		unTxtBx.sendKeys(username);
		unTxtBx.sendKeys(password);
		loginBtn.click();
		
		

	}
	
public void verifyInvalidLoginMsg(){      // method is made here as it is displayed in login page
	
	String expMsg="username or password is invalid. Please try again.";
	String actMsg =invalidLoginMsg.getText();
	
	Assert.assertEquals(expMsg, actMsg);
	Reporter.log("invalid login Msg is verified", true);
}


}
