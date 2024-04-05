package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.infinite_page;

public class Infinite_test {
	
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void urlload()
	{
		driver.get("https://www.infinitytravel.ae/");
		driver.manage().window().maximize();
	}
	@Test
	public void test() throws Exception
	{
		infinite_page ob=new infinite_page(driver);
		ob.titleverification();
		ob.contentverification();
		ob.linkvalidation();
		//ob.screenshot();
		ob.logo();
		//ob.registration();
		//ob.login();
		ob.packagebooking();
		
		// ob.booking();
		
		
		
     }

	

}
