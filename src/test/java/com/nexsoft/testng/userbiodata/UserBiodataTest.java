package com.nexsoft.testng.dataabsen;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class UserBiodataTest {
	
	WebDriver driver;
  
	@BeforeClass
	public void init() {
		System.setProperty("url", "http://localhost/cicool/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(System.getProperty("url"));
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	}
	@Test
	public void login() {
		driver.findElement(By.cssSelector(".fa.fa-sign-in")).click(); 
		
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("maslachahawwaliyah@gmail.com"); 
		driver.findElement(By.cssSelector("input[placeholder='Password']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("@Lilike1922"); 
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		String username = driver.findElement(By.cssSelector("span[class='hidden-xs']")).getText();
		assertEquals("Maslachahawwaliyah", username);
  
	}
  

}
