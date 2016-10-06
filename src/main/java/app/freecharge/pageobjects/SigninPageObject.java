package app.freecharge.pageobjects;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;



public class SigninPageObject {
	@AndroidFindBy(id = "com.freecharge.android:id/email_edit_text")
	public MobileElement EMAIL_EDIT_TEXT;
	
	@AndroidFindBy(id = "com.freecharge.android:id/password_edit_text")
	public MobileElement PASSWORD_Edit_TEXT;
	
	@AndroidFindBy(id = "com.freecharge.android:id/login_button")
	public MobileElement LOGIN_BUTTON;
	
	@AndroidFindBy(id = "com.freecharge.android:id/facebook_signin_btn")
	public MobileElement FACEBOOK_SIGNIN_BUTTON;
	
	@AndroidFindBy(id = "com.freecharge.android:id/google_signin_btn")
	public MobileElement GOOGLE_SIGNIN_BUTTON;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/action_bar_title') and @text='Suresh']")
	public MobileElement ACTION_BAR_TITLE_LOGIN;

	
}
