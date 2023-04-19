package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BankCashPage {
	WebDriver driver;
	
public BankCashPage(WebDriver driver) {
	this.driver=driver;
}
	
	 @FindBy(how=How.XPATH,using="//input[@id='account']")WebElement accountTitle_element;
		
	 @FindBy(how=How.XPATH,using="//input[@id='description']")WebElement description_element;
	
	 @FindBy(how=How.XPATH,using="//input[@id='balance']")WebElement initialBalance_element;
	 @FindBy(how=How.XPATH,using="//input[@id='account_number']")WebElement accountNumber_element;
	
	 @FindBy(how=How.XPATH,using="//input[@id='contact_person']")WebElement contactPerson_element;
	@FindBy(how=How.XPATH,using="//input[@id='contact_phone']")WebElement Phone_element;
	 @FindBy(how=How.XPATH,using="//input[@id='ib_url']")WebElement internetBankURL_element;
		
	 @FindBy(how=How.XPATH,using="//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/button")WebElement submit_element;
	

	public void insertAccountTitle(String accountTitle ) {
		 accountTitle_element.sendKeys(accountTitle);
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void insertDescription(String description) {
		description_element.sendKeys(description);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	public void insertInitialBalance(String initialBalance) {
		initialBalance_element.sendKeys(initialBalance);	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	public void insertAccountNumber(String accountNumber) {
		 accountNumber_element.sendKeys(accountNumber);
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	public void insertContactPerson(String ContactPerson) {
		contactPerson_element.sendKeys(ContactPerson);
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	public void insertPhone(String phone) {
		 Phone_element.sendKeys( phone);
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertInternetBankURL(String internetBank) {
		 internetBankURL_element.sendKeys(internetBank);
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	public void clickSubmit() {
		submit_element.click();
	}

}
