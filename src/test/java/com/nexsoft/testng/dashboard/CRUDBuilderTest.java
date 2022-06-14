package com.nexsoft.testng.dashboard;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CRUDBuilderTest {
	WebDriver driver; // selenium
	public JavascriptExecutor jse;

	@BeforeClass
	public void init() {
		System.setProperty("url", "http://localhost/cicool/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		jse = (JavascriptExecutor) driver;
		driver.get(System.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test(priority = 0)
	public void login() {
		driver.findElement(By.cssSelector(".fa.fa-sign-in")).click();

		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("maslachahawwaliyah@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("@Lilike1922");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		String username = driver.findElement(By.cssSelector("span[class='hidden-xs']")).getText();
		assertEquals("Maslachahawwaliyah", username);
		// driver.close();

	}

	@Test(priority = 1, dataProvider = "getNexSoftData", dataProviderClass = com.nexsoft.testng.dataprovider.DataProviderAbsen.class)
	public void createData(String param1, String param2, String param3, String param4) {

		driver.get("http://localhost/cicool/administrator/userbiodata");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.id("btn_add_new")).click();

		driver.findElement(By.id("first_name")).click();
		driver.findElement(By.id("first_name")).sendKeys(param1);

		driver.findElement(By.id("last_name")).click();
		driver.findElement(By.id("last_name")).sendKeys(param2);

		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys(param3);

		driver.findElement(By.id("gender")).click();
		driver.findElement(By.id("gender")).sendKeys(param4);
		
		jse.executeScript("window.scrollBy(100, 500)", "");		
		WebElement upload = driver.findElement(By.cssSelector("input[title='file input"));
	    
		
		int randomVal = 1 + (int) (Math.random() * ((3 - 1) + 1));
		if (randomVal == 1) {
			upload.sendKeys("D:\\2022\\eclipse-workspace\\TestNG_Day19\\src\\test\\resources\\harimau.jpg");
		}else if (randomVal == 2) {
			upload.sendKeys("D:\\2022\\eclipse-workspace\\TestNG_Day19\\src\\test\\resources\\gunung.jpg");
		}else {
			upload.sendKeys("D:\\2022\\eclipse-workspace\\TestNG_Day19\\src\\test\\resources\\laut.jpg");
		}
		
		
		try {
	    	Thread.sleep(1000);
	    } catch (InterruptedException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }
	    
	    
	    driver.findElement(By.xpath("//a[@id='btn_save']")).click();
	    
	    
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    
	}

}
