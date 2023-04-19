package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;

public class LoginPage {
public 	LoginPage(WebDriver driver) {
	this.driver=driver;
}
WebDriver driver;
 @FindBy(how=How.XPATH,using="//*[@id=\"username\"]")WebElement username_element;
 @FindBy(how=How.XPATH,using="//*[@id=\"password\"]")WebElement password_element;
 @FindBy(how=How.XPATH,using="/html/body/div/div/div/form/div[3]/button")WebElement signin_element;
 

 public void insertusername(String username) {
	 
	 username_element.sendKeys(username);
try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
 
 }
 public void insertpassword(String password) {
	 password_element.sendKeys(password);
 try {
	Thread.sleep(3000);
} catch (InterruptedException e) {
	
	e.printStackTrace();
}
 }
 public void clicksignin() {
	 signin_element.click();
	 try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}

	}
 public String dashbooard() {
	return driver.getTitle();
	 
	 
	
	 
 }
 }
