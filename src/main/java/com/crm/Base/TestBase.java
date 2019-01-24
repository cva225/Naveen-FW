package com.crm.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver ;
	public static Properties  prop ;
	
	public TestBase() {
		super();
		try {
			prop = new Properties();
			FileInputStream fip = new FileInputStream("F:/selenium work space new/NaveenAutomationFW/src"
					+ "/main/java/com/crm/Config/config.properties");
			prop.load(fip);}
			
			catch (FileNotFoundException e) {
				e.printStackTrace();     }
				
		 catch (IOException e) {
		e.printStackTrace();
	    }
	}
	
	public static  void initialization() {
		String browserName = prop.getProperty("browserName");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:/CvaNewFramework/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
			
			else if (browserName.equalsIgnoreCase("firefox")) {
				
		System.setProperty("webdriver.gecko.driver", "F:/CvaNewFramework/Drivers/geckodriver.exe");
		
		driver = new FirefoxDriver();
			}
		
		driver. manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("Url"));
		
		
		}
		

	}


