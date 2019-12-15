package com.java.Driver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pop_Up 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "F://Selenium//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("http://www.popuptest.com/goodpopups.html");
		
		driver.findElement(By.linkText("Good PopUp #3")).click();
		
		Set<String> handler =driver.getWindowHandles();
		
		Iterator<String> iterator = handler.iterator();
		
		String parentWindow = iterator.next();
		System.out.println("Parent Window ID : - " +parentWindow);
		
		String childWindow = iterator.next();
		System.out.println("Child Window ID : - " +childWindow);
		
		driver.switchTo().window(childWindow);
		
		driver.quit();
		
		System.out.println("Child Window title : - "+driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWindow);
		System.out.println("Parent Window Title :- "+driver.getTitle());
		
		driver.quit();
 		
	}

}
