package com.java.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators_Selenium {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "F://Selenium//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.surveymonkey.com/");

		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		//Locator -- > 1  LinkText
		driver.findElement(By.linkText("SIGN UP")).click();;

		//Locator -- > 2 ID
		driver.findElement(By.id("username")).sendKeys("Mallanagoud");

		//Locator -- > 3 Name
		driver.findElement(By.name("password")).sendKeys("Gowda");

		//Locator -- > 4 Xpath
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Gowda1343@gmail.com");

		//Locator -- > 5 CSS Locators 
		driver.findElement(By.cssSelector("#first_name")).sendKeys("Mallana");

		//Locator -- > 6 CSS Locators 
		driver.findElement(By.name("last_name")).sendKeys("Gowda");
		
		driver.findElement(By.name("submit")).click();
		
		driver.quit();
	}

}
