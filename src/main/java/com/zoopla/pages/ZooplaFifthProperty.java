package com.zoopla.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.base.ZooplaBase;

public class ZooplaFifthProperty extends ZooplaBase{

	@FindBy(xpath= "//ul[@data-role='listview']/li[5]//a[@class='listing-results-price text-price']")
	WebElement fifthElement;
	
	public ZooplaFifthProperty(){
		PageFactory.initElements(driver, this);
	}
	
	public ZooplaAgent clickFifthElement() {
		System.out.println("Fifthelement is "+fifthElement.getText());
		fifthElement.click();
		//System.out.println("Agent Name "+ agentName.getText());
		return new ZooplaAgent();
	}	
}
