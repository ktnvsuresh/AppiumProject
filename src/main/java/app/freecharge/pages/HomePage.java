package app.freecharge.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.pageobjects.HomePageObjects;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class HomePage extends DriverInitialization{	

	HomePageObjects homePageObjects=new HomePageObjects();
	public HomePage() {
		super();

		PageFactory.initElements(new AppiumFieldDecorator(driver),
				homePageObjects);
	}


	Logger logger=Logger.getLogger(HomePage.class); 
	public void homeClick() throws InterruptedException
	{
		homePageObjects.HOME_LINK.click();
		Thread.sleep(5000);
		logger.info("Home Button Functioned Successfully");
	}
}
