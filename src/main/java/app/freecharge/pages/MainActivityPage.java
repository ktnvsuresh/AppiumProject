package app.freecharge.pages;

import org.openqa.selenium.By;
import app.freecharge.androiddriver.DriverInitialization;

public class MainActivityPage extends DriverInitialization{

	public MainActivityPage() {
		super();
	}

	public void signOut() {
		driver.scrollTo("Sign out");
		driver.findElement(By.xpath(elementprop.getProperty("SIGN_OUT")) ).click();
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
