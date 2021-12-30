package SeleniumBasics;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm");
		Thread.sleep(4000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		WebElement resultframe = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));

		driver.switchTo().frame(resultframe);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();

		Thread.sleep(1000);
		Alert obj = driver.switchTo().alert();
		String s = obj.getText();
		System.out.println(obj.getText());
		assertEquals(s, "Press a button!");
		obj.accept();

		driver.close();
		driver.quit();
	}

}
