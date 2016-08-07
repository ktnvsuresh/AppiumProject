package app.freecharge.common.utils;

import org.openqa.selenium.support.FindBy;

import app.freecharge.androiddriver.DriverInitialization;
import io.appium.java_client.android.AndroidDriver;

public class NotificationsPage  extends DriverInitialization{		

	public NotificationsPage() {
		super();
	}
	
	
	public void Notifications(){
	//open notification
	driver.openNotifications();
	sleep(1); //wait while notifications are playing animation to appear to avoid missed taps
	nativeNotificationPage = new NativeNotificationPage(driver);
	assertTrue("Native notification page is NOT loaded", nativeNotificationPage.isNativeNotificationPage());

	int itemsListSize = nativeNotificationPage.getLastItemsContentSize();

	String title, text;
	int notificationItemNum = 0;
	for (int i = 0; i <= itemsListSize; i++) {
	    title = nativeNotificationPage.getItemTitle(i);
	    text = nativeNotificationPage.getItemText(i);
	    System.out.println("   notification title is: " + title);
	    System.out.println("   notification text is: " + text);
	    if (title.equals("SOME_TEXT")) {
	        notificationItemNum = i;
	        break;
	    }
	}

	messagesPage = nativeNotificationPage.tapItemTitle(notificationItemNum); //messagesPage = our client messages screen

	public void sleep(int sec) {
	    try{Thread.sleep(sec*1000);}catch(Exception e){}
	}

	public class NativeNotificationPage extends Page {

	    @FindBy(id = "com.android.systemui:id/notification_panel")
	    private List<WebElement> notificationPanel;
	    //settings data
	    @FindBy(id = "com.android.systemui:id/clear_all_button")
	    private List<WebElement> clearAllBtn;
	    //last items
	    @FindBy(id = "com.android.systemui:id/latestItems")
	    private List<WebElement> lastItemsContainer;
	    //events data
	    @FindBy(id = "android:id/status_bar_latest_event_content")
	    private List<WebElement> lastItemsContent;
	    @FindBy(id = "android:id/title")
	    private List<WebElement> itemTitle;
	    String itemTitle_Locator_Text = "android:id/title";
	    @FindBys({
	            @FindBy (id = "android:id/big_text"),
	            @FindBy (id = "android:id/text")
	    })
	    private List<WebElement> itemText;
	    String itemText_Phone_Locator_Text = "android:id/text";
	    String itemText_Tablet_Locator_Text = "android:id/big_text";
	    @FindBy(id = "android:id/time")
	    private List<WebElement> itemTime;


	    public NativeNotificationPage(AndroidDriver driver) {
	        super(driver);
	    }

	    public boolean isNativeNotificationPage() throws Exception {
	        boolean bool;
	        setFastLookTiming();
	        bool = !notificationPanel.isEmpty();
	        setDefaultTiming();
	        return bool;
	    }

	    public boolean isClearAllBtnLoaded() {
	        boolean bool;
	        setLookTiming(3);
	        bool = !clearAllBtn.isEmpty();
	        setDefaultTiming();
	        return bool;
	    }

	    public int getLastItemsContentSize() {return lastItemsContent.size();}

	    public String getItemTitle(int num) {return lastItemsContent.get(num).findElement(By.id(itemTitle_Locator_Text)).getText();}

	    public String getItemText(int num) {
	        //System.out.println(lastItemsContent.get(num).findElements(MobileBy.className("android.widget.TextView")).size());
	        if (isPhone())
	            return lastItemsContent.get(num).findElements(MobileBy.className("android.widget.TextView")).get(2).getText();
	        else {
	            setLookTiming(3);
	            if (lastItemsContent.get(num).findElements(MobileBy.id(itemText_Tablet_Locator_Text)).isEmpty()) {
	                setDefaultTiming();
	                return lastItemsContent.get(num).findElement(MobileBy.id(itemText_Phone_Locator_Text)).getText();
	            } else {
	                setDefaultTiming();
	                return lastItemsContent.get(num).findElement(MobileBy.id(itemText_Tablet_Locator_Text)).getText();
	            }
	        }
	    }

	    public void tapClearAllBtn() {tapElement(clearAllBtn.get(0));}

	    public MessagesPage tapLastItemsContent(int num) {
	        tapElement(lastItemsContainer.get(num));
	        return new MessagesPage(driver);
	    }

	    public MessagesPage tapItemTitle(int num) {
	        tapElement(lastItemsContent.get(num));
	        return new MessagesPage(driver);
	    }
	}
}
