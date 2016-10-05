package app.freecharge.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import app.freecharge.androiddriver.DriverInitialization;

public class OffersPage extends DriverInitialization{		

	public OffersPage(){
		super();
	}

	Logger logger=Logger.getLogger(OffersPage.class); 
	public void offersClick() throws InterruptedException{
		Thread.sleep(5000);
		driver.findElement(By.xpath(elementprop.getProperty("OFFERS_LINK"))).click();
		Thread.sleep(5000);
	}

	@Override
	public void horizontalScroll() throws InterruptedException{
		offersClick();
		driver.findElement(By.xpath(elementprop.getProperty("INDEX_1"))).click();
		driver.findElement(By.xpath(elementprop.getProperty("INDEX_2"))).click();
		driver.findElement(By.xpath(elementprop.getProperty("INDEX_3"))).click();
		logger.info("Offers button functioned and Horizontal scroll validation completed");
	}
}
