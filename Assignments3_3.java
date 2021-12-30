package SeleniumBasics;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignments3_3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[contains(@src,'cognizant')]")).click();
		Thread.sleep(5000);

		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);

		Thread.sleep(2000);
		for (String h : handles) {
			System.out.println("The value of current window is:" + h);
			driver.switchTo().window(h);
			System.out.println(driver.getTitle());

			if (driver.getTitle().contains("Cognizant Jobs - Career Opportunities in Cognizant - Naukri.com")) {
				driver.findElement(By.xpath("//input[@placeholder='Keyskills, Designation']"))
						.sendKeys("Automation Engineer");
				driver.findElement(By.xpath("//input[@value='Search']")).click();
				driver.close();
			}
		}

	}

}
