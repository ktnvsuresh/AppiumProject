package app.freecharge.pageobjects;

import app.freecharge.androiddriver.DriverInitialization;

public class MainActivityPage extends DriverInitialization{

	public MainActivityPage() {
		super();
	}
		
/*	public boolean openApp(){
		boolean stepResult = false;
		
		//driver.findElementById("2").click();
		//driver.findElementByClassName("FreeCharge").click();	
		stepResult = true;
		return stepResult;
		
		
	}*/
	public void quit(){
		driver.quit();
	}
}
