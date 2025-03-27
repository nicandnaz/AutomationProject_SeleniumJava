package seleniumIntroduction;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.*;

public class Day2LocatorPractice {

	public static void main(String[] args) {
		testCase1(); //Login with correct credentials
		testCase2(); //Login with incorrect credentials
		testCase3(); //Forget Password
		testCase4(); //Login then Logout
		testCase5(); //Identify locators using siblings with xpath traverse
		testCase6();//Browser Navigation
	}
	
	public static void testCase1() {
		// Practice Locator using https://rahulshettyacademy.com/locatorspractice/
		//CORRECT CREDENTIALS
		//Step 1: Invoke browser and go to website - https://rahulshettyacademy.com/locatorspractice/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//Step 2: Input Username and Password
		driver.findElement(By.id("inputUsername")).sendKeys("nick");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.name("chkboxOne")).click();
		driver.findElement(By.name("chkboxTwo")).click();
			
		//Step 3: Click Sign-in button 
		driver.findElement(By.className("signInBtn")).click();		
		
		//Verify successful sign-in )
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean isSuccessfullSignin = driver.findElement(By.tagName("p")).isDisplayed();
		if (isSuccessfullSignin = true) {
			System.out.println(driver.findElement(By.tagName("p")).getText());
			
		}
		
		//Include Assertion
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
		//Close browser
		driver.quit();
	}
	
	public static void testCase2() {
		// Practice Locator using https://rahulshettyacademy.com/locatorspractice/
		//INCORRECT CREDENTIALS
		//Step 1: Invoke browser and go to website - https://rahulshettyacademy.com/locatorspractice/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//Step 2: Input Incorrect Username and Password
		driver.findElement(By.id("inputUsername")).sendKeys("asdsadasdsa");
		driver.findElement(By.name("inputPassword")).sendKeys("asdadasd");
			
		//Step 3: Click Sign-in button
		driver.findElement(By.className("signInBtn")).click();
		
		//Verify error message is displayed
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); //implicit wait
		boolean isErrorMessageDisplayed = driver.findElement(By.cssSelector("p.error")).isDisplayed();
		if (isErrorMessageDisplayed = true) {
			System.out.println("Error message is displayed!");
		}
				
		//Close browser
		driver.quit();	
	}
	
	public static void testCase3() {
		// Practice Locator using https://rahulshettyacademy.com/locatorspractice/
		//FORGET PASSWORD
		//Step 1: Invoke browser and go to website - https://rahulshettyacademy.com/locatorspractice/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
				
		//Step 2: Click Forgot Password using Linktext locator
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//Step 3: Fill forgot password fields and click Reset button using Xpath locator
		// syntax - //Tagname[@attribute='value']
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Chicken");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Egg@email.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("1234");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		
		// Verify successful forget password message
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2));
		Boolean isResetPasswordSuccessful = !driver.findElement(By.xpath("//p[@class='infoMsg']")).isDisplayed();
		if (isResetPasswordSuccessful = true) {
			System.out.println("Reset password is successful!");
		}
				//close browser
		driver.quit();			
	}
		
	public static void testCase4() {
		// Practice Locator using https://rahulshettyacademy.com/locatorspractice/
		//LOGIN AND LOGOUT
		//Step 1: Invoke browser and go to website - https://rahulshettyacademy.com/locatorspractice/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//Step 2: Input Username and Password
		driver.findElement(By.id("inputUsername")).sendKeys("nick");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.name("chkboxOne")).click();
		driver.findElement(By.name("chkboxTwo")).click();
			
		//Step 3: Click Sign-in button 
		driver.findElement(By.className("signInBtn")).click();		
		
		//Verify successful sign-in )
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean isSuccessfullSignin = driver.findElement(By.tagName("p")).isDisplayed();
		if (isSuccessfullSignin = true) {
			System.out.println(driver.findElement(By.tagName("p")).getText());
			
		}
		
		//Include Assertion
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
		//Step 4: Logout
		//Use xpath locator based on the button texts on the page
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		boolean isSuccessfulLogout = driver.findElement(By.xpath("//button[text()='Sign In']")).isDisplayed();
		if (isSuccessfulLogout = true) {
			System.out.println("Successfully Logged Out!");
		}		
		
		//Close browser
		driver.quit();
	}
	
	public static void testCase5() {
		// Practice Locator using https://rahulshettyacademy.com/AutomationPractice/
		//IDENTIFY LOCATORS USING SIBLINGS WITH XPATH TRAVERSE
		//Step 1: Invoke browser and go to website - https://rahulshettyacademy.com/AutomationPractice/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).click();
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		//Close browser
		driver.quit();
	}
	
	public static void testCase6() {
		// Practice Locator using https://rahulshettyacademy.com/AutomationPractice/
		//Browser Navigation
		//Step 1: Invoke browser and go to website - https://rahulshettyacademy.com/AutomationPractice/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
		driver.navigate().back();
		driver.navigate().forward();
		//Close browser
		driver.quit();
	}
	
}



