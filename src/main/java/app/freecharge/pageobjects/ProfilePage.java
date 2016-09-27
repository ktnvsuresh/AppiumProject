package app.freecharge.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class ProfilePage extends DriverInitialization{		


	public ProfilePage(){
		super();

	}


	public void profileClick() throws InterruptedException
	{
		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title_text') and @text='Profile']") ).click();
		Thread.sleep(5000);
	}

	@Override
	public void myAccountDetails() throws InterruptedException{

		profileClick();
		driver.scrollTo("My account details");
		// Click on My account details.
		driver.findElement(By.name("My account details")).click();
		Thread.sleep(5000);
		result = null;
		result = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/action_bar_title') and @text='Account Details']")).getText();
		assert result.equals("Account Details"):"Expected value: Account Details:" + result;
		driver.findElementByClassName("android.widget.ImageButton").click();
		System.out.println("Back button functioned");
		System.out.println("My Account Details screen validation completed");
	}

	@Override
	public void viewTransactionHistory() throws InterruptedException{
		profileClick();
		driver.scrollTo("View transaction history");
		// Click on View transaction history.
		driver.findElement(By.name("View transaction history")).click();
		Thread.sleep(5000);
		result = null;
		result = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/action_bar_title') and @text='Transactions']")).getText();
		assert result.equals("Transactions"):"Expected value: Transactions:" + result;
		driver.findElementByClassName("android.widget.ImageButton").click();
		System.out.println("View Transaction History screen validation completed");
	}

	@Override
	public void addAddress() throws InterruptedException{

		profileClick();
		driver.scrollTo("My account details");
		// Click on My account details.
		driver.findElement(By.name("My account details")).click();
		// Click on Addresses.
		driver.scrollTo("Addresses");
		driver.findElementByName("Addresses").click();
		result = null;
		result = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/action_bar_title') and @text='Add address']")).getText();
		assert result.equals("Add address"):"Expected value: Add address:" + result;

		/*if(driver.findElementByClassName("android.widget.ImageView").isDisplayed())
		{
			driver.findElement(By.xpath("//android.widget.ImageView[contains(@resource-id,'com.freecharge.android:id/dustbin') and @index='1']")).click();
			driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'android:id/button1') and @text='yes']")).click();
		}*/

		try{
			
			typeEditBox(ByLocator.id, "address_name", "K Suresh");
			typeEditBox(ByLocator.id, "address_address","2-3-754/5/1");
			typeEditBox(ByLocator.id, "address_city_spinner","Hyderabad");
			dropDown_Select("State","Telangana");
			driver.hideKeyboard();
			typeEditBox(ByLocator.id, "address_postal_code","500013");
			driver.hideKeyboard();
			typeEditBox(ByLocator.id, "address_mobile_number","9177306662");
			driver.hideKeyboard();
			select_CheckBox("home_checkbox");
			clickButton(ByLocator.id, "add_new_submit_button");
			System.out.println("Address added Successfully");
			Thread.sleep(10000);
			driver.sendKeyEvent(AndroidKeyCode.BACK);
		}
		catch(Exception e){
			logger.error(e);
		}
	}


}
