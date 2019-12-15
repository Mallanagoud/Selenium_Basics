package com.java.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Read_Propertyfile
{
	static WebDriver driver;
	public static void main(String[] args) throws IOException 
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("F:\\Selenium\\Selenium_Basics\\src\\Config.properties");
		prop.load(file);

		String browsername = prop.getProperty("browser");

		System.out.println(browsername);
		if (browsername.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "F://Selenium//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome Browser Opened");
		}
		else if (browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "F://Selenium//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Firefox Browser opered");
		}
		else
		{
			System.out.println("No Browser Found");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.ebay.com/");
		driver.quit();
	}

}
