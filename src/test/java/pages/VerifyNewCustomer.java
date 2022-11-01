package pages;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

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

public class VerifyNewCustomer {
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
	public void NewCustomer() {
		driver.findElement(By.partialLinkText("New Customer")).click();
		WebElement iframe = driver.findElement(By.xpath("//iframe[@title='Advertisement']"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//div[@class='ns-k60k4-e-7 close-text']//span[@class='ns-k60k4-e-8']")).click();
		System.out.println("Navigated to new customer page");
	}

	@Test(priority = 2)
	public void verifyCustomerNameTextboxIsEnabled() {
		WebElement newcustomertxtbox = driver.findElement(By.xpath("//input[@name='name']"));
		Assert.assertTrue(newcustomertxtbox.isEnabled());
		System.out.println("CustomerName Textbox is enabled");
	}

	@Test(priority = 3)
	public void verifyCustomerNameTextbox() {
		WebElement newcustomertxtbox = driver.findElement(By.xpath("//input[@name='name']"));
		newcustomertxtbox.sendKeys("Abc123");
		WebElement warning1 = driver.findElement(By.xpath("//label[@id='message']"));
		Assert.assertTrue(warning1.isDisplayed());
		System.out.println("user gets a warning: " + warning1.getText());
		newcustomertxtbox.clear();
		newcustomertxtbox.sendKeys("Abc@123");
		WebElement warning2 = driver.findElement(By.xpath("//label[@id='message']"));
		Assert.assertTrue(warning2.isDisplayed());
		System.out.println("user gets a warning: " + warning2.getText());
		newcustomertxtbox.clear();
		newcustomertxtbox.sendKeys("Kriti Sanon");
	}

	@Test(priority = 4)
	public void verifygenderRadioButton() {
		driver.findElement(By.xpath("//input[@value='f']")).click();
		driver.findElement(By.xpath("//input[@value='m']")).click();
		driver.findElement(By.xpath("//input[@value='f']")).click();
		System.out.println("geneder radio button is working fine");
	}

	@Test(priority = 5)
	public void verifyCalendar() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("29051993");
		Thread.sleep(1000);
	}

	@Test(priority = 6)
	public void verifyAddressTextbox() {
		WebElement add = driver.findElement(By.xpath("//textarea[@name='addr']"));
		System.out.println("The address textbox is enabled: " + add.isEnabled());
		add.sendKeys("d/o Suresh Sanon @Chandigarh");
		WebElement warning1 = driver.findElement(By.xpath("//label[@id='message3']"));
		Assert.assertTrue(warning1.isDisplayed());
		System.out.println("user gets a warning: " + warning1.getText());
		add.clear();
		add.sendKeys("daughter of suresh mun chandigarh");

	}

	@Test(priority = 7)
	public void verifyCityTab() throws InterruptedException {
		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		Assert.assertTrue(city.isEnabled());
		System.out.println("city tab is enabled");
		city.sendKeys("123");
		WebElement warning1 = driver.findElement(By.xpath("//label[@id='message4']"));
		Assert.assertTrue(warning1.isDisplayed());
		System.out.println("user gets a warning: " + warning1.getText());
		city.clear();
		city.sendKeys("@^&*");
		WebElement warning2 = driver.findElement(By.xpath("//label[@id='message4']"));
		Assert.assertTrue(warning2.isDisplayed());
		System.out.println("user gets a warning: " + warning2.getText());
		city.clear();
		city.sendKeys("Chandigarh");
		Thread.sleep(5000);
	}

	@Test(priority = 8)
	public void verifyStateTab() {
		WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
		Assert.assertTrue(state.isEnabled());
		System.out.println("state tab is enabled");
		state.sendKeys("123");
		WebElement warning1 = driver.findElement(By.xpath("//label[@id='message5']"));
		Assert.assertTrue(warning1.isDisplayed());
		System.out.println("user gets a warning: " + warning1.getText());
		state.clear();
		state.sendKeys("@^&*");
		WebElement warning2 = driver.findElement(By.xpath("//label[@id='message5']"));
		Assert.assertTrue(warning2.isDisplayed());
		System.out.println("user gets a warning: " + warning2.getText());
		state.clear();
		state.sendKeys("Punjab");
	}

	@Test(priority = 9)
	public void verifyPinTab() {
		WebElement pin = driver.findElement(By.xpath("//input[@name='pinno']"));
		Assert.assertTrue(pin.isEnabled());
		System.out.println("pin tab is enabled");
		pin.sendKeys("123");
		WebElement warning1 = driver.findElement(By.xpath("//label[@id='message6']"));
		Assert.assertTrue(warning1.isDisplayed());
		System.out.println("user gets a warning: " + warning1.getText());
		pin.clear();
		pin.sendKeys("@^&*");
		WebElement warning2 = driver.findElement(By.xpath("//label[@id='message6']"));
		Assert.assertTrue(warning2.isDisplayed());
		System.out.println("user gets a warning: " + warning2.getText());
		pin.clear();
		pin.sendKeys("422401");

	}

	@Test(priority = 10)
	public void verifyMobileNoTab() {
		WebElement mob = driver.findElement(By.xpath("//input[@name='telephoneno']"));
		Assert.assertTrue(mob.isEnabled());
		System.out.println("mob tab is enabled");
		mob.sendKeys("ABC");
		WebElement warning1 = driver.findElement(By.xpath("//label[@id='message7']"));
		Assert.assertTrue(warning1.isDisplayed());
		System.out.println("user gets a warning: " + warning1.getText());
		mob.clear();
		mob.sendKeys("@^&*");
		WebElement warning2 = driver.findElement(By.xpath("//label[@id='message7']"));
		Assert.assertTrue(warning2.isDisplayed());
		System.out.println("user gets a warning: " + warning2.getText());
		mob.clear();
		mob.sendKeys("012345678913");
		System.out.println("TC failed=it is accepting more than 10 digits");
	}

	@Test(priority = 11)
	public void verifyEmailTab() {
		WebElement email = driver.findElement(By.xpath("//input[@name='emailid']"));
		Assert.assertTrue(email.isEnabled());
		System.out.println("email tab is enabled");
		email.sendKeys("kriti15@gmail.com");
	}

	@Test(priority = 12)
	public void verifyPasswordTab() {
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		Assert.assertTrue(pass.isEnabled());
		System.out.println("pass tab is enabled");
		pass.sendKeys("Kriti@123");
	}

	@Test(priority = 13)
	public void verifySubmitButton() {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("F:\\ECLIPSE WORKSPACE\\guru99\\screenshot\\newcustomer.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		WebElement submit = driver.findElement(By.xpath("//input[@name='sub']"));
		Assert.assertTrue(submit.isEnabled());
		System.out.println("submit button is enabled");
		submit.click();
		File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file1, new File("F:\\ECLIPSE WORKSPACE\\guru99\\screenshot\\newcustomer1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
