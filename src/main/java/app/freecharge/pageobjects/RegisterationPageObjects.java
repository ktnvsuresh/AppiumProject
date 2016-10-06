package app.freecharge.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegisterationPageObjects {

	@AndroidFindBy(id="com.freecharge.android:id/registration_name")
	public MobileElement REGISTRATION_NAME; 

	@AndroidFindBy(id="com.freecharge.android:id/reg_mobile")
	public MobileElement REGISTRATION_MOBILE;


	@AndroidFindBy(id="com.freecharge.android:id/reg_mobile")
	public MobileElement REGISTRATION_EMAIL;
	
	
	@AndroidFindBy(id="com.freecharge.android:id/reg_password")
	public MobileElement REGISTRATION_PASSWORD;
			
	@AndroidFindBy(xpath ="//android.widget.Button[contains(@resource-id,'com.freecharge.android:id/registration_button') and @text='SIGN UP']")
	public MobileElement REGISTRATION_SIGN_UP_BUTTON; 
			
}
