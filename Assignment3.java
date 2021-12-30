package SeleniumBasics;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.findElement(By.id("signin_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("user_login")).sendKeys("username");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[name=submit]")).click();
		Thread.sleep(2000);
		if(driver.findElement(By.id("details-button")).isDisplayed()) {
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
		String s2=obj2.getText();
		System.out.println(obj2.getText());
		assertEquals(s2,"Please, ensure that you have filled all the required fields with valid values.");
		Thread.sleep(1000);
		obj2.accept();

		driver.close();
		driver.quit();
	}

}
