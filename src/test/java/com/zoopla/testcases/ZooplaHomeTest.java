package com.zoopla.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.base.ZooplaBase;
import com.zoopla.pages.ZooplaAgent;
import com.zoopla.pages.ZooplaFifthProperty;
import com.zoopla.pages.ZooplaHome;
import com.zoopla.pages.ZooplaSearch;

import junit.framework.Assert;

public class ZooplaHomeTest extends ZooplaBase{
	ZooplaHome zooplaHome;
	ZooplaSearch zooplaSearch;
	ZooplaFifthProperty fifthProp;
	ZooplaAgent zooplaAgent;
	
	ZooplaHomeTest()
	{
		super();
	}
	
	@BeforeMethod()
	public void setup(){
		initialization();
		zooplaHome = new ZooplaHome();
		fifthProp = new ZooplaFifthProperty();
	}	
	
	/*@Test(priority=2)
	public void clickFifthElement() {
		zooplaSearch = zooplaHome.goToSearchPage();
		//zooplaSearch.getFifthElement();
		zooplaAgent = fifthProp.clickFifthElement();		
	}	*/
	@Test(priority=1)
	public void zooplaTest() {
		zooplaSearch = zooplaHome.goToSearchPage();
		zooplaSearch.getLinks();
		//String title = zooplaHome.searchPageTitle();
		//Assert.assertEquals("Property for Sale in London - Buy Properties in London - Zoopla", title);
		zooplaAgent = fifthProp.clickFifthElement();
		String agentName = zooplaAgent.getAgentName();
		String agentNameOnPage = zooplaAgent.getAgentNameOnPage();
		Assert.assertEquals(agentName,agentNameOnPage);
	}
	/*@Test(priority=3)
	public void getAgentName() {
		zooplaSearch = zooplaHome.goToSearchPage();
		zooplaAgent = fifthProp.clickFifthElement();
		zooplaAgent.getAgentName();
	}*/
	
	@AfterMethod()
	public void teardown() {
		driver.quit();
	}
}
