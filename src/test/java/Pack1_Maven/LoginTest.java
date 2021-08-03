package Pack1_Maven;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class LoginTest {
	WebDriver driver;

	@Test
	public void login() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement username = driver.findElement(By.xpath("//input[@name='txtUsername']"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']")); // sendKeys pour type de //
																							// text
		password.sendKeys("admin123");
		WebElement login = driver.findElement(By.xpath("//input[@name='Submit']"));
		login.click();//// button[@class='dropbtn']
		// WebElement welcomebtn = driver.findElement(By.xpath("//a[@id='welcome']"));
		// welcomebtn.click();
		driver.findElement(By.xpath("//a[@id='welcome']")).click();// concatination de 26 & 27
		Thread.sleep(4000); // pour donner un certain temps pour ouvrir
		WebElement logoutbtn = driver.findElement(By.xpath("//a[@href='/index.php/auth/logout']"));
		logoutbtn.click();
	}

	@Test
	public void synchTest() throws InterruptedException {
		driver.get("http://omayo.blogspot.com/");
		WebElement dropdownbtn = driver.findElement(By.xpath("//button[@class='dropbtn']"));
		dropdownbtn.click();
		Thread.sleep(4000);
		WebElement LienFacebook = driver.findElement(By.linkText("Facebook"));
		LienFacebook.click();
		

	}

	@BeforeClass // precondition
	public void setup() {
		// System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();// chercher le chemin du driver
		driver = new ChromeDriver(); // instance du chrome
		driver.manage().window().maximize();
	}

	@AfterClass // postcondition
	public void tearDown() {
		// driver.quit();
	}

}
