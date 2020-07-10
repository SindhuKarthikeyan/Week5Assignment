package week5.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethod;

public class DuplicateLead extends ProjectSpecificMethod{
	@BeforeTest	
	public void setData() {
	excelFileName = "TC003";
	}
@Test(dataProvider="ArrayData")
	public void DuplicateLead001(String pNo) throws InterruptedException {
		
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(pNo);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		driver.findElementByLinkText("Duplicate Lead").click();
		driver.findElementByName("submitButton").click();
		String tit=driver.getTitle();
		System.out.println("The Title of Duplicate Lead:" +tit);
		

	}

}
