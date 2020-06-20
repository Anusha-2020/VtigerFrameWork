package com.vtiger.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElements {
	
	@FindBy(linkText = "Leads")
	private WebElement leads;
	
	@FindBy(linkText = "Organizations")
	private WebElement organization;
	
	@FindBy(linkText = "Products")
	private WebElement product;
	
	@FindBy(xpath = "//span[text()=' Administrator']/../following-sibling::td[1]/img")
	private WebElement signoutDropdown;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	public WebElement getLeads()
	{
		return leads;
	}
	
	public WebElement getOrganizations()
	{
		return organization;
	}
	
	public WebElement getProducts()
	{
		return product;
	}
	
	public WebElement getSignoutDropdown()
	{
		return signoutDropdown;
	}
	
	public WebElement getSignoutLink()
	{
		return signoutLink;
	}

}
