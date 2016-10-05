package app.freecharge.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.thoughtworks.selenium.webdriven.commands.GetElementPositionLeft;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class ProfilePage extends DriverInitialization{		


	public ProfilePage(){
		super();

	}

	Logger logger=Logger.getLogger(ProfilePage.class);
	public void profileClick() throws InterruptedException
	{
		driver.findElement(By.xpath(elementprop.getProperty("PROFILE_LINK")) ).click();
		Thread.sleep(5000);
	}

	@Override
	public void myAccountDetails() throws InterruptedException{

		profileClick();
		driver.scrollTo(elementprop.getProperty("MY_ACCOUNT_DETAILS"));
		// Click on My account details.
		driver.findElement(By.name(elementprop.getProperty("MY_ACCOUNT_DETAILS"))).click();
		Thread.sleep(5000);
		result = null;
		result = driver.findElement(By.xpath(elementprop.getProperty("ACCOUNT_DETAILS_LINK"))).getText();
		assert result.equals("Account Details"):"Expected value: Account Details:" + result;
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		logger.info("Back button functioned");
		logger.info("My Account Details screen validation completed");
	}

	@Override
	public void viewTransactionHistory() throws InterruptedException{
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		profileClick();
		driver.scrollTo(elementprop.getProperty("VIEW_TRANSACTIONS_HISTORY_LINK"));
		// Click on View transaction history.
		driver.findElement(By.name(elementprop.getProperty("VIEW_TRANSACTIONS_HISTORY_LINK"))).click();
		Thread.sleep(5000);
		result = null;
		result = driver.findElement(By.xpath(elementprop.getProperty("TITLE_TRANSACTIONS"))).getText();
		assert result.equals("Transactions"):"Expected value: Transactions:" + result;
		driver.findElementByClassName("android.widget.ImageButton").click();
		logger.info("View Transaction History screen validation completed");
	}

	@Override
	public void addAddress() throws InterruptedException{
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		profileClick();
		driver.scrollTo(elementprop.getProperty("MY_ACCOUNT_DETAILS"));
		// Click on My account details.
		driver.findElement(By.name(elementprop.getProperty("MY_ACCOUNT_DETAILS"))).click();
		// Click on Addresses.
		driver.scrollTo(elementprop.getProperty("ADDRESSES"));
		driver.findElementByName(elementprop.getProperty("ADDRESSES")).click();
		result = null;
		result = driver.findElement(By.xpath(elementprop.getProperty("TITLE_ADDRESSES"))).getText();
		logger.info(result);

		if (result.equals("Add address")){
			addAddresses();
			assert result.equals("Add address"):"Expected value: Add address:" + result;
		}

		else{
			deleteAddress();
			addAddresses();
			assert result.equals("Addresses"):"Expected value: Addresses:" + result;
		}
	}

	public void deleteAddress(){
		try{

			if ( driver.findElement(By.xpath(elementprop.getProperty("DELETE_BUTTON"))).isDisplayed()== true){
				driver.findElement(By.xpath(elementprop.getProperty("DELETE_BUTTON"))).click();
				driver.findElement(By.xpath(elementprop.getProperty("DELETE_YES_BUTTON"))).click();
			}
			else
			{
				logger.info("Address not added in Addresses");
				addAddress();
			}

		}
		catch (Exception e) {
			logger.info("Address not Added in Addresses");
			//logger.error(e);
		}

	}

	public void addAddresses(){
		try{
			typeEditBox(ByLocator.id, elementprop.getProperty("ADDRESS_NAME"), "K Suresh");
			typeEditBox(ByLocator.id, elementprop.getProperty("ADDRESS_ADDRESS"),"2-3-754/5/1");
			typeEditBox(ByLocator.id, elementprop.getProperty("ADDRESS_CITY"),"Hyderabad");
			dropDown_Select(elementprop.getProperty("STATE"),"Telangana");
			driver.hideKeyboard();
			typeEditBox(ByLocator.id, elementprop.getProperty("ADDRESS_POSTAL_CODE"),"500013");
			driver.hideKeyboard();
			typeEditBox(ByLocator.id, elementprop.getProperty("ADDRESS_MOBILE_NUMBER"),"9177306662");
			driver.hideKeyboard();
			//select_CheckBox(elementprop.getProperty("HOME_CHECKBOX"));
			Thread.sleep(5000);
			clickButton(ByLocator.id, elementprop.getProperty("ADDRESS_SUBMIT_BUTTON"));
			logger.info("Address added Successfully");
			Thread.sleep(10000);
			driver.sendKeyEvent(AndroidKeyCode.BACK);
		}
		catch(Exception e){
			logger.error(e);
		}
	}


}
