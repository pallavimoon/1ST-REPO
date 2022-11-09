package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
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

public class VerifyEditAccount {
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
  @Test(priority=1)
  public void editaccounttab() {
	  driver.findElement(By.xpath("//a[text()='Edit Account']")).click();  
  }
  @Test(priority=2)
  public void enableeditaccounttab() {
	  WebElement editacctab = driver.findElement(By.xpath("//input[@name='accountno']"));
		Assert.assertTrue(editacctab.isEnabled());
		System.out.println("editacctabb tab is enabled");
		editacctab.sendKeys("113378");
  }
  @Test(priority=3)
  public void submitbutton() throws InterruptedException {
	  driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
	  Thread.sleep(2000);
	  File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file1, new File("F:\\ECLIPSE WORKSPACE\\guru99\\screenshot\\EditAcount.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
  }
}
