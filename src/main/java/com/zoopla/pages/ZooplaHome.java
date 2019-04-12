package com.zoopla.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.base.ZooplaBase;

public class ZooplaHome extends ZooplaBase{
	
	@FindBy(xpath ="//input[@name='q']")
	WebElement searchField;
	
	@FindBy(xpath="//button[@type='submit' and  @value='Search']")
	WebElement searchBtn;
	
	
	public ZooplaHome(){
		PageFactory.initElements(driver, this);
	}
	
	public String searchPageTitle() {
		return driver.getTitle();
	}
	
	public ZooplaSearch goToSearchPage() {
		searchField.sendKeys(prop.getProperty("searchValue"));
		searchBtn.click();
		return new ZooplaSearch();
	}
}
