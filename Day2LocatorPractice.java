package seleniumIntroduction;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2LocatorPractice {

	public static void main(String[] args) {
		testCase1();
		testCase2();
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
			
		//Step 3: Click Sigin button
		driver.findElement(By.className("signInBtn")).click();
		
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
		
		//Step 4: Verify error message is displayed
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); //implicit wait
		System.out.println(driver.findElement(By.cssSelector("p.error")).isDisplayed());
		
		//Close browser
		driver.quit();
	}
	}


