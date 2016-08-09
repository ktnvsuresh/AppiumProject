package app.freecharge.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;

public class HomePage extends DriverInitialization{		

	public HomePage() {
		super();
	}

	@Override
	public void accountDetails(){

		//clickButton(ByLocator.id, "com.freecharge.android:id/action_bar_title");
		driver.findElement(By.id("action_bar_title")).click();
		driver.scrollTo("Addresses");
		driver.findElementByName("Addresses").click();

	}

	@Override
	public void addAddress(){
		try{
			typeEditBox(ByLocator.id, "address_name", "K Suresh");
			typeEditBox(ByLocator.id, "address_address","2-3-754/5/1");
			typeEditBox(ByLocator.id, "address_city_spinner","Hyderabad");
			dropDown_Select("State","Telangana");
			typeEditBox(ByLocator.id, "address_postal_code","500013");
			typeEditBox(ByLocator.id, "address_mobile_number","9177306662");
			select_CheckBox("home_checkbox");
			driver.hideKeyboard();
			clickButton(ByLocator.id, "add_new_submit_button");
			System.out.println("Submit button functioned");
			Thread.sleep(10000);
		}
		catch(Exception e){
			logger.error(e);
		}
	}
}
