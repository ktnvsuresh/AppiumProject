package app.freecharge.pageobjects;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;

public class SignInPage extends DriverInitialization{		

	public SignInPage() {
		super();
	}

	public ResetPasswordPage resetPassword = null;
	
	@Override
	public void Login() throws InterruptedException
	{
		typeEditBox(ByLocator.id,"com.freecharge.android:id/email_edit_text", "9177306662");
		typeEditBox(ByLocator.id,"com.freecharge.android:id/password_edit_text", "kowtha");
		clickButton(ByLocator.id, "com.freecharge.android:id/login_button");
		Thread.sleep(10000);
	}

	@Override
	public void ForgotPassword()
	{

		clickButton(ByLocator.id, "com.freecharge.android:id/signin_forgot_password");
		typeEditBox(ByLocator.id, "com.freecharge.android:id/forgot_pwd_email_box", "sureshktnv2004@gmail.com");
		clickButton(ByLocator.id, "com.freecharge.android:id/forgot_pwd_submit");
		clickButton(ByLocator.id, "com.freecharge.android:id/rememeber_login");
		resetPassword.resetPassword(); 

	}
	
	@Override
	public void FaceBookLogin()
	{
		clickButton(ByLocator.id, "com.freecharge.android:id/facebook_signin_btn");
		clickButton(ByLocator.id, "com.facebook.katana:id/login_bottom_first_link");
		typeEditBox(ByLocator.id, "com.facebook.katana:id/login_username","mapptestauto@gmail.com");
		typeEditBox(ByLocator.id, "com.facebook.katana:id/login_password","appium@123");
		clickButton(ByLocator.id, "com.facebook.katana:id/login_login");
		
		typeEditBox(ByLocator.id, "com.freecharge.android:id/mobile_number","");
		clickButton(ByLocator.id, "com.freecharge.android:id/mobile_confirm_continue");
		adb shell input keyevent KEYCODE_APP_SWITCH
	}

	public void GoogleLogin()
	{
		clickButton(ByLocator.id, "com.freecharge.android:id/social_signin_layout");


	}
}
