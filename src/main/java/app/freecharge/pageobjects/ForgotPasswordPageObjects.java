package app.freecharge.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ForgotPasswordPageObjects {

	@AndroidFindBy (id = "com.freecharge.android:id/signin_forgot_password")
	public MobileElement FORGOT_PWD_LINK; 
	
	@AndroidFindBy (id =" com.freecharge.android:id/forgot_pwd_email_box")
	public MobileElement FORGOT_PWD_EMAIL;
	
	@AndroidFindBy(id= " com.freecharge.android:id/forgot_pwd_submit")
	public MobileElement FORGOT_PWD_SUBMIT_BUTTON;
	
	@AndroidFindBy (id= "com.freecharge.android:id/forgot_enter_pwd_box")
	public MobileElement FORGOT_ENTER_PWD;
	
	@AndroidFindBy (id= "com.freecharge.android:id/forgot_reenter_pwd_box")
	public MobileElement FORGOT_REENTER_PWD;
	
	@AndroidFindBy (id= "com.freecharge.android:id/forgot_pwd_code_box")
	public MobileElement FORGOT_PWD_CODE;
	
	@AndroidFindBy (id= "com.freecharge.android:id/forgot_reset_submit")
	public MobileElement FORGOT_RESET_SUBMIT_BUTTON;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/reset_pwd_err') and @text='Password must contain at least one digit and atleast one alphabet']")
	public MobileElement FORGOT_PWD_VALIDATION;
			

}
