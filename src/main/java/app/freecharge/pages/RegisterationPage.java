package app.freecharge.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.sun.jna.platform.win32.OaIdl.ELEMDESC;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;
import app.freecharge.pageobjects.RegisterationPageObjects;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class RegisterationPage extends DriverInitialization{		

	RegisterationPageObjects registerationPageObjects=new RegisterationPageObjects();
	public RegisterationPage(){
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				registerationPageObjects);
	}

	
	Logger logger=Logger.getLogger(RegisterationPage.class);

	@Override
	public void registration()
	{
		driver.findElementByName("REGISTER").click();
		try{
			registerationPageObjects.REGISTRATION_NAME.sendKeys("suresh");
			registerationPageObjects.REGISTRATION_MOBILE.sendKeys("0123456789");
			registerationPageObjects.REGISTRATION_EMAIL.sendKeys("xxxxx@email.com");
			registerationPageObjects.REGISTRATION_PASSWORD.sendKeys("xxxxxxxxx");
			driver.hideKeyboard();
			registerationPageObjects.REGISTRATION_SIGN_UP_BUTTON.click();
			Thread.sleep(5000);
			driver.hideKeyboard();
			Boolean result = false;
			result = registerationPageObjects.REGISTRATION_SIGN_UP_BUTTON.isDisplayed();
			assert result.equals(true):"Expected value: true" + result;
			logger.info("Registration Failed");
			driver.findElementByName("SIGN IN").click();
		}catch(Exception e){

		}
	}
}
