package come.actitime.genric;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib {

	
	public WebDriver driver;
	
	@BeforeMethod

//	@Parameters("browser")                      //we can run scripts ,through suit file and class level(LoginTest)

//	public void setUp(String browserName){     //it is difficult to debug through suit file , you should go to html emailable report
	
	public void setUp(){
		String browserName=GetPropertyValue.getValue("browser");   //taking vlaue from congif.proeprties and if we have to debug we have to debug thriegh class level
		if(browserName.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
			Reporter.log("firefox launched", true);
			
		}
		
		
		else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome", ".\\exefiles\\chromedriver.exe");
			driver=new ChromeDriver();
			Reporter.log("chrome launched", true);
			
		}
		
	driver.manage().window().maximize();
	WaitStatementLib.implicitWaitForSeconds(driver, 20);
//	driver.get(GetPropertyValue.getValue("testURL"));
	}
	
	@AfterMethod
	
	public void tearDown(ITestResult result){                // question?: abstraction,  
		
		if(result.isSuccess()){
			Reporter.log("script passed", true);
		}
		
		else{
			
			Reporter.log("script failed", true);
			String fileName=result.getMethod().getMethodName();
			ScreenshotLib sLib=new ScreenshotLib();
			sLib.takeScreenshot(driver, fileName);
			Reporter.log("screenshot has been taken", true);
		}
		
		driver.close();
		Reporter.log("browser is closed", true);
		
		
		
		
	}
	
}
