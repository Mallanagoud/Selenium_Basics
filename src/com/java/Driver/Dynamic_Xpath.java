package com.java.Driver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_Xpath 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "F://Selenium//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://www.ebay.com/");
		
		//driver.findElement(By.xpath("//*[@class='gh-tb ui-autocomplete-input']")).sendKeys("Java");
		driver.findElement(By.xpath("//a[@href='https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F']")).click();
		driver.findElement(By.xpath("//img[@src='https://ir.ebaystatic.com/rs/v/oydxuhs1au0gpa0st223lfhslmt.png?e']")).click();
		
		   
	}
}