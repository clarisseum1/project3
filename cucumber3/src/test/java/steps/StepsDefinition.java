package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import page.BankCashPage;
import page.BasePage;
import page.DashboardPage;
import page.LoginPage;

public class StepsDefinition extends BasePage {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	BankCashPage bankCashPage;

	@Before
	public void before() {
		init();

		loginPage = PageFactory.initElements(driver, LoginPage.class);
		dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		bankCashPage = PageFactory.initElements(driver, BankCashPage.class);
	}

	@Given("^User is on the techfios login page$")
	public void user_is_on_the_techfios_login_page() {
		driver.get("https://techfios.com/billing/?ng=login/");
	}

	@When("^User enters the \"([^\"]*)\" in the \"([^\"]*)\" field$")
	public void user_enters_the_in_the_field(String login, String field) {
		if (field.equalsIgnoreCase("username"))
			loginPage.insertusername(login);
		else if (field.equalsIgnoreCase("password")) {
			loginPage.insertpassword(login);
		} else {
			System.out.println("incorrect login");
		}
	}

	@And("^User clicks on \"([^\"]*)\"$")
	public void User_clicks_on(String button) {
		if (button.equalsIgnoreCase("login")) {
			loginPage.clicksignin();
		} else if (button.equalsIgnoreCase("bankCash")) {
			dashboardPage.clickBackCah();
		} else if (button.equalsIgnoreCase("newAccount")) {
			dashboardPage.clickNewAccount();
		} else if (button.equalsIgnoreCase("submit")) {
			bankCashPage.clickSubmit();
		} else {
			System.out.println("incorrect");
		}
	}

	@Then("^User should land on Dashboard page$")
	public void user_should_land_on_dashoard_page() {
		String actualTitle = loginPage.dashbooard();
		String expectedTitle = "Dashboard- iBilling";
		Assert.assertEquals("page no found!", expectedTitle, actualTitle);
		takeScreenshot(driver);
	}

	@And("User enters \"([^\"]*)\" in the \"([^\"]*)\" field in accounts page$")
	public void user_enters_in_the_field_in_accounts_page(String accountCreated, String field) {
		switch (field) {
		case "accountTitle":
			bankCashPage.insertAccountTitle(accountCreated + generateRandomNumber(999));
			break;
		case "description":
			bankCashPage.insertDescription(accountCreated + generateRandomNumber(999));
			break;
		case "initialBalance":
			bankCashPage.insertInitialBalance(accountCreated + generateRandomNumber(999));
			break;
		case "accountNumber":
			bankCashPage.insertAccountNumber(accountCreated + generateRandomNumber(999));
			break;
		case "contactPerson":
			bankCashPage.insertContactPerson(accountCreated + generateRandomNumber(999));
			break;
		case "Phone":
			bankCashPage.insertPhone(accountCreated + generateRandomNumber(999));
			break;
		case "internetBankingURL":
			bankCashPage.insertInternetBankURL(accountCreated);
			break;
		
		default:
			System.out.println("incorrect account data:"+accountCreated);
		}	
	}
		@Then("^User should be able to validate account created successfully$")
		public void use_should_be_able_to_validate_account_created_successfully() {
			
		}
	

	@After
	public static void tearDown() {

	}

}
