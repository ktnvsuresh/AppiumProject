package app.freecharge.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;

public class HomePage extends DriverInitialization{		

	public HomePage() {
		super();
	}

	@Override
	public void accountDetails(){

		//clickButton(ByLocator.id, "com.freecharge.android:id/action_bar_title");
		driver.findElement(By.id("com.freecharge.android:id/action_bar_title")).click();
		driver.scrollTo("Addresses");
		driver.findElementByName("Addresses").click();

	}

	@Override
	public void addAddress(){
		try{
			typeEditBox(ByLocator.id, "com.freecharge.android:id/address_name", "K. Suresh");
			typeEditBox(ByLocator.id, "com.freecharge.android:id/address_address","2-3-754/5/1");
			typeEditBox(ByLocator.id, "com.freecharge.android:id/address_city_spinner","Hydeerabad");
			dropDown_Select("com.freecharge.android:id/address_state_spinner","Telangana");
			typeEditBox(ByLocator.id, "com.freecharge.android:id/address_postal_code","500013");
			typeEditBox(ByLocator.id, "com.freecharge.android:id/address_mobile_number","9177306662");
			select_CheckBox("com.freecharge.android:id/home_checkbox");
			clickButton(ByLocator.id, "com.freecharge.android:id/add_new_submit_button");
		}
		catch(Exception e){
			logger.error(e);
		}
	}
}
