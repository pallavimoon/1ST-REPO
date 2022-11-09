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

public class VerifyDeposit {
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
	public void deposittab() {
		driver.findElement(By.xpath("//a[text()='Deposit']")).click();  
	}
  @Test(priority=2)
  public void Accountnotab() {
	  WebElement accountno = driver.findElement(By.xpath("//input[@name='accountno']"));
	  accountno.sendKeys("123abc");
		WebElement warning1 = driver.findElement(By.xpath("//label[@id='message2']"));
		Assert.assertTrue(warning1.isDisplayed());
		System.out.println("user gets a warning: " + warning1.getText());
		accountno.clear();
		accountno.sendKeys("113378");
  }
  @Test(priority=3)
  public void amounttab() {
	  WebElement amount = driver.findElement(By.xpath("//input[@name='ammount']"));
	  amount.sendKeys("500ac");
		WebElement warning2 = driver.findElement(By.xpath("//label[@id='message1']"));
		Assert.assertTrue(warning2.isDisplayed());
		System.out.println("user gets a warning: " + warning2.getText());
		amount.clear();
		amount.sendKeys("5000");
  }
 @Test(priority=4)
 public void descriptiontab() {
	 driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")).sendKeys("current01");
 }
 @Test(priority=5)
 public void submitbutton() throws InterruptedException {
	 driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
	  Thread.sleep(2000);
	  File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file1, new File("F:\\ECLIPSE WORKSPACE\\guru99\\screenshot\\deposit.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
 }
}
