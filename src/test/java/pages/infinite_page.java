package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.io.FileHandler;

public class infinite_page {
	
	WebDriver driver;
	By logo=By.xpath("//*[@id=\"login-register\"]/div[1]/div/a/img");
	
	By register=By.id("abtnRegister");
	By firstname=By.id("txtRegFirstName");
	By lastname=By.id("txtRegLastName");
	By email=By.id("txtRegEmail");
	By password=By.id("txtRegPassword");
	By createaccountbtn=By.xpath("/html[1]/body[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[6]/div[1]/input[1]");
	
	By login=By.id("abtnLogin");
	By loginmailid=By.id("txtLogEmail");
	By loginpassword=By.id("txtLogPassword");
	By signinbtn=By.xpath("/html/body/div[1]/div[2]/div[5]/div/div/div/div/div[2]/div[1]/form/div/div[4]/div");
	By discoveruae=By.xpath("//*[@id=\"cms-tourpackages\"]/a");
	By veiwdetails=By.xpath("//*[@id=\"dv_packages\"]/div[1]/div/div/div/div/div[2]/a");
	By enquiry=By.xpath("//*[@id=\"content\"]/section/div/div[2]/div[4]/div/button");
	
	By fstnme=By.xpath("//*[@id=\"FirstName\"]");
	By adult=By.xpath("//*[@id=\"Adult\"]");
	By adult2=By.xpath("//*[@id=\"Adult\"]/option[2]");
	By children=By.xpath("//*[@id=\"Child\"]");
	By children1=By.xpath("//*[@id=\"Child\"]/option[2]");
	By enemail=By.id("Email");
	By enphn=By.id("Mobile");
	By enhotel=By.xpath("//*[@id=\"HotelPreference\"]/option[2]");
	By trvldt=By.xpath("//*[@id=\"TravelDate\"]");
	By rtndt=By.xpath("//*[@id=\"ReturnDate\"]");
	
	//---------------constructor-------------------
	public infinite_page(WebDriver driver)
	{
		this.driver=driver;
	}
	//--------------title verification-------------------
	public void titleverification()
	{
		String actualtitle=driver.getTitle();
		String expectedtitle="Infinity Travel, Abu Dhabi : Book Online Flights, Hotels, Tours";
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
		if(content.equalsIgnoreCase("travel agency abu dhabi, flight tickets"))
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
		String baseurl="https://www.infinitytravel.ae/";
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
	
	//------------registration-----------
	public void registration() throws Exception 
	{
	
		driver.findElement(register).click();
		Thread.sleep(1000);
		driver.findElement(firstname).sendKeys("zz");
		driver.findElement(lastname).sendKeys("plant");
		driver.findElement(email).sendKeys("zzplant123@gmail.com");
		driver.findElement(password).sendKeys("Zzplant@321");
		driver.findElement(createaccountbtn).click();
		driver.switchTo().alert().accept();
	}
	//----------------login----------------------
	public void login() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(login).click();
		
		File f= new File("D:\\Book1.xlsx");
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet("Sheet1");
		System.out.println(sh.getLastRowNum());

		
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			String mailid=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println(mailid);
			
			String passwrd=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(passwrd);
			
			driver.findElement(loginmailid).clear();
			driver.findElement(loginmailid).sendKeys(mailid);

			
			driver.findElement(loginpassword).clear();
			driver.findElement(loginpassword).sendKeys(passwrd);
		
			driver.findElement(signinbtn).click();
		}
		System.out.println("login sucessfull");
		
	}
	//-------------flight booking-----------
	public void packagebooking() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(discoveruae).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.linkText("Dubai Tour"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		
		driver.findElement(veiwdetails).click();
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		driver.findElement(enquiry).click();
		
		driver.findElement(fstnme).sendKeys("qwerty");
		driver.findElement(adult).click();
		driver.findElement(adult2).click();
		driver.findElement(children).click();
		driver.findElement(children1).click();
		driver.findElement(enemail).sendKeys("qwerty123@gmail.com");
		driver.findElement(enphn).sendKeys("05297813525");
		driver.findElement(enhotel).click();
		driver.findElement(trvldt).click();
		//month selection 
		while(true)
		{
			
		WebElement month =driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div"));
		String month1=month.getText();
		

		if (month1.equalsIgnoreCase("May 2024"))
		{
			System.out.println(month1);
			break;
		}
		else 
		{
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a")).click();
		}
		}
		
		//date selection 
		
		List<WebElement> trldates=driver.findElements(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr/td"));
		for(WebElement dateelement:trldates)
		{
			String date =dateelement.getText();
			if (date.equals("6"))
			{
				System.out.println(date);
				dateelement.click();
				System.out.println("date selected");
				break;
			}	
		}
		driver.findElement(rtndt).click();
		//month selection 
				while(true)
				{
					
				WebElement month =driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div"));
				String month1=month.getText();
				

				if (month1.equalsIgnoreCase("june 2024"))
				{
					System.out.println(month1);
					break;
				}
				else 
				{
					driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a")).click();
				}
				}
				
				//date selection 
				
				List<WebElement> alldates=driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr/td/a"));
				for(WebElement dateelement:alldates)
				{
					String date =dateelement.getText();
					if (date.equals("7"))
					{
						System.out.println(date);
						dateelement.click();
						System.out.println("date selected");
						break;
					}	
				}
		
	}
		
	
	
	
	
}
