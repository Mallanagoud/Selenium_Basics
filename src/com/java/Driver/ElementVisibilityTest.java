package com.java.Driver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "F://Selenium//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("https://register.freecrm.com/register/");

		boolean b1 = driver.findElement(By.name("submitButton")).isDisplayed();
		System.out.println(b1);
		boolean b2 = driver.findElement(By.name("submitButton")).isEnabled();
		System.out.println(b2);

		driver.findElement(By.name("agreeTerms")).click();
		boolean b3 = driver.findElement(By.name("submitButton")).isEnabled();
		System.out.println(b3);

		boolean b4 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(b4);
		
		driver.findElement(By.name("agreeTerms")).click();
		boolean b5 = driver.findElement(By.name("submitButton")).isEnabled();
		System.out.println(b5);
	}
}
