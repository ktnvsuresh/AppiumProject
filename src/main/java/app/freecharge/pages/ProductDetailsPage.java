package app.freecharge.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.pageobjects.ProductDetailsPageObjects;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductDetailsPage extends DriverInitialization {

	ProductDetailsPageObjects productDetailsPageObjects= new ProductDetailsPageObjects();
	public ProductDetailsPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				productDetailsPageObjects);
	}

	
	Logger logger=Logger.getLogger(ProductDetailsPage.class);
	@Override
	public void productdetails() throws InterruptedException{
		productDetailsPageObjects.SHOPPING.click();
		Thread.sleep(10000);
		try {
			productDetailsPageObjects.Product_INDEX_1.click();
			logger.info("Product Details validation completed");
			Thread.sleep(20000);
			productDetailsPageObjects.IMAGE_BUTTON.click();
			Thread.sleep(10000);
			
		}
		catch (Exception e) {
			logger.info("Men's Apparel is not displayed");
			logger.error(e);
		}
		
		
	}



}
