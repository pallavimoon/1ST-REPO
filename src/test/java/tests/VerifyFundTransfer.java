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

public class VerifyFundTransfer {
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
  public void verifyfundtransfertab() {
		WebElement fundtransfertab = driver.findElement(By.xpath("//a[text()='Fund Transfer']"));
		Assert.assertTrue(fundtransfertab.isEnabled());
		System.out.println("fundtransfertab is enabled");
		fundtransfertab.click();
  }
  @Test(priority=2)
  public void payerstab() {
  WebElement payerstab = driver.findElement(By.xpath("//input[@name='payersaccount']"));
  payerstab.sendKeys("123abc");
	WebElement warning1 = driver.findElement(By.xpath("//label[@id='message10']"));
	Assert.assertTrue(warning1.isDisplayed());
	System.out.println("user gets a warning: " + warning1.getText());
	payerstab.clear();
	payerstab.sendKeys("113428");
  }
  @Test(priority=3)
  public void payeestab() {
	  WebElement payeestab = driver.findElement(By.xpath("//input[@name='payeeaccount']"));
	  payeestab.sendKeys("123abc");
		WebElement warning2 = driver.findElement(By.xpath("//label[@id='message11']"));
		Assert.assertTrue(warning2.isDisplayed());
		System.out.println("user gets a warning: " + warning2.getText());
		payeestab.clear();
		payeestab.sendKeys("113378");
	  }
  @Test(priority=4)
  public void amounttofundtab() {
  	  WebElement amounttofundtab = driver.findElement(By.xpath("//input[@name='ammount']"));
  	  amounttofundtab.sendKeys("123abc");
  		WebElement warning2 = driver.findElement(By.xpath("//label[@id='message1']"));
  		Assert.assertTrue(warning2.isDisplayed());
  		System.out.println("user gets a warning: " + warning2.getText());
  		amounttofundtab.clear();
  		amounttofundtab.sendKeys("1000");
  	  }
  @Test(priority=5)
  public void descriptiontab() {
 	 driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input")).sendKeys("saving");
  }
  @Test(priority=6)
  public void submitbutton() throws InterruptedException {
 	 driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
 	  Thread.sleep(2000);
 	  File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 		try {
 			FileUtils.copyFile(file1, new File("F:\\ECLIPSE WORKSPACE\\guru99\\screenshot\\fundtransfer.png"));
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
}
}


