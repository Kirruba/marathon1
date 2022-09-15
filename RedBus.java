package marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Launch Chrome
		WebDriverManager.chromedriver().setup();

		// Disable Notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		// Load https://www.redbus.in/
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();

		// Add Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Type "Chennai" in the FROM text box
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
		Thread.sleep(3000);

		// Type "Bangalore" in the TO text box
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
		Thread.sleep(3000);

		// Select tomorrow's date in the Date field
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//td[text()='16']")).click();

		// Click Search Buses
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();

		// Print the number of buses shown as results (104 Buses found)
		System.out.println(driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']")).getText());

		// Close Primo Notification
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='close-primo']")).click();
		Thread.sleep(5000);

		// Choose SLEEPER in the left menu
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//ul[@class='list-chkbox']//label[@class='custom-checkbox'])[2]")).click();

		// click on view seats
		driver.findElement(By.xpath("//div[@class='button view-seats fr']")).click();

		// print the starting price
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//div[@class='seat-fare ']")).getText());

		// Print the available seats
		System.out.println(driver.findElement(By.xpath("//div[@class='seat-left m-top-30']")).getText());

	}

}
