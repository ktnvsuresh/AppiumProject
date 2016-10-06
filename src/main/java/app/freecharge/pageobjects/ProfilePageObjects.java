package app.freecharge.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProfilePageObjects {


	@AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title_text') and @text='Profile']")
	public MobileElement PROFILE_LINK;

	@AndroidFindBy (xpath="//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/action_bar_title') and @text='Account Details']")
	public MobileElement ACCOUNT_DETAILS_LINK; 

	@AndroidFindBy (name ="My account details")
	public MobileElement MY_ACCOUNT_DETAILS;

	@AndroidFindBy (name ="Addresses")
	public MobileElement ADDRESSES;

	@AndroidFindBy (xpath= "//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/action_bar_title') and contains(@text,'Add address') or contains(@text,'Addresses')]")
	public MobileElement TITLE_ADDRESSES; 

	@AndroidFindBy (xpath= "//android.widget.ImageView[contains(@resource-id,'com.freecharge.android:id/dustbin')]")
	public MobileElement DELETE_BUTTON;
	
	@AndroidFindBy (xpath="//android.widget.Button[contains(@resource-id,'android:id/button1') and @text='yes']")
	public MobileElement DELETE_YES_BUTTON; 

	@AndroidFindBy (id = "address_name")
	public MobileElement ADDRESS_NAME;
	
	@AndroidFindBy (id = "address_address")
	public MobileElement ADDRESS_ADDRESS;
	
	@AndroidFindBy (id = "address_city_spinner")
	public MobileElement ADDRESS_CITY;
	
	@AndroidFindBy (id = "State")
	public MobileElement STATE;
	
	@AndroidFindBy (id = "address_postal_code")
	public MobileElement ADDRESS_POSTAL_CODE;
		
	@AndroidFindBy (id = "address_mobile_number")
	public MobileElement ADDRESS_MOBILE_NUMBER;
	
	@AndroidFindBy (id = "com.freecharge.android:id/home_checkbox")
	public MobileElement HOME_CHECKBOX;
	
	@AndroidFindBy (id = "add_new_submit_button")
	public MobileElement ADDRESS_SUBMIT_BUTTON;
	
	@AndroidFindBy (name = "View transaction history")
	public MobileElement VIEW_TRANSACTIONS_HISTORY_LINK;
	
	@AndroidFindBy (xpath="//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/action_bar_title') and @text='Transactions']")
	public MobileElement TITLE_TRANSACTIONS; 
			 

}
