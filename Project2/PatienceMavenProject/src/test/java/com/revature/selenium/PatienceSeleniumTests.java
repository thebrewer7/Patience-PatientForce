package com.revature.selenium;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class PatienceSeleniumTests {
	public static WebDriver driver;
	public final String url = "http://34.207.69.111:8085/Patience";
	//public final String url = "http://localhost:4200/Patience";
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(url);
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Ignore
	public void testFrontEndInPatience() throws InterruptedException {
		
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
	
	@Test (priority=1)
	public void testAdminInPatience() {
		driver.findElement(By.name("login_username")).sendKeys("graspingly");
		driver.findElement(By.name("login_password")).sendKeys("onremonstrance");
		driver.findElement(By.name("login-submit")).click();
		//driver.findElement(By.name("switch")).click();
		List<WebElement> switches = driver.findElements(By.xpath("//label[@name='switch']"));
		for(WebElement s: switches) {
			s.click();
		}
		for(WebElement s: switches) {
			s.click();
		}
		driver.findElement(By.name("dropdownToggle")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("logoutPageLink")))).click();
		driver.findElement(By.name("dropdownToggle")).click();
	}
	
	@Test (priority=2)
	public void testPatientInPatience() {
		driver.findElement(By.name("login_username")).sendKeys("viduct");
		driver.findElement(By.name("login_password")).sendKeys("zold");
		driver.findElement(By.name("login-submit")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		for(int i = 0; i < 4; i++) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("docRow"+i)))).click();
			driver.navigate().back();
		}
		
		for(int i = 0; i < 4; i++) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nurRow"+i)))).click();
			driver.navigate().back();
		}
		
		driver.findElement(By.name("dropdownToggle")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("logoutPageLink")))).click();
		driver.findElement(By.name("dropdownToggle")).click();
	}
	
	@Test (priority=3)
	public void testUserInPatience() {
		driver.findElement(By.name("login_username")).sendKeys("urmi");
		driver.findElement(By.name("login_password")).sendKeys("cme");
		driver.findElement(By.name("login-submit")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		for(int i = 0; i < 4; i++) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("docRow"+i)))).click();
			driver.navigate().back();
		}
		
		for(int i = 0; i < 4; i++) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nurRow"+i)))).click();
			driver.navigate().back();
		}
		
		driver.findElement(By.name("dropdownToggle")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("logoutPageLink")))).click();
		driver.findElement(By.name("dropdownToggle")).click();
	}
	
	@Test (priority=4)
	public void testNurseInPatience() {
		driver.findElement(By.name("login_username")).sendKeys("iscomfort");
		driver.findElement(By.name("login_password")).sendKeys("zold");
		driver.findElement(By.name("login-submit")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		for(int i = 0; i < 4; i++) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("docTabRow"+i)))).click();
			driver.navigate().back();
		}
		
		for(int i = 0; i < 4; i++) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("docRow"+i)))).click();
			driver.navigate().back();
		}
		
		for(int i = 0; i < 4; i++) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nurRow"+i)))).click();
			driver.navigate().back();
		}
		
		driver.findElement(By.name("dropdownToggle")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("logoutPageLink")))).click();
		driver.findElement(By.name("dropdownToggle")).click();
	}
	
	@Test (priority=5)
	public void testDoctorInPatience() {
		driver.findElement(By.name("login_username")).sendKeys("hurt");
		driver.findElement(By.name("login_password")).sendKeys("aritype");
		driver.findElement(By.name("login-submit")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		for(int i = 0; i < 4; i++) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("patTabRow"+i)))).click();
			driver.navigate().back();
		}
		
		for(int i = 0; i < 4; i++) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("docRow"+i)))).click();
			driver.navigate().back();
		}
		
		for(int i = 0; i < 4; i++) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nurRow"+i)))).click();
			driver.navigate().back();
		}
		
		driver.findElement(By.name("dropdownToggle")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("logoutPageLink")))).click();
		driver.findElement(By.name("dropdownToggle")).click();
	}
	
	@Test (priority=6)
	public void testSearchBarInPatience() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.findElement(By.name("searchArea")).click();
		driver.findElement(By.name("searchArea")).sendKeys("Bernet");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Bernetta Ginsburg")))).click();
		driver.findElement(By.name("searchArea")).clear();
		
		driver.findElement(By.name("searchArea")).click();
		driver.findElement(By.name("searchArea")).sendKeys("Janie");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Janie Choi")))).click();
		driver.findElement(By.name("searchArea")).clear();
		
		driver.findElement(By.name("searchArea")).click();
		driver.findElement(By.name("searchArea")).sendKeys("Nedra");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Nedra Osburn")))).click();
		driver.findElement(By.name("searchArea")).clear();
		
		driver.findElement(By.name("searchArea")).click();
		driver.findElement(By.name("searchArea")).sendKeys("Doyle");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Doyle Backhaus")))).click();
		driver.findElement(By.name("searchArea")).clear();
		
		driver.findElement(By.name("searchArea")).click();
		driver.findElement(By.name("searchArea")).sendKeys("Argentina");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Argentina Cowher")))).click();
		driver.findElement(By.name("searchArea")).clear();
		
		driver.findElement(By.name("searchArea")).click();
		driver.findElement(By.name("searchArea")).sendKeys("Brigida");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Brigida Debruyn")))).click();
		driver.findElement(By.name("searchArea")).clear();
		
		driver.findElement(By.name("searchArea")).click();
		driver.findElement(By.name("searchArea")).sendKeys("Temeka");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Temeka Cornforth")))).click();
		driver.findElement(By.name("searchArea")).clear();
		
		driver.findElement(By.name("searchArea")).click();
		driver.findElement(By.name("searchArea")).sendKeys("Frieda");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Frieda Summerford")))).click();
		driver.findElement(By.name("searchArea")).clear();
	}
}
