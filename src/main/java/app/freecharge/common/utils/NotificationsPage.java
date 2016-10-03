package app.freecharge.common.utils;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.pageobjects.SignOutPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class NotificationsPage extends DriverInitialization{		

	public NotificationsPage() {
		super();
	}
	
	Logger logger=Logger.getLogger(NotificationsPage.class);
	
	@Override
	public void Notifications() throws Exception{
		//open notification
		driver.openNotifications();
		Thread.sleep(1); //wait while notifications are playing animation to appear to avoid missed taps
		NativeNotificationPage nativeNotificationPage = new NativeNotificationPage(driver);
		Boolean result;
		result = nativeNotificationPage.isNativeNotificationPage();
			
		//assertTrue("Native notification page is NOT loaded", nativeNotificationPage.isNativeNotificationPage());
		assert result.equals("true"):"Expected value: true:" + result;
		

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
	}
		
		public class NativeNotificationPage extends NotificationsPage {

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
		        super();
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
		}
		


	public boolean isPhone() {
		// TODO Auto-generated method stub
		return false;
	}


	public void setLookTiming(int i) {
		// TODO Auto-generated method stub
		
	}


	public void setDefaultTiming() {
		// TODO Auto-generated method stub
		
	}


	public void setFastLookTiming() {
		// TODO Auto-generated method stub
		
	}
}
