package app.freecharge.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;
import app.freecharge.pageobjects.ForgotPasswordPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ForgotPasswordPage extends DriverInitialization{

	ForgotPasswordPageObjects forgotPasswordPageObjects=new ForgotPasswordPageObjects();
	public ForgotPasswordPage(){
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				forgotPasswordPageObjects);

	}

	public NotificationsPage notificationsPage = null;

	Logger logger=Logger.getLogger(ForgotPasswordPage.class); 
	@Override
	public void ForgotPassword() throws Exception
	{
		notificationsPage = new NotificationsPage();
		notificationsPage.ClearAllNotifications();
		forgotPasswordPageObjects.FORGOT_PWD_LINK.click();
		forgotPasswordPageObjects.FORGOT_PWD_EMAIL.sendKeys("ramyamca1@gmail.com");
		forgotPasswordPageObjects.FORGOT_PWD_SUBMIT_BUTTON.click();
		Thread.sleep(10000);
		forgotPasswordPageObjects.FORGOT_ENTER_PWD.sendKeys("xxxxxxxxx");
		forgotPasswordPageObjects.FORGOT_REENTER_PWD.sendKeys("xxxxxxxxx");
		driver.hideKeyboard();
		Thread.sleep(10000);
		String OTPmessagevalue= notificationsPage.Notifications();
		forgotPasswordPageObjects.FORGOT_PWD_CODE.sendKeys(OTPmessagevalue);
		driver.hideKeyboard();
		forgotPasswordPageObjects.FORGOT_RESET_SUBMIT_BUTTON.click();
		result = null;
		result = forgotPasswordPageObjects.FORGOT_PWD_VALIDATION.getText();
		assert result.equals("Password must contain at least one digit and atleast one alphabet"):"Expected value: password confirmPassword mismatch:" + result;
		System.out.println("Forgot Password screen validation completed");
		logger.info("Forgot Password screen validation completed");
		//driver.sendKeyEvent(AndroidKeyCode.BACK);
		driver.navigate().back();



	}
}
