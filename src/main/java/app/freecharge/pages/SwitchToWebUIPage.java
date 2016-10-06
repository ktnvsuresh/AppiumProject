package app.freecharge.pages;

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

		driver.findElement(By.xpath(elementprop.getProperty("MORE_LINK"))).click();
		driver.scrollTo(elementprop.getProperty("TERMS_OF_SERVICE_LINK"));
		driver.findElement(By.xpath(elementprop.getProperty("TERMS_OF_SERVICE_XPATH"))).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath(elementprop.getProperty("TERMS_AND_CONDITIONS_WEBUI_XPATH"))).click();
		result = null;
		result = driver.findElement(By.xpath(elementprop.getProperty("GET_VALIDATE_WEB_URL"))).getText();
		Thread.sleep(10000);
		logger.info(result);
		assert result.equals("https://www.freecharge.in/app/termsandconditions.htm"):"Expected value: https://www.freecharge.in/app/termsandconditions.htm" + result;
		logger.info("Terms and Conditions validation completed in Freecharge WEB UI");
		//driver.sendKeyEvent(AndroidKeyCode.BACK);
	}
}