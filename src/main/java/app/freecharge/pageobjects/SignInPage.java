package app.freecharge.pageobjects;


import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;
import io.appium.java_client.android.AndroidKeyCode;

public class SignInPage extends DriverInitialization{		

	public SignInPage(){
		super();
	}

	public ForgotPasswordPage resetPassword = null;
	public NetworkConnectionsPage networkPage = null;

	@Override
	public void Login() throws InterruptedException
	{
		typeEditBox(ByLocator.id,"com.freecharge.android:id/email_edit_text", "9177306662");
		typeEditBox(ByLocator.id,"com.freecharge.android:id/password_edit_text", "kowtha");
		clickButton(ByLocator.id, "com.freecharge.android:id/login_button");
		Thread.sleep(10000);
		result = null;
		result = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/action_bar_title') and @text='Suresh']")).getText();
		assert result.equals("Suresh"):"Expected value: Suresh:" + result;
		System.out.println("User Successfully Loggedin");

		//popupClose();
	}

	@Override
	public void FaceBookLogin() throws InterruptedException
	{
		clickButton(ByLocator.id, "com.freecharge.android:id/facebook_signin_btn");
		Thread.sleep(10000);
		//popupClose();
		result = null;
		result = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/action_bar_title') and @text='Ramya Suresh']")).getText();
		assert result.equals("Ramya Suresh"):"Expected value: Ramya Suresh:" + result;
		System.out.println("User Successfully Loggedin with Facebook ID");

	}

	@Override
	public void GoogleLogin() throws InterruptedException
	{
		//networkPage.networkConnections();
		clickButton(ByLocator.id, "com.freecharge.android:id/google_signin_btn");
		radioButton("ramyamca1@gmail.com");
		driver.findElement(By.name("OK")).click();
		Thread.sleep(10000);
		//popupClose();
		result = null;
		result = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/action_bar_title') and @text='Ramya Suresh']")).getText();
		assert result.equals("Ramya Suresh"):"Expected value: Ramya Suresh:" + result;
		System.out.println("User Successfully Loggedin with Goole ID");
	}
	
	
	@Override
	public void Login_WithOutNetwork() throws InterruptedException
	{	
		networkPage = new NetworkConnectionsPage();
		clickButton(ByLocator.id, "com.freecharge.android:id/google_signin_btn");
		networkPage.networkConnections();
		radioButton("ramyamca1@gmail.com");
		driver.findElement(By.name("OK")).click();
		Thread.sleep(10000);
		//popupClose();
		result = null;
		result = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/snackbar_text') and @text='Please check your login details and try again later']")).getText();
		assert result.equals("Please check your login details and try again later"):"Expected value: Please check your login details and try again later:" + result;
		System.out.println("Network down so User Not able to loggedin with Goole ID");
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		networkPage.networkConnections();
	}
}
