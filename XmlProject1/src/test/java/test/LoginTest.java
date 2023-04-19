package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	WebDriver driver;
	@Test
	@Parameters({ "username","password","dashboardText"})
	public void validUserBeAbleToLogin(String username, String password,String dashboardText ) throws InterruptedException {
		driver =BrowserFactory.init();
		LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUsername(username);
		loginPage.insertpassword(password);
		loginPage.clicksignin();
		
		DashboardPage dashboardPage= PageFactory.initElements(driver,DashboardPage.class);
		dashboardPage.valifyDashboard(dashboardText);
		
		dashboardPage.clickCustomer();
		dashboardPage.clicKAddCustomer();
		
		
	}
}
