package com.contactsApp.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.contactsApp.utils.utilityClass;

public class BaseClass {
	
	// Global Variables
	public static WebDriver driver;
	public static Properties properties;
	
	// Constructor of Base Class
	public BaseClass() {
		try {
			properties = new Properties();
			FileInputStream input = new FileInputStream("E:\\e\\Study material\\NodeMysql\\Selenium-Java\\ContactsAppAutomation\\src\\main\\java\\com\\contactsApp\\config\\config.properties");
			properties.load(input);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialize() {
		String browserName = properties.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\e\\Study material\\NodeMysql\\Selenium-Java\\selenium jars\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(); 
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\e\\Study material\\NodeMysql\\Selenium-Java\\selenium jars\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(utilityClass.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(utilityClass.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		// Launch URL
		driver.get(properties.getProperty("url"));
	}

}
