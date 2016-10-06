package app.freecharge.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.pageobjects.OfferPageObjects;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OffersPage extends DriverInitialization{		
	OfferPageObjects offerPageObjects = new OfferPageObjects();
	public OffersPage(){
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				offerPageObjects);
	}


	Logger logger=Logger.getLogger(OffersPage.class); 
	public void offersClick() throws InterruptedException{
		Thread.sleep(5000);
		offerPageObjects.OFFERS_LINK.click();
		Thread.sleep(5000);
	}

	@Override
	public void horizontalScroll() throws InterruptedException{
		offersClick();
		offerPageObjects.OFFERS_INDEX_1.click();
		offerPageObjects.OFFERS_INDEX_2.click();
		offerPageObjects.OFFERS_INDEX_3.click();
		logger.info("Offers button functioned and Horizontal scroll validation completed");
	}
}
