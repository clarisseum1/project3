package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomer;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {

WebDriver driver;
@Test
@Parameters({ "username","password","dashboardText","contact","fullname","campany","email","phone","address","city", "state","zip","country"})
public void validUserBeAbleToCreateCustomer(String username, String password,String dashboardText,String contact,String fullname,String campany,String email,String phone,String address,String city,String state,String zip,String country ) throws InterruptedException {
	driver =BrowserFactory.init();
	LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
	loginPage.insertUsername(username);
	loginPage.insertpassword(password);
	loginPage.clicksignin();
	
	DashboardPage dashboardPage= PageFactory.initElements(driver,DashboardPage.class);
	dashboardPage.valifyDashboard(dashboardText);
	
	dashboardPage.clickCustomer();
	dashboardPage.clicKAddCustomer();
	dashboardPage.clickListCustomer();
	AddCustomer addCustomer = PageFactory.initElements(driver,AddCustomer.class );
	addCustomer.verfiyAddcontact(contact);
	 addCustomer.insertFullName(fullname); 
	 addCustomer.insertCampany(campany);
	 addCustomer.insertEmail(email);
	 addCustomer.insertPhone(phone);
	 addCustomer.insertAddress(address);
	 addCustomer.insertCity(city);
	 addCustomer.insertState(state);
	 addCustomer.insertZip(zip);
	 addCustomer.insertCountry(country);
	 addCustomer.clicSave();
	 addCustomer.validateDeleteAndAddNameonListcustomer();
}
}
