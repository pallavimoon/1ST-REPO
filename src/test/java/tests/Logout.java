package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Logout {
	public static WebDriver driver;

	@BeforeClass
	public void initBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demo.guru99.com/V4/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("uid")).sendKeys("mngr439038");
		driver.findElement(By.name("password")).sendKeys("muvUqAs");
		driver.findElement(By.name("btnLogin")).click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void logoutTab() throws InterruptedException {
		WebElement logouttab = driver.findElement(By.xpath("//a[text()='Log out']"));
		Assert.assertTrue(logouttab.isEnabled());
		System.out.println("logouttab is enabled");
		logouttab.click();
		Alert alert = driver.switchTo().alert();
		String expMsg1 = "You Have Succesfully Logged Out!!";
		String actMsg1 = alert.getText();
		Assert.assertEquals(actMsg1, expMsg1);
		System.out.println("user is getting a alert message:You Have Succesfully Logged Out!!");
		alert.accept();
		Thread.sleep(2000);
		File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file1, new File("F:\\ECLIPSE WORKSPACE\\guru99\\screenshot\\Logout.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
