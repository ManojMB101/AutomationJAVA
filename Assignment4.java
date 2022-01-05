package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Assignment4 {

	public WebDriver driver;

	@Test
	public void LoginTest() throws InterruptedException {

		driver.get("http://zero.webappsecurity.com/");
		driver.findElement(By.id("signin_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("user_login")).sendKeys("username");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[name=submit]")).click();
		Thread.sleep(2000);
		if (driver.findElement(By.id("details-button")).isDisplayed()) {
			driver.findElement(By.id("details-button")).click();
			driver.findElement(By.id("proceed-link")).click();
		}
		Thread.sleep(1000);
		driver.findElement(By.linkText("Pay Bills")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Purchase Foreign Currency")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Purchase']")).click();
		Thread.sleep(1000);
		Alert obj2 = driver.switchTo().alert();
		String s2 = obj2.getText();
		System.out.println(obj2.getText());
		assertEquals(s2, "Please, ensure that you have filled all the required fields with valid values.");
		Thread.sleep(1000);
		obj2.accept();

	}

	@Test(priority = 1)
	public void FundTransfer() throws InterruptedException {

		driver.get("http://zero.webappsecurity.com/");

		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#logout_link")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.name("user_login")).sendKeys("username");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[name=submit]")).click();

		Thread.sleep(1000);
		driver.findElement(By.linkText("Transfer Funds")).click();
		Thread.sleep(1000);
		Select FromAccount = new Select(driver.findElement(By.id("tf_fromAccountId")));
		FromAccount.selectByValue("1");

		Select ToAccount = new Select(driver.findElement(By.id("tf_toAccountId")));
		ToAccount.selectByValue("2");

		driver.findElement(By.id("tf_amount")).sendKeys("100");
		driver.findElement(By.id("tf_description")).sendKeys("Description");
		driver.findElement(By.id("btn_submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btn_submit")).click();

	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
		driver.close();
		driver.quit();
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}

}
