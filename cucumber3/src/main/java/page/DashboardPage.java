package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {
WebDriver driver;
public DashboardPage() {
	this.driver=driver;
}
@FindBy(how=How.XPATH,using="//*[@id='side-menu']/li[10]/a/span[1]")WebElement bankCash_element;
@FindBy(how=How.XPATH,using="//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a")WebElement newAccount_element;

public void clickBackCah() {
	bankCash_element.click();

}
public void clickNewAccount() {
	newAccount_element.click();
}
}