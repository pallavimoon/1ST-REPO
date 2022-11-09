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

public class VerifyEditCustomer {
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
	public void verifyEditCustomertab() {
		driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
		WebElement editcustomertab = driver.findElement(By.xpath("//input[@type='text']"));
		Assert.assertTrue(editcustomertab.isEnabled());
		System.out.println("Edit customer tab is enabled");
		editcustomertab.sendKeys("79805");
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
	}

	@Test(priority = 2)
	public void editNewCustomerName() {
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Mayuri Maykulkar");
		System.out.println("customer name edited");
	}

	@Test(priority = 3)
	public void editgender() {
		driver.findElement(By.xpath("//input[@value='f']")).click();
		System.out.println("gender edited");
	}

	@Test(priority = 4)
	public void editDOB() {
		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("29061994");
		System.out.println("DOB edited");
	}

	@Test(priority = 5)
	public void editADD() {
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys("d/o maykulkar @Chandigarh");
		System.out.println("DOB edited");
	}

	@Test(priority = 6)
	public void editCity() {
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("nagpur");
		System.out.println("city edited");
	}

	@Test(priority = 7)
	public void editState() {
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Maharashtra");
		System.out.println("state edited");
	}

	@Test(priority = 8)
	public void editPincode() {
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys("123456");
		System.out.println("pincode edited");
	}

	@Test(priority = 9)
	public void editPhoneNo() {
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys("9356324516");
		System.out.println("phone no edited");
	}

	@Test(priority = 10)
	public void editGmail() {
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("abcd@gmail.com");
		System.out.println("gmail edited");
	}

	@Test(priority = 11)
	public void editPass() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Abcd@456");
		System.out.println("pass edited");
		Thread.sleep(1000);
	}
    @Test(priority=12)
    public void clickOnSubmit() {
    	driver.findElement(By.xpath("//input[@name='sub']")).click();
    	File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file1, new File("F:\\ECLIPSE WORKSPACE\\guru99\\screenshot\\editcustomer.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
