package page;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.messages.internal.com.google.protobuf.ByteString.Output;

public class BasePage {
	public static WebDriver driver;
	 public static void init() {
		 System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		 driver= new ChromeDriver();
		
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 driver.manage().deleteAllCookies();
		 driver.get("https://techfios.com/billing/?ng=login/");
	 }
	 public void takeScreenshot( WebDriver driver) {
		TakesScreenshot ts= (TakesScreenshot)driver;
		try {
			SimpleDateFormat format= new SimpleDateFormat("MMddyy_HHmmss");
			Date date=new Date();
			String label= format.format(date);
		
		FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")+ "/screenshot/" + label+ ".png"));
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}	
		}
		public  int generateRandomNumber( int boundry) {
			Random random= new Random();
	int generateNum=random.nextInt(boundry);
	return generateNum;
			
			
		}
		
		}
	


