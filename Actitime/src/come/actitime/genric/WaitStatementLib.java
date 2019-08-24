package come.actitime.genric;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementLib {

	
	public static  void isSleep(int sec){
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
/*****************************************************************************************/	
	
	public static void implicitWaitForSeconds(WebDriver driver, int sec)
	{
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		
		
		
	}
	
/****************************************************************************************/	
	
	
	public static void implicitWaitForMinutes(WebDriver driver, int mins){
		
		driver.manage().timeouts().implicitlyWait(mins, TimeUnit.MINUTES);
		
	}
	
/*********************************************************************************************/
	
	
	
	
public static void explicitWaitForVisibilty(WebDriver driver, int sec, WebElement ele)	{
	WebDriverWait wait=new WebDriverWait(driver, sec);
			wait.until(ExpectedConditions.visibilityOf(ele));
}
	
	/**************************************************************************************************/
	





public static void explicitWaitForClickable(WebDriver driver, int sec, WebElement ele)	{
	WebDriverWait wait=new WebDriverWait(driver, sec);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
}





















}
