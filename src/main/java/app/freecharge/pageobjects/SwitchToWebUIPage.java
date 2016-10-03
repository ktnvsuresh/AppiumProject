package app.freecharge.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import app.freecharge.androiddriver.DriverInitialization;
import io.appium.java_client.android.AndroidKeyCode;

public class SwitchToWebUIPage extends DriverInitialization{		

	public SwitchToWebUIPage() {
		super();
	}


	Logger logger=Logger.getLogger(SwitchToWebUIPage.class);

	@Override
	public void switchToWebUI() throws InterruptedException{

		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title_text') and @text='More']")).click();
		driver.scrollTo("Terms of service");
		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/account_details_item_title') and @text='Terms of service']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.view.View[contains(@package,'com.android.browser') or contains(@package,'com.android.chrome') and contains(@content-desc,'Terms & Conditions')]")).click();
		result = null;
		result = driver.findElement(By.xpath("//android.widget.EditText[contains(@package,'com.android.browser') or contains(@package,'com.android.chrome') and contains(@resource-id,'com.android.browser:id/url') or contains(@resource-id,'com.android.chrome:id/url_bar')]")).getText();
		Thread.sleep(6000);
		logger.info(result);
		assert result.equals("https://www.freecharge.in/app/termsandconditions.htm"):"Expected value: https://www.freecharge.in/app/termsandconditions.htm" + result;
		logger.info("Terms and Conditions validation completed in Freecharge WEB UI");
		driver.sendKeyEvent(AndroidKeyCode.BACK);
	}
}