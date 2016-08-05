package app.freecharge.pageobjects;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;

public class SignInPage extends DriverInitialization{		

	public SignInPage() {
		super();
	}

	public ResetPasswordPage resetPassword = null;

	public void Login()
	{
		typeEditBox(ByLocator.id,"com.freecharge.android:id/email_edit_text", "9177306662");
		typeEditBox(ByLocator.id,"com.freecharge.android:id/password_edit_text", "kowtha");
		clickButton(ByLocator.id, "com.freecharge.android:id/login_button");

	}


	public void ForgotPassword()
	{

		clickButton(ByLocator.id, "com.freecharge.android:id/signin_forgot_password");
		typeEditBox(ByLocator.id, "com.freecharge.android:id/forgot_pwd_email_box", "sureshktnv2004@gmail.com");
		clickButton(ByLocator.id, "com.freecharge.android:id/forgot_pwd_submit");
		clickButton(ByLocator.id, "com.freecharge.android:id/rememeber_login");
		resetPassword.resetPassword(); 

	}

	public void FaceBookLogin()
	{


	}

	public void GoogleLogin()
	{



	}
}
