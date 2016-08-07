package app.freecharge.pageobjects;

import app.freecharge.androiddriver.DriverInitialization;

public class MainActivityPage extends DriverInitialization{

	public MainActivityPage() {
		super();
	}

	public void signOut() {
		// TODO Auto-generated method stub
		driver.scrollTo("Sign out");
		driver.findElementByName("Sign out").click();
	}

	public void quit(){
		logger.info("inside quit method...");
		driver.quit();
		isdriverinitialized = false;
	}


}
