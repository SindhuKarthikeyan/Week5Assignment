package week5.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethod;

public class MergeLead extends ProjectSpecificMethod {
	
	@BeforeTest
	public void setData() {
		excelFileName = "TC004";
	}
	
	
	
	@Test(dataProvider="ArrayData")
public void runTC005(String n1,String n2) throws InterruptedException {
	
	
	driver.findElementByLinkText("Merge Leads").click();
	driver.findElementByXPath("//img[@alt='Lookup']").click();
	Set<String> allWindows = driver.getWindowHandles();
	List<String> allhandles = new ArrayList<String>(allWindows);
	driver.switchTo().window(allhandles.get(1));
	driver.findElementByXPath("//input[@name='firstName']").sendKeys(n1);
	driver.findElementByXPath("//button[text()='Find Leads']").click();
	Thread.sleep(1000);
	String leadID = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").getText();
	driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
	driver.switchTo().window(allhandles.get(0));
	
	driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
	Set<String> allWindows2 = driver.getWindowHandles();
	List<String> allhandles2 = new ArrayList<String>(allWindows2);
	driver.switchTo().window(allhandles2.get(1));
	driver.findElementByXPath("//input[@name='firstName']").sendKeys(n2);
	driver.findElementByXPath("//button[text()='Find Leads']").click();
	Thread.sleep(1000);
	driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
	driver.switchTo().window(allhandles2.get(0));
	driver.findElementByXPath("//a[text()='Merge']").click();
	driver.switchTo().alert().accept();
	
	driver.findElementByLinkText("Find Leads").click();
	driver.findElementByXPath("//input[@name='id']").sendKeys(leadID);
	driver.findElementByXPath("//button[text()='Find Leads']").click();
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.textToBePresentInElement(driver.findElementByClassName("x-paging-info"), "No records to display"));
	String text = driver.findElementByClassName("x-paging-info").getText();
	if (text.equals("No records to display")) {
		System.out.println("Text matched");
	} else {
		System.out.println("Text not matched");
	}
	
	}


}
