package app.freecharge.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import app.freecharge.androiddriver.DriverInitialization;
import io.appium.java_client.android.AndroidKeyCode;

public class ProductDetailsPage extends DriverInitialization {

	public ProductDetailsPage() {
		super();

	}

	Logger logger=Logger.getLogger(ProductDetailsPage.class);
	@Override
	public void productdetails() throws InterruptedException{
		driver.findElement(By.name("Shopping")).click();
		Thread.sleep(10000);
		try {
			driver.findElement(By.xpath(elementprop.getProperty("INDEX_1"))).click();
			logger.info("Product Details validation completed");
			Thread.sleep(20000);
			driver.findElement(By.xpath(elementprop.getProperty("IMAGE_BUTTON"))).click();
			Thread.sleep(20000);
			
		}
		catch (Exception e) {
			logger.info("Men's Apparel is not displayed");
			logger.error(e);
		}
		
		
	}



}
