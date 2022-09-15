package marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Launch Chrome
		WebDriverManager.chromedriver().setup();

		// Disable Notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		// Load Salesforce link
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();

		// Add Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// enter username
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");

		// enter password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password#123");

		// click login button
		driver.findElement(By.xpath("//input[@id='Login']")).click();

		// Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// Click view All and click Sales from App Launcher
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		// Click on Accounts tab
		Thread.sleep(10000);
		WebElement findElement = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", findElement);

		// Click on New button
		driver.findElement(By.xpath("//div[text()='New']")).click();

		// Enter 'your name' as account name
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Kirruba");

		// Select Ownership as Public
		Thread.sleep(5000);
		WebElement findElement1 = driver.findElement(By.xpath("//label[text()='Ownership']/following::button"));
		driver.executeScript("arguments[0].click();", findElement1);

		Thread.sleep(5000);
		WebElement findElement2 = driver.findElement(By.xpath("//span[text()='Public']"));
		driver.executeScript("arguments[0].click();", findElement2);

		// click save
		driver.findElement(By.xpath("//button[text()='Save']")).click();

		// verify message
		String attribute = driver
				.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']//a"))
				.getAttribute("title");
		System.out.println(attribute);

		if (attribute.contains("Kirruba")) {
			System.out.println("Account Name is verified successfully");
		} else {
			System.out.println("Account Name is incorrect");
		}
	}

}
