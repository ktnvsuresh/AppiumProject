package app.freecharge.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;
import app.freecharge.pageobjects.SigninPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignInPage extends DriverInitialization{		

	public SigninPageObject signinPageObjects= new SigninPageObject();
	public SignInPage(){
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				signinPageObjects);
		
	}

	public ForgotPasswordPage resetPassword = null;
	public NetworkConnectionsPage networkPage = null;
//	public SigninPageObject signinPageObjects= new SigninPageObject();
	Logger logger=Logger.getLogger(SignInPage.class); 

	@Override
	public void Login() throws InterruptedException
	{
		
		signinPageObjects.EMAIL_EDIT_TEXT.sendKeys("9177306662");
		signinPageObjects.PASSWORD_Edit_TEXT.sendKeys("kowtha");
		signinPageObjects.LOGIN_BUTTON.click();
		Thread.sleep(10000);
		popupClose();
		result = null;
		result=signinPageObjects.ACTION_BAR_TITLE_LOGIN.getText();
		logger.info(result);
		
		assert result.equals("Suresh"):"Expected value: Suresh:" + result;
		logger.info("User Successfully Loggedin");
	}

	@Override
	public void InvalidLogin() throws InterruptedException
	{
		typeEditBox(ByLocator.id,elementprop.getProperty("EMAIL_EDIT_TEXT"), "9876543210");
		typeEditBox(ByLocator.id,elementprop.getProperty("PASSWORD_Edit_TEXT"), "xxxxxxx");
		clickButton(ByLocator.id, elementprop.getProperty("LOGIN_BUTTON"));
		Thread.sleep(10000);
		Boolean result = false;
		result = driver.findElement(By.id(elementprop.getProperty("LOGIN_BUTTON"))).isDisplayed();
		logger.info(result);
		assert result.equals(true):"Expected value: true" + result;
		logger.info("Incorrect User details");
	}
	@Override
	public void FaceBookLogin() throws InterruptedException
	{
		clickButton(ByLocator.id, elementprop.getProperty("FACEBOOK_SIGN_BUTTON"));
		Thread.sleep(10000);
		popupClose();
		result = null;
		result = driver.findElement(By.xpath(elementprop.getProperty("ACTION_BAR_TITLE__FACEBOOK_LOGIN"))).getText();
		assert result.equals("Ramya Suresh"):"Expected value: Ramya Suresh:" + result;
		logger.info("User Successfully Loggedin with Facebook ID");

	}

	@Override
	public void GoogleLogin() throws InterruptedException
	{
		clickButton(ByLocator.id,elementprop.getProperty("GOOGLE_SIGN_BUTTON"));
		radioButton("ramyamca1@gmail.com");
		driver.findElement(By.name("OK")).click();
		Thread.sleep(10000);
		popupClose();
		result = null;
		result = driver.findElement(By.xpath(elementprop.getProperty("ACTION_BAR_TITLE__GOOGLE_LOGIN"))).getText();
		assert result.equals("Ramya Suresh"):"Expected value: Ramya Suresh:" + result;
		logger.info("User Successfully Loggedin with Goole ID");
	}


	@Override
	public void Login_WithOutNetwork() throws InterruptedException
	{	
		networkPage = new NetworkConnectionsPage();
		clickButton(ByLocator.id, elementprop.getProperty("GOOGLE_SIGN_BUTTON"));
		Thread.sleep(10000);
		networkPage.networkConnections();
		radioButton("ramyamca1@gmail.com");
		driver.findElement(By.name("OK")).click();
		Thread.sleep(10000);
		/*result = null;
		result = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/snackbar_text')]")).getText();
		logger.info(result);
		if (result.equals("Something went wrong and we are sorry for that. Please try again later")){
			assert result.equals("Something went wrong and we are sorry for that. Please try again later"):"Expected value: Something went wrong and we are sorry for that. Please try again later" + result;
		}
		else{
			assert result.equals("Please check your login details and try again later"):"Expected value: Please check your login details and try again later:" + result;
		}

		logger.info("Network down so User Not able to login with Google ID");*/
		//driver.sendKeyEvent(AndroidKeyCode.BACK);
		//driver.sendKeyEvent(AndroidKeyCode.BACK);
		networkPage.networkConnections();
	}
}
