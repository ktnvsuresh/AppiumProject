package app.freecharge.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import app.freecharge.androiddriver.DriverInitialization;


public class SignOutPage extends DriverInitialization{		

	public SignOutPage() {
		super();
	}

	
	Logger logger=Logger.getLogger(SignOutPage.class);

	public void Logout() throws InterruptedException{

		logger.info("User Log Out function started....");
		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title_text') and @text='More']")).click();
		//mpage.signOut();
		result = null;
		result = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title_text') and @text='More']")).getText();
		assert result.equals("More"):"Expected value: More:" + result;
		driver.scrollTo("Sign out");
		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title') and @text='Sign out']") ).click();
		logger.info("User Successfully LoggedOut");
	}
	
}
