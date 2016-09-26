package app.freecharge.pageobjects;


import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;

public class ResetPasswordPage extends DriverInitialization{

	public ResetPasswordPage(){
		super();
		
	}
	
	@Override
	public void resetPassword(){
		try{
			typeEditBox(ByLocator.id,"com.freecharge.android:id/forgot_enter_pwd_box", "xxxxxxxxx");
			typeEditBox(ByLocator.id,"com.freecharge.android:id/forgot_reenter_pwd_box", "xxxxxxxxx");
			typeEditBox(ByLocator.id,"com.freecharge.android:id/forgot_pwd_code_box", "xxxx");
			clickButton(ByLocator.id, "com.freecharge.android:id/forgot_reset_submit");
		}catch(Exception e){

		}


	}
}
