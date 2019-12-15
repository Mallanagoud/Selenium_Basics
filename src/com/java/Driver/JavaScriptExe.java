package com.java.Driver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExe 
{
	public static void main(String[] args) throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "F://Selenium//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/");

		driver.findElement(By.name("username")).sendKeys("Mallana");
		driver.findElement(By.name("password")).sendKeys("Mallanagoud");


		WebElement loginbtn = driver.findElement(By.xpath("//input[@type ='submit']"));

		Highlight(loginbtn, driver);
		drawborder(loginbtn, driver);
		//Take Screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("F:\\Selenium\\Selenium_Basics\\Screenshots\\FailedLogin.png"));
		//         genetareAlert(driver, "Error with Login Button");
		//         
		//         Alert alert = driver.switchTo().alert();
		//         System.out.println(alert.getText());
		//         alert.accept();
		//Find element By JS
		clickElementbyJS(loginbtn, driver);
		//Refresh Browser By JS
		refreshpage(driver);
		//Get Title By JS
		System.out.println(gettitle(driver)); 
		//Inner Text By JS
		//System.out.println(innertext(driver)); 
		scrollpage(driver);
	}
	//Heighlight The Element
	public static void Highlight(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String bgColour = element.getCssValue("backgroundColor");
		for (int i = 0; i < 100; i++)
		{
			changeColor("rgb(0,100,0)",element,driver);	
			changeColor(bgColour,element,driver);
		}
	}
	public static void changeColor(String color, WebElement element , WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor ='" +color+"'",element);
	}
	// Draw Boarder
	public static void drawborder(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px Solid red'",element);
	}
	//Alert Message
	public static void genetareAlert(WebDriver driver, String message)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}

	//Click by Java Script 
	public static void clickElementbyJS(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();",element);
	}
	//Refresh Browser By JS
	public static void refreshpage(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	//Get Title By JS
	public static String gettitle(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title = js.executeScript("return document.title;").toString();
	    return title;
	}
	//Inner Text By JS
	public static String innertext(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	//ScrollPage By JS
	public static void scrollpage(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
}
