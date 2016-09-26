package app.freecharge.pageobjects;

import org.openqa.selenium.By;
import app.freecharge.androiddriver.DriverInitialization;


public class HomePage extends DriverInitialization{		

	public HomePage() {
		super();
	}

	public void homeClick() throws InterruptedException
	{
		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title_text') and @text='Home']") ).click();
		Thread.sleep(5000);
	}
}
