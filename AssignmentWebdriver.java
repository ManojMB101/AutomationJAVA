package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentWebdriver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.id("signin_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("user_login")).sendKeys("username");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
		Thread.sleep(2000);
//      driver.findElement(By.name("submit")).click();
		driver.findElement(By.cssSelector("[name=submit]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Pay Bills")).click();

		driver.findElement(By.cssSelector("#sp_amount")).sendKeys("50");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#logout_link")).click();
		Thread.sleep(1000);

//        driver.findElement(By.linkText("Zero Bank")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("feedback")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@placeholder='Your Name']")).sendKeys("Manoj");
		Thread.sleep(1000);

		driver.findElement(By.cssSelector("#email[type='text']")).sendKeys("Mr@gmail.com");
		Thread.sleep(1000);

		driver.findElement(By.name("subject")).sendKeys("Enquiry");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("textarea#comment[name='comment']")).sendKeys("Very Good");
		Thread.sleep(1000);
		driver.findElement(By.name("clear")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#name")).sendKeys("Manoj");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#email[type='text']")).sendKeys("Mr@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.name("subject")).sendKeys("Enquiry");
		Thread.sleep(1000);
		driver.findElement(By.name("comment")).sendKeys("Automation comment");
		driver.findElement(By.name("submit")).click();

        driver.close();
        driver.quit();

	}

}
