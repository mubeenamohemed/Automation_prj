package pages;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Lulu_page {
	WebDriver driver;
	By logo=By.xpath("//*[@id=\"lulu WebCommerce\"]/a/img");
	
	By loginbtn=By.xpath("//*[@id=\"header\"]/section/div/div/div[4]/ul/li[3]/a");
	By signupbtn=By.xpath("//*[@id=\"loginFormToSubmit\"]/div[17]/a");
	
	
	//------------constructor------------------
	public Lulu_page(WebDriver driver)
	{
		this.driver=driver;
	}
	//----------------title verification-----------
	public void titleverification()
	{
		String actualtitle=driver.getTitle();
		String expectedtitle="Buy Online Groceries, Electronics, Mobiles &amp; Home Appliances&nbsp;with Fast &amp; Free Delivery | LuLu UAE";
		if(actualtitle.equals(expectedtitle))
		{
			System.out.println("title verified");
		}
		else
		{
			System.out.println("title not verified");
		}
    }
	//---------------content verification--------------
		public void contentverification()
		{
			String content=driver.getPageSource();
			if(content.equalsIgnoreCase("LuLu Hypermarket UAE Website"))
			{
				System.out.println("content is present ");
			}
			else 
			{
				System.out.println("content not present");
			}
		}
		//-------------------link validation-----------------
		public void linkvalidation() throws Exception
		{
			String baseurl="https://www.luluhypermarket.com/en-ae";
			driver.get(baseurl);
			URL ob=new URL(baseurl);
			HttpURLConnection con=(HttpURLConnection)ob.openConnection();
			con.connect();
			if(con.getResponseCode()==200)
			{
				System.out.println("valid url");
			}
			else
			{
				System.out.println("invalid url");
			}
			
		}
		//-----------logo is present or not ----------------
		public void logo()
		{
			WebElement ilogo=driver.findElement(logo);
			if(ilogo.isDisplayed())
			{
				System.out.println("logo is displayed");
			}
			else
			{
				System.out.println("logo is not present");
			}
		}
		//-------------screenshot------------------
		public void screenshot() throws Exception
		{
			System.out.println("---------screenshot------------");
			WebElement itlogo=driver.findElement(logo);
			File src=itlogo.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("./screenshot//logo1.png"));
			//File src1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//FileHandler.copy(src1, new File("./screenshot//logo2.png"));
		}
		//--------------sign up-----------------
		//email :qwerty123@gmail.com
		//password:Qwerty@123
		
		public void signup()
		{
			driver.findElement(loginbtn).click();
			driver.findElement(signupbtn).click();
			
			
		}
		
}
