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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewAccount {
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
  public void NewAccountTab() {
	  driver.findElement(By.xpath("//a[text()='New Account']")).click();
  }
  @Test(priority=2)
  public void verifyEnableCustomerId() {
	  WebElement customeridtab = driver.findElement(By.xpath("//input[@name='cusid']"));
		Assert.assertTrue(customeridtab.isEnabled());
		System.out.println("customeridtab tab is enabled");
		customeridtab.sendKeys("41050");
  
  }
  @Test(priority=3)
  public void selectaccounttype() {
WebElement drop=  driver.findElement(By.xpath("//select[@name='selaccount']"));
	  Select ref=new Select(drop);
	  ref.selectByValue("Current");	  
  }
  @Test(priority=4)
  public void initialdeposittab() {
	  driver.findElement(By.xpath("//input[@name='inideposit']")).sendKeys("1000");
  }
  @Test(priority=5)
  public void submitbutton() throws InterruptedException {
	  driver.findElement(By.xpath("//input[@name='button2']")).click();
	  Thread.sleep(2000);
	  File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file1, new File("F:\\ECLIPSE WORKSPACE\\guru99\\screenshot\\NewAccount.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
  }
}

