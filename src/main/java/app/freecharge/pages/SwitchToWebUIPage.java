package app.freecharge.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.pageobjects.MorePageObjects;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SwitchToWebUIPage extends DriverInitialization{		

	MorePageObjects morePageObjects = new  MorePageObjects();
	public SwitchToWebUIPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				morePageObjects);
	}

	
	Logger logger=Logger.getLogger(SwitchToWebUIPage.class);

	@Override
	public void switchToWebUI() throws InterruptedException{

		morePageObjects.MORE_LINK.click();
		//driver.scrollTo(elementprop.getProperty("TERMS_OF_SERVICE_LINK"));
		driver.scrollTo("Terms of service");
		morePageObjects.TERMS_OF_SERVICE_LINK.click();
		Thread.sleep(15000);
		morePageObjects.TERMS_AND_CONDITIONS_WEBUI.click();
		result = null;
		result = morePageObjects.GET_VALIDATE_WEB_URL.getText();
		Thread.sleep(10000);
		logger.info(result);
		assert result.equals("https://www.freecharge.in/app/termsandconditions.htm"):"Expected value: https://www.freecharge.in/app/termsandconditions.htm" + result;
		logger.info("Terms and Conditions validation completed in Freecharge WEB UI");
		//driver.sendKeyEvent(AndroidKeyCode.BACK);
		driver.navigate().back();
	}
}