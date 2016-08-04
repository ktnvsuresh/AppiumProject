package app.freecharge.pageobjects;

import app.freecharge.androiddriver.DriverInitialization;

public class SignOutPage  extends DriverInitialization{		

	public SignOutPage() {
		super();
	}
	
	public void Logout() throws InterruptedException{
		
	  driver.findElementByClassName("android.widget.ImageButton").click();
	  driver.scrollTo("Sign out");
	  driver.findElementByName("Sign out").click();
	 }
}
