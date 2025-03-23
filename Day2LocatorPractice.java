package seleniumIntroduction;

import java.time.Duration;
import org.openqa.selenium.*;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2LocatorPractice {

	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
	}
	
	public static void testCase1() {
		// Practice Locator using https://rahulshettyacademy.com/locatorspractice/
		//CORRECT CREDENTIALS
		//Step 1: Invoke browser and go to website - https://rahulshettyacademy.com/locatorspractice/
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//Step 2: Input Username and Password
		driver.findElement(By.id("inputUsername")).sendKeys("nick");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.name("chkboxOne")).click();
		driver.findElement(By.name("chkboxTwo")).click();
			
		//Step 3: Click Sign-in button 
		driver.findElement(By.className("signInBtn")).click();		
		
		//Verify successful sign-in 
		boolean isSuccessfullSignin = driver.findElement(By.xpath("//p")).isDisplayed();
		if (isSuccessfullSignin = true) {
			System.out.println("Successfully Signed In");
		}
		
		//Close browser
		driver.quit();
	}
	
	public static void testCase2() {
		// Practice Locator using https://rahulshettyacademy.com/locatorspractice/
		//INCORRECT CREDENTIALS
		//Step 1: Invoke browser and go to website - https://rahulshettyacademy.com/locatorspractice/
		WebDriver driver = new ChromeDriver();
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
		Boolean isResetPasswordSuccessful = driver.findElement(By.xpath("//p[@class='infoMsg']")).isDisplayed();
		if (isResetPasswordSuccessful = true) {
			System.out.println("Reset password is successful!");
		}
		
		//close browser
		driver.quit();
	}
	}


