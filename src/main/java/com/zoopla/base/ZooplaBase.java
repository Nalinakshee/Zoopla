package com.zoopla.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.zoopla.utils.ZooplaUtils;

public class ZooplaBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public ZooplaBase(){
		prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(
					"C:\\Eclipse\\WS\\ZooplaPOM\\src\\main\\java\\com\\zoopla\\config\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.24.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(ZooplaUtils.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(ZooplaUtils.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
