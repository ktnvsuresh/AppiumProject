package app.freecharge.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.pageobjects.NotificationPageObjects;
import bsh.StringUtil;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NotificationsPage extends DriverInitialization{
	
	NotificationPageObjects notificationPageObjects = new NotificationPageObjects();
	public NotificationsPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				notificationPageObjects);
	}

	
	Logger logger=Logger.getLogger(NotificationsPage.class);

	@Override
	public void ClearAllNotifications() {
		//driver.openNotifications();
			
		try {
			if (notificationPageObjects.NOTIFICATIONS_CLEAR.isDisplayed()== true){
				notificationPageObjects.NOTIFICATIONS_CLEAR.click();
				logger.info("All Existing Notifications are cleared");
			}
			else{
				logger.info("Clear Notifications button not displayed");
				//driver.sendKeyEvent(AndroidKeyCode.BACK);
				//driver.navigate().back();
				((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.BACK);
			}
		}
		catch(Exception e){
			//driver.sendKeyEvent(AndroidKeyCode.BACK);
			driver.navigate().back();
			logger.info("Clear Notifications button not displayed");
			
			//logger.error(e);
		}

	}

	@Override
	public  String Notifications() throws Exception{
		//open notification
		//driver.openNotifications();
		
		String OTPMessage= null;
		//android.widget.TextView[contains(@resource-id,'android:id/title') and @text='IM-FCHRGE']
		OTPMessage=notificationPageObjects.NOTIFICATION_GET_TEXT.getText();
		logger.info("OTP Recieved and Saved text message from Notifications: " +OTPMessage);
		OTPMessage=OTPMessage.replaceAll("\\D+","");
		OTPMessage=OTPMessage.substring(0,4);
		logger.info("OTP value saved from message : " +OTPMessage);
		//driver.sendKeyEvent(AndroidKeyCode.BACK);
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.BACK);
		return OTPMessage;
		
	}

}
