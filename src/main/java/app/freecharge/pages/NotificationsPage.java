package app.freecharge.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

import app.freecharge.androiddriver.DriverInitialization;
import bsh.StringUtil;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class NotificationsPage extends DriverInitialization{		

	public NotificationsPage() {
		super();
	}

	Logger logger=Logger.getLogger(NotificationsPage.class);

	@Override
	public void ClearAllNotifications() {
		driver.openNotifications();
		try {
			if (driver.findElement(By.xpath(elementprop.getProperty("NOTIFICATIONS_CLEAR"))).isDisplayed()== true){
				driver.findElement(By.xpath(elementprop.getProperty("NOTIFICATIONS_CLEAR"))).click();
				logger.info("All Existing Notifications are cleared");
			}
			else{
				logger.info("Clear Notifications button not displayed");
				driver.sendKeyEvent(AndroidKeyCode.BACK);
			}
		}
		catch(Exception e){
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			logger.info("Clear Notifications button not displayed");
			
			//logger.error(e);
		}

	}

	@Override
	public  String Notifications() throws Exception{
		//open notification
		driver.openNotifications();
		String OTPMessage= null;
		//android.widget.TextView[contains(@resource-id,'android:id/title') and @text='IM-FCHRGE']
		OTPMessage=driver.findElement(By.xpath(elementprop.getProperty("NOTIFICATION_GET_TEXT"))).getText();
		logger.info("OTP Recieved and Saved text message from Notifications: " +OTPMessage);
		OTPMessage=OTPMessage.replaceAll("\\D+","");
		OTPMessage=OTPMessage.substring(0,4);
		logger.info("OTP value saved from message : " +OTPMessage);
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		return OTPMessage;
		
	}

}
