package app.freecharge.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import app.freecharge.androiddriver.DriverInitialization;


public class HomePage extends DriverInitialization{		

	public HomePage() {
		super();
	}
	
	Logger logger=Logger.getLogger(HomePage.class); 
	public void homeClick() throws InterruptedException
	{
		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title_text') and @text='Home']") ).click();
		Thread.sleep(5000);
		System.out.println("Home Button Functioned Successfully");
		logger.info("Home Button Functioned Successfully");
	}
}
