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

public class BalanceEnquiry {
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
  public void balanceenquirytab() {
	  WebElement balanceenquirytab = driver.findElement(By.xpath("//a[text()='Balance Enquiry']"));
		Assert.assertTrue(balanceenquirytab.isEnabled());
		System.out.println("balanceenquirytab is enabled");
		balanceenquirytab.click();
  }
  @Test(priority=2)
  public void amounttab() {
	  WebElement amounttab = driver.findElement(By.xpath("//input[@name='accountno']"));
	  amounttab.sendKeys("123abc");
		WebElement warning1 = driver.findElement(By.xpath("//label[@id='message2']"));
		Assert.assertTrue(warning1.isDisplayed());
		System.out.println("user gets a warning: " + warning1.getText());
		amounttab.clear();
		amounttab.sendKeys("1234");
  }
  @Test(priority=3)
  public void submitWithIncorrectCredentials() {
	  driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
		Alert alert = driver.switchTo().alert();
		String expMsg2 = "Account does not exist";
		String actMsg2 = alert.getText();
		Assert.assertEquals(actMsg2, expMsg2);
		System.out.println("user is getting a alert message:Account does not exist");
		alert.accept();
  }
  @Test(priority=4)
  public void amountTabWithCorrectCredentials() {
	  WebElement amounttab2 = driver.findElement(By.xpath("//input[@name='accountno']"));
	  amounttab2.sendKeys("113428");
  }
  @Test(priority=5)
  public void submitbutton() throws InterruptedException {
	 	 driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
	 	  Thread.sleep(2000);
	 	  File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 		try {
	 			FileUtils.copyFile(file1, new File("F:\\ECLIPSE WORKSPACE\\guru99\\screenshot\\BalanceEnquiry.png"));
	 		} catch (IOException e) {
	 			e.printStackTrace();
	 		}
}
}