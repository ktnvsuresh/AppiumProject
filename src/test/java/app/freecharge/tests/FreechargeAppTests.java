package app.freecharge.tests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.pageobjects.HomePage;
import app.freecharge.pageobjects.MainActivityPage;
import app.freecharge.pageobjects.RegisterationPage;
import app.freecharge.pageobjects.ResetPasswordPage;
import app.freecharge.pageobjects.SignInPage;
import app.freecharge.pageobjects.SignOutPage;


public class FreechargeAppTests extends DriverInitialization {

	Process p;
	String cmd="adb install D:/Softwares/APPIUM/Sample_apk_files/FreeCharge.apk";


	public RegisterationPage reg = null;
	//public AppiumStartAndStop appActions = null;
	public MainActivityPage mpage = null;
	public SignInPage signIn=null;
	public SignOutPage signOut=null;
	public ResetPasswordPage restPassword = null;
	public HomePage homePage = null;

	@BeforeSuite
	public void setup(){

		mpage = new MainActivityPage();
		reg=new RegisterationPage();
		//appActions = new AppiumStartAndStop();
		signIn = new SignInPage();
		signOut = new SignOutPage();
		homePage = new HomePage();

	}

	@Test
	public void testCMD() throws IOException, InterruptedException
	{

		p=Runtime.getRuntime().exec(cmd);
		if(p!=null)	{
			System.out.println("App installed");
		}

		Thread.sleep(10000);
		// Registration page tests
		/*reg.registerClick();
		reg.registration();*/

		//SignIn page Tests

		//signIn.Login();
		//signOut.Logout();
		// Forgot Password Tests
		//signIn.ForgotPassword();
		homePage.accountDetails();
		homePage.addAddress();

	}
	@AfterTest
	public void closeConnections()
	{
		mpage.quit();

	}

}
