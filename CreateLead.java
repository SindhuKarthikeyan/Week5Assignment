package week5.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethod;

public class CreateLead extends ProjectSpecificMethod {
@BeforeTest	
	public void setData() {
	excelFileName = "TC001";
}
@Test(dataProvider="ArrayData")

	public void CreateLead001(String cName, String fName,String lName,String pNo) {

		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys(cName);
		driver.findElementById("createLeadForm_firstName").sendKeys(fName);
		driver.findElementById("createLeadForm_lastName").sendKeys(lName);
		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys(pNo); 
		driver.findElementByName("submitButton").click();
		String tit=driver.getTitle();
		System.out.println("The Title of Create Lead:" +tit);
		

	}

}
 