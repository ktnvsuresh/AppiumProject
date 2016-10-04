package app.freecharge.pageobjects;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;
import app.freecharge.common.utils.NotificationsPage;
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
		clickButton(ByLocator.id, "com.freecharge.android:id/signin_forgot_password");
		typeEditBox(ByLocator.id, "com.freecharge.android:id/forgot_pwd_email_box", "ramyamca1@gmail.com");
		clickButton(ByLocator.id, "com.freecharge.android:id/forgot_pwd_submit");
		//clickButton(ByLocator.id, "com.freecharge.android:id/rememeber_login");
		Thread.sleep(10000);
		typeEditBox(ByLocator.id,"com.freecharge.android:id/forgot_enter_pwd_box", "xxxxxxxxx");
		typeEditBox(ByLocator.id,"com.freecharge.android:id/forgot_reenter_pwd_box", "xxxxxxxxx");
		driver.hideKeyboard();
		Thread.sleep(10000);
		String OTPmessagevalue= notificationsPage.Notifications();
		typeEditBox(ByLocator.id,"com.freecharge.android:id/forgot_pwd_code_box", OTPmessagevalue);
		driver.hideKeyboard();
		clickButton(ByLocator.id, "com.freecharge.android:id/forgot_reset_submit");
		result = null;
		result = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/reset_pwd_err') and @text='Password must contain at least one digit and atleast one alphabet']")).getText();
		assert result.equals("Password must contain at least one digit and atleast one alphabet"):"Expected value: password confirmPassword mismatch:" + result;
		System.out.println("Forgot Password screen validation completed");
		logger.info("Forgot Password screen validation completed");
		driver.sendKeyEvent(AndroidKeyCode.BACK);

	}
}
