package com.zoopla.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.zoopla.base.ZooplaBase;

public class ZooplaSearch extends ZooplaBase {

	public void getLinks() {
		try {
			List<WebElement> links = driver.findElements(By.tagName("a"));
			List<Integer> newLinks = new ArrayList<Integer>();
			
			//int linkcount = links.size();
			//System.out.println(linkcount);
			//System.out.println("Before Sorting:");
			for (WebElement myElement : links) {
				String link = myElement.getText();
				if(link.startsWith("£")) {					
					//System.out.println(link);
					
					try {
						int number =0;
						if (link.contains(" ")) {
							String textlink = link.substring(1, link.indexOf(' '));
							textlink = textlink.replace(",", "");
							//System.out.println("Text Link "+ textlink);
							number = Integer.parseInt(textlink);
						}else {
							String linkSub = link.substring(1);
							linkSub = linkSub.replace(",", "");
							//System.out.println("Sub Link "+ linkSub);
							number = Integer.parseInt(linkSub);
						}
						newLinks.add(number);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception " +e.getMessage());
					}
					
				}
			}
			
			 Collections.sort(newLinks, Collections.reverseOrder());
			 System.out.println("ArrayList in descending order:");
			   for(Integer str: newLinks){
					System.out.println("£"+str);
				}
		} catch (Exception e) {
			System.out.println("error " + e);
		}
	}
	
	/*public void getFifthElement() {
		try {
			List<WebElement> links = driver.findElements(By.tagName("a"));
			int counter = 1;			
			for (WebElement myElement : links) {
				String link = myElement.getText();
				if(link.startsWith("£")) {
					counter++;
					if(counter==5) {
						myElement.click();
						break;
					} 
					
				}
			}
		} catch (Exception e) {
			System.out.println("error " + e);
		}
	}*/
}
