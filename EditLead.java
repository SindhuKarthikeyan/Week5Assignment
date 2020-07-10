package week5.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethod;

public class EditLead extends ProjectSpecificMethod{
	@BeforeTest	
	public void setData() {
	excelFileName = "TC002";
	}
@Test(dataProvider="ArrayData")

	public void EditLead001 (String pNo,String updateCName)throws InterruptedException {
		
	
	driver.findElementByLinkText("Find Leads").click();
	driver.findElementByXPath("//span[text()='Phone']").click();
	driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(pNo);
	driver.findElementByXPath("//button[text()='Find Leads']").click();
	Thread.sleep(2000);
	driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
	driver.findElementByLinkText("Edit").click();
	driver.findElementById("updateLeadForm_companyName").clear();	
	driver.findElementById("updateLeadForm_companyName").sendKeys(updateCName);
	driver.findElementByName("submitButton").click();
	String tit=driver.getTitle();
	System.out.println("The Title of Edit Lead:" +tit);
		


	}

}
