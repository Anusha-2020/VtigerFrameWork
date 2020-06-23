package com.vtiger.testscripts;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.genericlib.BaseClass;

public class CreateOrganizationTest extends BaseClass{
	
	@Test
	public void createOrg() throws EncryptedDocumentException, IOException {
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		String orgName = data.getDataFromExcel("OrganizationData", 2, 1);
		Random r = new Random();
		int num = r.nextInt(9999);
		orgName = orgName + num;
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String actOrgMsg = driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]")).getText();
		Assert.assertTrue(actOrgMsg.contains(data.getDataFromExcel("OrganizationData", 2, 2)));	
	}
}
