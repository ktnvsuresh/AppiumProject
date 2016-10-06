package app.freecharge.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OfferPageObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title_text') and @text='Offers']")
	public MobileElement OFFERS_LINK;

	@AndroidFindBy(xpath = "//android.view.View[@index = '1']")
	public MobileElement OFFERS_INDEX_1;

	@AndroidFindBy(xpath = "//android.view.View[@index = '2']")
	public MobileElement OFFERS_INDEX_2;

	@AndroidFindBy(xpath = "//android.view.View[@index = '3']")
	public MobileElement OFFERS_INDEX_3;

	@AndroidFindBy(xpath = "//android.view.View[@index = '4']")
	public MobileElement OFFERS_INDEX_4;

}
