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

public class DeletCustomer {
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
	public void deletCustomerTab() {
		WebElement deletCustomerTab = driver.findElement(By.xpath("//a[text()='Delete Customer']"));
		Assert.assertTrue(deletCustomerTab.isEnabled());
		System.out.println("deletCustomerTab is enabled");
		deletCustomerTab.click();
	}

	@Test(priority = 2)
	public void customerIdTab() {
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("29043");
	}

	@Test(priority = 3)
	public void submitbutton() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
		Alert alert = driver.switchTo().alert();
		String expMsg1 = "Do you really want to delete this Customer?";
		String actMsg1 = alert.getText();
		Assert.assertEquals(actMsg1, expMsg1);
		System.out.println("user is getting a alert message:Do you really want to delete this Customer?");
		alert.accept();
		Alert alert2 = driver.switchTo().alert();
		String expMsg2 = "Customer does not Exist!!!";
		String actMsg2 = alert2.getText();
		Assert.assertEquals(actMsg2, expMsg2);
		System.out.println("user is getting a alert message:Customer does not Exist!!!");
		alert2.accept();
		Thread.sleep(2000);
		File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file1, new File("F:\\ECLIPSE WORKSPACE\\guru99\\screenshot\\DeletCustomer.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
