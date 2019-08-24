package come.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;



public class EnterTimeTrackPage extends BasePage{             //to call constrctor present inside base page as we can not create object of basepage so we are calling through inheritance

	/*public EnterTimeTrackPage(){
		
	}
	*/
	
	public EnterTimeTrackPage(WebDriver driver){
		super(driver);
		
		
	}
	
	public void verifyHomePageTitle(WebDriver driver){
		String expTitle="actiTime - Enter Time-Track";  //open task verify with inspcet open firepath<documnrt<head<titile<
	
String actTitle	=driver.getTitle();

Assert.assertEquals(actTitle, expTitle);

Reporter.log("home page is varifies", true);






	
	}
	
	
	
}
