package come.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class BasePage {
	
	//logo is common so we are storing here
	

@FindBy(xpath="//img[contains(@src, 'default-logo.png')]")
		private WebElement logo;

@FindBy(xpath="//div[text()='tasks']")
private WebElement tasks;

@FindBy(id="logoutLink")
private WebElement logoutLink;     //in order to logout as this is common webelemnt so we are storing here 






		
		public BasePage(WebDriver driver){
			
			PageFactory.initElements(driver, this);
		}
		
		public void verifyHomePageLogo(){
			
			Assert.assertTrue(logo.isDisplayed());
			Reporter.log("home page logo is verified ", true);
		}
		
		
		public void clickOnTasks(){
			tasks.click();
		}
		
		
		
		public void clickOnLogoutLink(){    
			logoutLink.click();
		}
		
		
		
		
		

}
