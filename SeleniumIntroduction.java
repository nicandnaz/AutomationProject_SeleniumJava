package seleniumIntroduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntroduction implements WebDriver{

	public static void main(String[] args) {
		
		//Invoking Browser
		//Chrome - ChromeDriver -> Methods
		//Firefox - FirefoxDriver -> Methods
		//Safari - SafariDriver -> Methods
		
		//Google Chrome Launch
		WebDriver driver = new ChromeDriver();
		
		//Firefox Launch
//		WebDriver driver = new FirefoxDriver();
		
		//Edge Launch
//		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		
	
	}

}
