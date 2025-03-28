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
		
		//Step 2: Select Currency | Static Dropdown with Select
		WebElement currency = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		Select currencyDropdown = new Select(currency);	
		currencyDropdown.selectByIndex(2);
		
		//Step 3: Select number and type of passengers
		driver.findElement(By.id("divpaxinfo")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i;
		//Add 4 Adult, 3 Child, 2 Infant
		for(i=0; i < 3; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		} //Adult
		
		for(i=0; i < 3; i++) {
			driver.findElement(By.id("hrefIncChd")).click();
		} //Child
		
		for(i=0; i < 2; i++) {
			driver.findElement(By.id("hrefIncInf")).click();
		} //Infant
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div/div[@id='divpaxinfo']")).getText(), "4 Adult, 3 Child, 2 Infant");
		System.out.println(driver.findElement(By.xpath("//div/div[@id='divpaxinfo']")).getText());
		
		//Step 4: Select From location //Dynamic Dropdown with Indexes
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='GAU']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("(//a[@value='JAI'])[2]")).click(); 
		
		
		//Step X: Enter Country | Autosuggestive Dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("land");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//li/a[text()='Ireland']")).click();
	
		//Close browser
//		driver.quit();
		
	}


}
