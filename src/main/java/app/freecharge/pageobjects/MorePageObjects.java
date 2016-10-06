package app.freecharge.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MorePageObjects {
	
	
	@AndroidFindBy (name ="Terms of service")
	public MobileElement TERMS_OF_SERVICE_LINK;
	
	@AndroidFindBy (xpath ="//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/account_details_item_title') and @text='Terms of service']")
	public MobileElement TERMS_OF_SERVICE_XPATH;
	
	@AndroidFindBy (xpath ="//android.view.View[contains(@package,'com.android.browser') or contains(@package,'com.android.chrome') and contains(@content-desc,'Terms & Conditions')]")
	public MobileElement TERMS_AND_CONDITIONS_WEBUI;
	
	@AndroidFindBy (xpath ="//android.widget.EditText[contains(@package,'com.android.browser') or contains(@package,'com.android.chrome') and contains(@resource-id,'com.android.browser:id/url') or contains(@resource-id,'com.android.chrome:id/url_bar')]")
	public MobileElement GET_VALIDATE_WEB_URL;
	
	@AndroidFindBy (xpath ="//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title_text') and @text='More']")
	public MobileElement MORE_LINK;

	@AndroidFindBy (xpath ="//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title') and @text='Sign out']")
	public MobileElement SIGN_OUT;
	
	
}
