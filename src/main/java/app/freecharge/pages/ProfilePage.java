package app.freecharge.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.selenium.webdriven.commands.GetElementPositionLeft;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;
import app.freecharge.pageobjects.ProfilePageObjects;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilePage extends DriverInitialization{		

	ProfilePageObjects profilePageObjects =new ProfilePageObjects();
	public ProfilePage(){
		super();

		PageFactory.initElements(new AppiumFieldDecorator(driver),
				profilePageObjects);
	}



	Logger logger=Logger.getLogger(ProfilePage.class);
	public void profileClick() throws InterruptedException
	{
		profilePageObjects.PROFILE_LINK.click();
		Thread.sleep(5000);
	}

	@Override
	public void myAccountDetails() throws InterruptedException{

		profileClick();
		//driver.scrollTo(elementprop.getProperty("MY_ACCOUNT_DETAILS"));
		driver.scrollTo("My account details");
		// Click on My account details.
		profilePageObjects.MY_ACCOUNT_DETAILS.click();
		Thread.sleep(5000);
		result = null;
		result = profilePageObjects.ACCOUNT_DETAILS_LINK.getText();
		assert result.equals("Account Details"):"Expected value: Account Details:" + result;
		//driver.sendKeyEvent(AndroidKeyCode.BACK);
		logger.info("Back button functioned");
		logger.info("My Account Details screen validation completed");
	}

	@Override
	public void viewTransactionHistory() throws InterruptedException{
		//driver.sendKeyEvent(AndroidKeyCode.BACK);
		Thread.sleep(5000);
		driver.navigate().back();
		profileClick();
		//driver.scrollTo(elementprop.getProperty("VIEW_TRANSACTIONS_HISTORY_LINK"));
		driver.scrollTo("View transaction history");
		// Click on View transaction history.
		profilePageObjects.VIEW_TRANSACTIONS_HISTORY_LINK.click();
		Thread.sleep(5000);
		result = null;
		result =profilePageObjects.TITLE_TRANSACTIONS.getText();
		assert result.equals("Transactions"):"Expected value: Transactions:" + result;
		driver.findElementByClassName("android.widget.ImageButton").click();
		logger.info("View Transaction History screen validation completed");
	}

	@Override
	public void addAddress() throws InterruptedException{
		//driver.sendKeyEvent(AndroidKeyCode.BACK);
		Thread.sleep(5000);
		driver.navigate().back();
		profileClick();
		//driver.scrollTo(elementprop.getProperty("MY_ACCOUNT_DETAILS"));
		driver.scrollTo("My account details");
		// Click on My account details.
		profilePageObjects.MY_ACCOUNT_DETAILS.click();
		// Click on Addresses.
		//driver.scrollTo(elementprop.getProperty("ADDRESSES"));
		driver.scrollTo("ADDRESSES");
		profilePageObjects.ADDRESSES.click();
		result = null;
		result = profilePageObjects.TITLE_ADDRESSES.getText();
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

			if ( profilePageObjects.DELETE_BUTTON.isDisplayed()== true){
				profilePageObjects.DELETE_BUTTON.click();
				profilePageObjects.DELETE_YES_BUTTON.click();
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
			profilePageObjects.ADDRESS_NAME.sendKeys("K Suresh");
			profilePageObjects.ADDRESS_ADDRESS.sendKeys("2-3-754/5/1");
			profilePageObjects.ADDRESS_CITY.sendKeys("Hyderabad");
			//profilePageObjects.STATE.sendKeys("Telangana");
			dropDown_Select("State","Telangana");
			driver.hideKeyboard();
			profilePageObjects.ADDRESS_POSTAL_CODE.sendKeys("500013");
			driver.hideKeyboard();
			profilePageObjects.ADDRESS_MOBILE_NUMBER.sendKeys("9177306662");
			driver.hideKeyboard();
			//select_CheckBox(elementprop.getProperty("HOME_CHECKBOX"));
			Thread.sleep(5000);
			profilePageObjects.ADDRESS_SUBMIT_BUTTON.click();
			logger.info("Address added Successfully");
			Thread.sleep(10000);
			//driver.sendKeyEvent(AndroidKeyCode.BACK);
			driver.navigate().back();
		}
		catch(Exception e){
			logger.error(e);
		}
	}


}
