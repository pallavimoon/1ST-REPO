package tests;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvalidCredential {
	public static WebDriver driver;

	@BeforeClass
	public void initBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demo.guru99.com/V4/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void loginWithInvalidCredentials() {
		driver.findElement(By.name("uid")).sendKeys("mngr939238");
		driver.findElement(By.name("password")).sendKeys("muvUqAs");
		driver.findElement(By.name("btnLogin")).click();
		Alert alert = driver.switchTo().alert();
		String expMsg1 = "User or Password is not valid";
		String actMsg1 = alert.getText();
		Assert.assertEquals(actMsg1, expMsg1);
		System.out.println("user is getting a alert message:User or Password is not valid");
		alert.accept();
	}

	@Test(priority = 2)
	public void loginWithInvalidPassword() {
		driver.findElement(By.name("uid")).sendKeys("mngr439038");
		driver.findElement(By.name("password")).sendKeys("MuvUqss");
		driver.findElement(By.name("btnLogin")).click();
		Alert alert = driver.switchTo().alert();
		String expMsg2 = "User or Password is not valid";
		String actMsg2 = alert.getText();
		Assert.assertEquals(actMsg2, expMsg2);
		System.out.println("user is getting a alert message:User or Password is not valid");
		alert.accept();
	}

	@Test(priority = 3)
	public void loginWithInvalidId() {
		driver.findElement(By.name("uid")).sendKeys("mngr939238");
		driver.findElement(By.name("password")).sendKeys("muvUqAs");
		driver.findElement(By.name("btnLogin")).click();
		Alert alert = driver.switchTo().alert();
		String expMsg3 = "User or Password is not valid";
		String actMsg3 = alert.getText();
		Assert.assertEquals(actMsg3, expMsg3);
		System.out.println("user is getting a alert message:User or Password is not valid");
		alert.accept();
	}

	@Test(priority = 4)
	public void loginwithemptyuserid() {
		driver.findElement(By.name("password")).sendKeys("muvUqAs");
		driver.findElement(By.name("btnLogin")).click();
		Alert alert = driver.switchTo().alert();
		String expMsg4 = "User or Password is not valid";
		String actMsg4 = alert.getText();
		Assert.assertEquals(actMsg4, expMsg4);
		System.out.println("user is getting a alert message:User or Password is not valid");
		alert.accept();
	}

	@Test(priority = 5)
	public void loginwithemptypass() {
		driver.findElement(By.name("uid")).sendKeys("mngr439038");
		driver.findElement(By.name("btnLogin")).click();
		Alert alert = driver.switchTo().alert();
		String expMsg4 = "User or Password is not valid";
		String actMsg4 = alert.getText();
		Assert.assertEquals(actMsg4, expMsg4);
		System.out.println("user is getting a alert message:User or Password is not valid");
		alert.accept();
	}

	@Test(priority = 6)
	public void loginwithemptypassanduserid() {
		driver.findElement(By.name("btnLogin")).click();
		Alert alert = driver.switchTo().alert();
		String expMsg4 = "User or Password is not valid";
		String actMsg4 = alert.getText();
		Assert.assertEquals(actMsg4, expMsg4);
		System.out.println("user is getting a alert message:User or Password is not valid");
		alert.accept();
	}
	
}
