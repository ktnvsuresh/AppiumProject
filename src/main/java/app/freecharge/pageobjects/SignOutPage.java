package app.freecharge.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import app.freecharge.androiddriver.DriverInitialization;


public class SignOutPage extends DriverInitialization{		

	public SignOutPage() {
		super();
	}

	
	Logger logger=Logger.getLogger(SignOutPage.class);
	@Override
	public void Logout() throws InterruptedException{

		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title_text') and @text='More']")).click();
		result = null;
		result = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title_text') and @text='More']")).getText();
		assert result.equals("More"):"Expected value: More:" + result;
		driver.scrollTo("Sign out");
		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title') and @text='Sign out']") ).click();
		logger.info("User Successfully LoggedOut");
	}
	
}
