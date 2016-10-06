package app.freecharge.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePageObjects {

	@AndroidFindBy (xpath ="//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title_text') and @text='Home']")
	public MobileElement HOME_LINK;

}
