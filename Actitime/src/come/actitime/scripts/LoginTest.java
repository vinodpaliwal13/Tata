package come.actitime.scripts;

import org.testng.annotations.Test;

import come.actitime.genric.BaseLib;
import come.actitime.genric.ExcelUtils;
import come.actitime.genric.WaitStatementLib;
import come.actitime.pageobjects.EnterTimeTrackPage;
import come.actitime.pageobjects.LoginPage;

public class LoginTest extends BaseLib {

	@Test()
	public void ValidLoginTest(){
		
		LoginPage lp=new LoginPage(driver);    //driver  is coming from baslib as driver is public there
		
	String username=ExcelUtils.readData("sheet1", 1, 1);
	String password=ExcelUtils.readData("sheet1", 1, 2);
	
		
		lp.login(username, password);
		
WaitStatementLib.isSleep(2);		//so that chrome page can load its elements
		EnterTimeTrackPage ett=new EnterTimeTrackPage(driver);  //initialily here we were suins default constrctrwe are nto intialzing any webelement so we not default constrctor if you want to initlaise any webelement then call parameter constrct as we have to varify only title not required any paaramtr constrctr
		
		ett.verifyHomePageTitle(driver);
		ett.verifyHomePageLogo();
		
		
	}
	
	
	@Test
	public void invalidLoginTest(){
		LoginPage lp=new LoginPage(driver);
		String username=ExcelUtils.readData("sheet1", 2, 1);
		String password=ExcelUtils.readData("sheet1", 2, 2);
        lp.login(username, password);
        WaitStatementLib.explicitWaitForVisibilty(driver, 10, lp.getInvalidLoginMsg());   //getting "ele" here as a webelement and getting it form getter method from login page
        lp.verifyInvalidLoginMsg();
	}
	
	
	
	
	
	
}
