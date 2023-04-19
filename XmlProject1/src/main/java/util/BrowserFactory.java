package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
	static WebDriver driver;
	static String browser;
	static String url;

	public static void readconfig() {
		try {
			InputStream st = new FileInputStream("src\\main\\java\\confing\\confing.Properties");
			Properties pro = new Properties();
			pro.load(st);
			browser = pro.getProperty("browser");
			url = pro.getProperty("url");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver init() {
		readconfig();
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver(co);
		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions co = new FirefoxOptions();
			co.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(url);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;

	}

}
