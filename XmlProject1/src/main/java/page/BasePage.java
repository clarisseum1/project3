package page;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public int generateRandomNumber(int boundry) {
		Random rn= new Random();
		int generateNum =rn.nextInt(boundry);
		return generateNum;
	
	}
	public void selectDropDown(WebElement element, String visible){
		Select sel= new Select(element);
		sel.selectByVisibleText(visible);
	}


	

}
