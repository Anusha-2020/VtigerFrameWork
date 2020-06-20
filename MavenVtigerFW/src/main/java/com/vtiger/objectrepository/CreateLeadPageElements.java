package com.vtiger.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateLeadPageElements {
	
	@FindBy(name = "lastname")
	private WebElement lastNametb;
	
	@FindBy(name = "company")
	private WebElement companyNametb;
	
	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement saveBtn;
	
	public WebElement getLastNametb()
	{
		return lastNametb;
	}
	
	public WebElement getCompanyNametb()
	{
		return companyNametb;
	}
	
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
}
