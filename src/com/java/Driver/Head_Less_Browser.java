package com.java.Driver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Head_Less_Browser
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "F://Selenium//Drivers//chromedriver.exe");
//		
//		ChromeOptions chrome_options = new ChromeOptions();
//		chrome_options.addArguments("window-size=1400,800");
//		chrome_options.addArguments("headless");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/");
		System.out.println("Login Page Title of the FreeCRM Website: - "+driver.getTitle());
		
		driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("mallanagoud6031@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("freeCRM8904368678");
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();

		System.out.println("Home Page Title of the FreeCRM Website: - "+driver.getTitle());
	}
}
