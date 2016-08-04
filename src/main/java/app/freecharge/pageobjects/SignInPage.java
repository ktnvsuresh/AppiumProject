package app.freecharge.pageobjects;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;

public class SignInPage extends DriverInitialization{		

	public SignInPage() {
		super();
	}

	public void Login()
	{
		typeEditBox(ByLocator.id,"com.freecharge.android:id/email_edit_text", "9177306662");
		typeEditBox(ByLocator.id,"com.freecharge.android:id/password_edit_text", "kowtha");
		clickButton(ByLocator.id, "com.freecharge.android:id/login_button");
		
	}
}
