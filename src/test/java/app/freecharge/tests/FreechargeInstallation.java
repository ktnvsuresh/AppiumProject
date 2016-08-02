package app.freecharge.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.AppiumStartAndStop;
import app.freecharge.pageobjects.MainActivityPage;
import app.freecharge.pageobjects.Register;


public class FreechargeInstallation extends DriverInitialization {

	Process p;
	String cmd="adb install D:/Softwares/APPIUM/Sample_apk_files/FreeCharge.apk";


	public Register reg = null;
	public AppiumStartAndStop appActions = null;
	public MainActivityPage mpage = null;

	@BeforeSuite
	public void setup(){
		
		mpage = new MainActivityPage();
		reg=new Register();
		appActions = new AppiumStartAndStop();

	}

	@Test
	public void testCMD() throws IOException, InterruptedException
	{
		
		boolean expected = true;
		
		p=Runtime.getRuntime().exec(cmd);
		if(p!=null)	{
			System.out.println("App installed");
		}

		Thread.sleep(10000);
		//Assert.assertEquals(mpage.openApp(), expected);
		
		
		reg.registerClick();
		//driver.findElementByName("REGISTER").click();

	}
	@AfterTest
	public void closeConnections()
	{
		mpage.quit();
	}

}
