package app.freecharge.pageobjects;


import app.freecharge.androiddriver.DriverInitialization;


public class Register extends DriverInitialization{		
	
	public Register() {
		super();
	}
	
	public void registerClick()
	{
		driver.findElementByName("REGISTER").click();
	}
	
}
