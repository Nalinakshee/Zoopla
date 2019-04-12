package com.zoopla.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.base.ZooplaBase;

public class ZooplaAgent extends ZooplaBase{

	@FindBy(xpath="//a[@class='ui-agent__details' and @data-track-label='Agent block 1']//h4[@class='ui-agent__name']")
	WebElement agentName;
	
	@FindBy(xpath="//h1[@class='bottom-half']/b")
	WebElement agentNameonPage;
	
	public ZooplaAgent(){
		PageFactory.initElements(driver, this);
	}
	
	public String getAgentName() {
		String agentNameText = agentName.getText();
		System.out.println("Agent Name : "+ agentNameText);
		agentName.click();
		return agentNameText;
	}
	
	public String getAgentNameOnPage() {
		String agentNameOnPage = agentNameonPage.getText();
		System.out.println("Agent Name Page: "+ agentNameOnPage);
		return agentNameOnPage;
	}
	
}
