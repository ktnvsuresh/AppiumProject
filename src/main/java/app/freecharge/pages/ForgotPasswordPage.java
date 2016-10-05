package app.freecharge.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;
import io.appium.java_client.android.AndroidKeyCode;

public class ForgotPasswordPage extends DriverInitialization{

	public ForgotPasswordPage(){
		super();

	}

	public NotificationsPage notificationsPage = null;

	Logger logger=Logger.getLogger(ForgotPasswordPage.class); 
	@Override
	public void ForgotPassword() throws Exception
	{
		notificationsPage = new NotificationsPage();
		notificationsPage.ClearAllNotifications();
		clickButton(ByLocator.id, elementprop.getProperty("SIGNIN_FORGOT_PWD_LINK"));
		typeEditBox(ByLocator.id, elementprop.getProperty("FORGOT_PWD_EMAIL_TEXT"), "ramyamca1@gmail.com");
		clickButton(ByLocator.id, elementprop.getProperty("FORGOT_PWD_SUBMIT_BUTTON"));
		//clickButton(ByLocator.id, "com.freecharge.android:id/rememeber_login");
		Thread.sleep(10000);
		typeEditBox(ByLocator.id,elementprop.getProperty("FORGOT_ENTER_PWD_TEXT"), "xxxxxxxxx");
		typeEditBox(ByLocator.id,elementprop.getProperty("FORGOT_REENTER_PWD_TEXT"), "xxxxxxxxx");
		driver.hideKeyboard();
		Thread.sleep(10000);
		String OTPmessagevalue= notificationsPage.Notifications();
		typeEditBox(ByLocator.id,elementprop.getProperty("FORGOT_PWD_CODE_TEXT"), OTPmessagevalue);
		driver.hideKeyboard();
		clickButton(ByLocator.id, elementprop.getProperty("FORGOT_RESET_SUBMIT_BUTTON"));
		result = null;
		result = driver.findElement(By.xpath(elementprop.getProperty("FORGOT_PWD_VALIDATION_TEXT"))).getText();
		assert result.equals("Password must contain at least one digit and atleast one alphabet"):"Expected value: password confirmPassword mismatch:" + result;
		System.out.println("Forgot Password screen validation completed");
		logger.info("Forgot Password screen validation completed");
		driver.sendKeyEvent(AndroidKeyCode.BACK);

	}
}
