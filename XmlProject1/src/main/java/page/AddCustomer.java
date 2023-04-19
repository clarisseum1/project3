package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCustomer extends BasePage {
	public AddCustomer(WebDriver driver) {
		this.driver = driver;

	}

	WebDriver driver;
	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']/div[3]/div[1]/div/div/div/div[1]/h5")
	WebElement ADD_CONTACT_ELEMENT;

	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id='cid']")
	WebElement CAMPANY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement COUNTRY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SAVE_ELEMENT;

	public void verfiyAddcontact(String Contact) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		wait.until(ExpectedConditions.visibilityOf(ADD_CONTACT_ELEMENT));
		Assert.assertEquals(ADD_CONTACT_ELEMENT.getText(), Contact, "page no found");
	}

	String insertName;

	public void insertFullName(String fullname) {
		insertName = fullname + generateRandomNumber(999);
		FULL_NAME_ELEMENT.sendKeys(insertName);
	}

	public void insertCampany(String campany) {
		selectDropDown(CAMPANY_ELEMENT, campany);
	}

	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys(generateRandomNumber(999) + email);
	}

	public void insertPhone(String phone) {
		PHONE_ELEMENT.sendKeys(generateRandomNumber(999) + phone);
	}

	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}

	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}

	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}

	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(generateRandomNumber(999) + zip);
	}

	public void insertCountry(String country) {
		selectDropDown(COUNTRY_ELEMENT, country);
	}

	public void clicSave() {
		SAVE_ELEMENT.click();
	}
	//tbody/tr[1]td[3]
		//tbody/tr[2]td[3]
		//tbody/tr[3]td[3]
		//tbody/tr[i]td[3]
	//tbody/tr[i]td[7/a[2] (delete button)
	
		String begin_xpath ="//tbody/tr[";
		String after_xpath ="]/td[3]";
		String after_xpath_delete="]td[7/a[2]";
		public void validateDeleteAndAddNameonListcustomer() {
			for(int i = 1; i <= 10; i=i+1) {
			driver.findElement(By.xpath("//tbody/tr["+ i +"]/td[3]"));
			String nameOnList=driver.findElement(By.xpath( begin_xpath + i + after_xpath)).getText();
			System.out.println(nameOnList);
			Assert.assertEquals(nameOnList,insertName,"name no found!" );
			if (nameOnList.contains(insertName)) {
				System.out.println("enter mame exist");
				driver.findElement(By.xpath(begin_xpath + i + after_xpath_delete ));
			break;	
			}
			
			}
			
		}

	}


