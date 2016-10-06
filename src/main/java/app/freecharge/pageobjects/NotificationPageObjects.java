package app.freecharge.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NotificationPageObjects {

	@AndroidFindBy(xpath ="//android.widget.Button[contains(@resource-id,'com.android.systemui:id/dismiss_text') and @package='com.android.systemui']")
	public MobileElement NOTIFICATIONS_CLEAR;

	@AndroidFindBy(xpath ="//android.widget.TextView[contains(@resource-id,'android:id/text2') and @package='com.android.systemui']")
	public MobileElement NOTIFICATION_GET_TEXT;


}
