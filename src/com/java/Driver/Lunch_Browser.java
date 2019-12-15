package com.java.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lunch_Browser 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "F://Selenium//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//		System.setProperty("webdriver.gecko.driver", "F://Selenium//Drivers//geckodriver.exe");
		//		WebDriver driver = new FirefoxDriver();       
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com");

		//String url = driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		String title = driver.getTitle();
		System.out.println(title);

		driver.close();
	}

}
