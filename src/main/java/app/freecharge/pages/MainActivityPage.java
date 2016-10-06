package app.freecharge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.pageobjects.MorePageObjects;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainActivityPage extends DriverInitialization{
	MorePageObjects morePageObjects = new  MorePageObjects();
	public MainActivityPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				morePageObjects);
	}



	public void signOut() {
		//driver.scrollTo("Sign out");
		morePageObjects.SIGN_OUT.click();
	}
	//com.freecharge.android:id/snackbar_text
	//text=Something went wrong and we are sorry for that. Please try again later
	//Please check your login details and try again later
	// text= OK
	//android.widget.TextView

	public void quit(){
		logger.info("inside quit method...");
		driver.quit();
		isdriverinitialized = false;
	}


}
