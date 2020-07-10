package baseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utility.ReadExcel;

public class ProjectSpecificMethod {

public ChromeDriver driver;
public String excelFileName;
@Parameters({"url","username","password"})
	@BeforeMethod	
	public void LoginCredential(String Url,String UserName,String Password) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys(UserName);
		driver.findElementById("password").sendKeys(Password);
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		
		
	}
		@AfterMethod
		public void Close() {
			driver.close();
			}
		
		@DataProvider(name="ArrayData")
		public String[][]sendData() throws IOException {
			//create 2D Array
			String[][] array=ReadExcel.readExcelData(excelFileName);
			return array;
			
			
		}
	}


