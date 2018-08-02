package com.revature.selenium;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PatienceSeleniumTests {
	public static WebDriver driver;
	//public final String url = "http://34.205.71.228:8085/Patience";
	public final String url = "http://localhost:4200/Patience";
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get(url);
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void testFrontEndElementsPatience() throws InterruptedException {
		
		WebElement dbTogElem = driver.findElement(By.name("dropdownToggle"));
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		Actions actions = new Actions(driver);
		Action mouseOverDbTogElem = actions.moveToElement(dbTogElem).build();
		
		mouseOverDbTogElem.perform();
		
		driver.findElement(By.name("profilePageLink")).click();
		driver.findElement(By.name("rate5")).click();
		driver.findElement(By.name("rate4")).click();
		driver.findElement(By.name("rate3")).click();
		driver.findElement(By.name("rate2")).click();
		driver.findElement(By.name("rate1")).click();
		driver.findElement(By.name("reviewTxtArea")).sendKeys("selenium test review");
		driver.findElement(By.name("reviewSubmitBtn")).click();
		
		mouseOverDbTogElem.perform();
		
		driver.findElement(By.name("adminPageLink")).click();
		driver.findElement(By.name("patientTog")).click();
		driver.findElement(By.name("doctorTog")).click();
		driver.findElement(By.name("nurseTog")).click();
		driver.findElement(By.name("userTog")).click();
		
		mouseOverDbTogElem.perform();
		
		driver.findElement(By.name("doctorPageLink")).click();
		
		mouseOverDbTogElem.perform();
		
		driver.findElement(By.name("nursePageLink")).click();
		
		mouseOverDbTogElem.perform();
		
		driver.findElement(By.name("patientPageLink")).click();
		
		mouseOverDbTogElem.perform();
		
		driver.findElement(By.name("userPageLink")).click();
		
		mouseOverDbTogElem.perform();
		
		driver.findElement(By.name("loginPageLink")).click();
		driver.findElement(By.name("username")).sendKeys("username");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("remember")).click();
		driver.findElement(By.name("login-submit")).click();
		driver.findElement(By.name("forgot-password")).click();
		
		mouseOverDbTogElem.perform();
		
		driver.findElement(By.name("loginPageLink")).click();
		driver.findElement(By.name("register-form-link")).click();
		driver.findElement(By.name("username")).sendKeys("username");
		driver.findElement(By.name("email")).sendKeys("email@email.com");
		driver.findElement(By.name("register-submit")).click();
		
		mouseOverDbTogElem.perform();
		driver.findElement(By.name("profilePageLink")).click();
		
		
		assertEquals(driver.getTitle(), "Patience");
	}
}
