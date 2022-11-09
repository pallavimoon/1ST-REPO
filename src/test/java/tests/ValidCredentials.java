package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidCredentials {
	public static WebDriver driver;
  @BeforeClass
  public void initBrowser() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.demo.guru99.com/V4/index.php");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  }
  @AfterClass
  public void tearDown() {
	  driver.quit();
  }
  @Test(priority=1)
  public void verifyUrl() {
	  String expUrl="https://www.demo.guru99.com/V4/index.php";
	  String actUrl=driver.getCurrentUrl();
	  Assert.assertEquals(actUrl, expUrl);
	  System.out.println("The url=www.demo.guru99.com/V4/index.php is navigating user to the login page");
  }
  @Test(priority=2)
  public void verifyLoginWithCorrectCredential() {
	  driver.findElement(By.name("uid")).sendKeys("mngr439038");
	  driver.findElement(By.name("password")).sendKeys("muvUqAs");
	  driver.findElement(By.name("btnLogin")).click();
	  System.out.println("user is able to login with valid credentials");
  }
}
