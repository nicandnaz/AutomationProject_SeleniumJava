package seleniumIntroduction;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.*;

public class Day3FieldsPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testCase1(); //Handling staticDropdowns

	}
	
	public static void testCase1() {
		//Handling Static Dropdowns
		
		//Step 1: Invoke browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Step 2: Select Currency
		WebElement currency = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		Select currencyDropdown = new Select(currency);	
		currencyDropdown.selectByIndex(2);
	}


}
