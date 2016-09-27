package app.freecharge.pageobjects;


import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;


public class RegisterationPage extends DriverInitialization{		

	public RegisterationPage(){
		super();
	}

	public void registerClick()
	{
		//driver.findElementByName("REGISTER").click();
		
	}

	public void registration()
	{
		clickButton(ByLocator.name, "REGISTER");
		try{
		typeEditBox(ByLocator.id,"com.freecharge.android:id/registration_name", "suresh");
		typeEditBox(ByLocator.id,"com.freecharge.android:id/reg_mobile", "0123456789");
		typeEditBox(ByLocator.id,"com.freecharge.android:id/reg_email", "xxxxx@email.com");
		typeEditBox(ByLocator.id,"com.freecharge.android:id/reg_password", "xxxxxxxxx");
		clickButton(ByLocator.name, "SIGN UP");
		//System.out.println(driver.switchTo().alert().getText());
		System.out.println("Registration screen validation completed");
		}catch(Exception e){
			
		}
	}
}
