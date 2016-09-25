package app.freecharge.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ScreenshotUtility;
import app.freecharge.pageobjects.HomePage;
import app.freecharge.pageobjects.MainActivityPage;
import app.freecharge.pageobjects.NetworkConnectionsPage;
import app.freecharge.pageobjects.ProductDetailsPage;
import app.freecharge.pageobjects.ProfilePage;
import app.freecharge.pageobjects.RegisterationPage;
import app.freecharge.pageobjects.ResetPasswordPage;
import app.freecharge.pageobjects.SignInPage;
import app.freecharge.pageobjects.SignOutPage;

@Listeners({ ScreenshotUtility.class })
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
	public  NetworkConnectionsPage networkPage = null;
	public ProductDetailsPage productDetailspage = null;

	public ProfilePage profilePage = null;

	@BeforeSuite
	public void setup(){

		mpage = new MainActivityPage();
		reg=new RegisterationPage();
		//appActions = new AppiumStartAndStop();
		signIn = new SignInPage();
		signOut = new SignOutPage();
		homePage = new HomePage();
		profilePage = new ProfilePage();
		networkPage = new NetworkConnectionsPage();
		productDetailspage = new ProductDetailsPage();
	}

	@Test
	public void testCMD() throws IOException, InterruptedException
	{

		/*p=Runtime.getRuntime().exec(cmd);
		if(p!=null)	{
			System.out.println("App installed");
		}*/

		Thread.sleep(500);
		// Registration page tests
		/*reg.registerClick();
		reg.registration();*/

		//SignIn page Tests

		//signIn.Login();
		//signOut.Logout();
		// Forgot Password Tests
		//signIn.ForgotPassword();
		//homePage.accountDetails();
		//homePage.addAddress();

		//profilePage.profileClick();
		//profilePage.accountDetails();

		//signIn.FaceBookLogin();
		//signOut.Logout();
		//signIn.GoogleLogin();
		//profilePage.profileClick();
		//profilePage.myAccountDetails();
		//profilePage.addAddress();
		//profilePage.viewTransactionHistory();
		//signOut.Logout();

		productDetailspage.productdetails();
	}
	@AfterTest
	public void closeConnections()
	{
		mpage.quit();

	}

}
