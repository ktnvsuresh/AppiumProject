package app.freecharge.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.sun.jna.platform.win32.OaIdl.ELEMDESC;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;


public class RegisterationPage extends DriverInitialization{		

	public RegisterationPage(){
		super();
	}

	Logger logger=Logger.getLogger(RegisterationPage.class);

	@Override
	public void registration()
	{
		driver.findElementByName("REGISTER").click();
		try{
			typeEditBox(ByLocator.id,elementprop.getProperty("REGISTRATION_NAME"), "suresh");
			typeEditBox(ByLocator.id,elementprop.getProperty("REGISTRATION_MOBILE"), "0123456789");
			typeEditBox(ByLocator.id,elementprop.getProperty("REGISTRATION_EMAIL"), "xxxxx@email.com");
			typeEditBox(ByLocator.id, elementprop.getProperty("REGISTRATION_PASSWORD"), "xxxxxxxxx");
			driver.hideKeyboard();
			driver.findElement(By.xpath(elementprop.getProperty("REGISTRATION_SIGN_UP_BUTTON"))).click();
			Thread.sleep(5000);
			driver.hideKeyboard();
			Boolean result = false;
			result = driver.findElement(By.xpath(elementprop.getProperty("REGISTRATION_SIGN_UP_BUTTON"))).isDisplayed();
			assert result.equals(true):"Expected value: true" + result;
			logger.info("Registration Failed");
			driver.findElementByName("SIGN IN").click();
		}catch(Exception e){

		}
	}
}
