package come.actitime.scripts;

import org.testng.annotations.Test;

import come.actitime.genric.BaseLib;
import come.actitime.genric.ExcelUtils;
import come.actitime.pageobjects.ActiveProjAndCustPage;
import come.actitime.pageobjects.CreateNewCustPage;
import come.actitime.pageobjects.EditCustInfoPage;
import come.actitime.pageobjects.EnterTimeTrackPage;
import come.actitime.pageobjects.LoginPage;
import come.actitime.pageobjects.OpenTasksPage;

public class TaskTest extends BaseLib {

	@Test
	public void createCustomerTest(){
		LoginPage lp=new LoginPage(driver);
		String username=ExcelUtils.readData("sheet1", 3, 1);
		String password=ExcelUtils.readData("sheet1", 3, 2);
		lp.login(username, password);
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);    // in order to click on tasks , from enter time track we can go to task page so crae time trck object
		
		
	ettp.clickOnTasks();
	OpenTasksPage otp=new OpenTasksPage(driver);
	otp.clickOnProjAndCustLink();
	
	ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
	apcp.clickOnCreateNewCustBtn();
	
	String customerName=ExcelUtils.readData("sheet1", 3, 3);
	
	CreateNewCustPage cncp=new CreateNewCustPage(driver);     //to create new customer maing object here 
	cncp.createCustomer(customerName);
	
	apcp.verifyCreateCustMsg(customerName);
	

		
	}
	
	@Test(dependsOnMethods={"createCustomerTest"})
	public void deleteCustomerTest(){

	
	LoginPage lp=new LoginPage(driver);
	String username=ExcelUtils.readData("sheet1", 4, 1);
	String password=ExcelUtils.readData("sheet1", 4, 2);
	lp.login(username, password);
	EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);    // in order to click on tasks , from enter time track we can go to task page so crae time trck object
	
	
ettp.clickOnTasks();
OpenTasksPage otp=new OpenTasksPage(driver);
otp.clickOnProjAndCustLink();

	
ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
String customerName=ExcelUtils.readData("sheet1", 4, 3);

apcp.selectCustomer(customerName);
EditCustInfoPage ecip=new EditCustInfoPage(driver);
ecip.deleteCustomer();
apcp.verifyDeleteCustMsg();
apcp.clickOnLogoutLink();
	
	
	
	
	
	
	
	
}
	
}
