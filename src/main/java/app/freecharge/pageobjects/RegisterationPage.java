package app.freecharge.pageobjects;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;

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
			typeEditBox(ByLocator.id,"com.freecharge.android:id/registration_name", "suresh");
			typeEditBox(ByLocator.id,"com.freecharge.android:id/reg_mobile", "0123456789");
			typeEditBox(ByLocator.id,"com.freecharge.android:id/reg_email", "xxxxx@email.com");
			typeEditBox(ByLocator.id,"com.freecharge.android:id/reg_password", "xxxxxxxxx");
			driver.hideKeyboard();
			driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'com.freecharge.android:id/registration_button') and @text='SIGN UP']")).click();
			Thread.sleep(20000);
		}catch(Exception e){

		}
	}
}
