package app.freecharge.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PopupCloseObjects {


	@AndroidFindBy(xpath ="//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/frag_web_view')]")
	public MobileElement SPLASH_MESSAGE;


	@AndroidFindBy(id ="com.freecharge.android:id/splash_message_close")
	public MobileElement SPLASH_MESSAGE_CLOSE;


	@AndroidFindBy(xpath ="//android.widget.Image")
	public MobileElement IMAGE_CLOSE;

}
