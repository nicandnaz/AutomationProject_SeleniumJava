package seleniumIntroduction;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.*;

public class Day4CheckboxPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testCase1(); //Handling staticDropdowns

	}
	
	public static void testCase1() {
		//Handling Checkboxes
		
		//Step 1: Invoke Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Step 2: Tick a checkbox and verify if said checkbox is ticked
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		boolean isChecked = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected();
		if (isChecked == true) {
			System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).toString() + "is selected");
		}	
	}	
}
