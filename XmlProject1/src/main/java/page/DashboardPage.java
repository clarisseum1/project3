package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashboardPage {
	public DashboardPage(WebDriver driver) {
		this.driver = driver;

	}

	WebDriver driver;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
	WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a/span[1]")
	WebElement CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")
	WebElement ADD_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/ul/li[2]/a")
	WebElement LIST_CUSTOMER__ELEMENT;

	public void valifyDashboard(String dashboardText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		wait.until(ExpectedConditions.visibilityOf(DASHBOARD_HEADER_ELEMENT));
		Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), dashboardText, " dashboard page no found");
	
	}

	public void clickCustomer() {
		CUSTOMER_ELEMENT.click();
	}

	public void clicKAddCustomer() {
		ADD_CUSTOMER_ELEMENT.click();
	}

	public void clickListCustomer() {
		LIST_CUSTOMER__ELEMENT.click();
	}
}
