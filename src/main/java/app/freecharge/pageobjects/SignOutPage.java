package app.freecharge.pageobjects;

import app.freecharge.androiddriver.DriverInitialization;


public class SignOutPage  extends DriverInitialization{		

	public SignOutPage() {
		super();
	}

	public MainActivityPage mpage = null;

	public void Logout() throws InterruptedException{

		//driver.findElementByClassName("android.widget.ImageButton").click();
		//clickLink("More");
		driver.findElementById("com.freecharge.android:id/action_bar_title").click();
		mpage.signOut();
	}
}
