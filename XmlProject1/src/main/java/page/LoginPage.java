package page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;



public class LoginPage {
	public LoginPage (WebDriver driver) {
		this.driver=driver;
	}
	
	WebDriver driver;
@FindBy(how=How.XPATH,using="//input[@name='username']")WebElement USER_NAME_ELEMENT;
@FindBy(how=How.XPATH,using="//*[@id=\"password\"]")WebElement PASSWORD_ELEMENT;
@FindBy(how=How.CSS,using="button[name='login'")WebElement SIGNIN_BUTTON_ELEMENT;

public void insertUsername( String username) {
	USER_NAME_ELEMENT.sendKeys( username);
}
public void insertpassword(String password) {
	PASSWORD_ELEMENT.sendKeys(password);
}
public void clicksignin() {
	SIGNIN_BUTTON_ELEMENT.click();
}

}
