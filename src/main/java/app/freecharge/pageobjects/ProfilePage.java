package app.freecharge.pageobjects;

import org.openqa.selenium.By;
import org.testng.ITestListener;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;

public class ProfilePage extends DriverInitialization{		

	public ProfilePage() {
		super();

	}


	public void profileClick()
	{
		driver.findElementByName("Profile").click();
	}

	@Override
	public void myAccountDetails(){

		driver.scrollTo("My account details");
		// Click on My account details.
		driver.findElement(By.name("My account details")).click();

	}

	@Override
	public void viewTransactionHistory(){
		driver.scrollTo("View transaction history");
		// Click on View transaction history.
		driver.findElement(By.name("View transaction history")).click();

	}


}
