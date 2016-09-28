package app.freecharge.pageobjects;

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
		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title_text') and @text='Offers']") ).click();
		Thread.sleep(5000);
	}
	
	@Override
	public void horizontalScroll() throws InterruptedException{
		offersClick();
		driver.findElement(By.xpath("//android.view.View[@index = '1']")).click();
		driver.findElement(By.xpath("//android.view.View[@index = '2']")).click();
		driver.findElement(By.xpath("//android.view.View[@index = '3']")).click();
		logger.info("Offers button functioned and Horizontal scroll validation completed");
	}
}
