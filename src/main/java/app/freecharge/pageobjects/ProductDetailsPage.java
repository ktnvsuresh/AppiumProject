package app.freecharge.pageobjects;

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
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.view.View[@index = '2']")).click();
		logger.info("Product Details validation completed");
		
		driver.sendKeyEvent(AndroidKeyCode.BACK);
	}



}
