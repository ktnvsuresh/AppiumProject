package app.freecharge.tests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.pageobjects.HomePage;
import app.freecharge.pageobjects.MainActivityPage;
import app.freecharge.pageobjects.NetworkConnectionsPage;
import app.freecharge.pageobjects.OffersPage;
import app.freecharge.pageobjects.ProductDetailsPage;
import app.freecharge.pageobjects.ProfilePage;
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
	public  NetworkConnectionsPage networkPage = null;
	public ProductDetailsPage productDetailspage = null;
	public OffersPage offerspage=null;

	public ProfilePage profilePage = null;

	@BeforeSuite
	public void setup() throws IOException, InterruptedException{
		//appiumStop();
		//appiumStart();
		mpage = new MainActivityPage();
		reg=new RegisterationPage();
		//appActions = new AppiumStartAndStop();
		signIn = new SignInPage();
		signOut = new SignOutPage();
		homePage = new HomePage();
		profilePage = new ProfilePage();
		networkPage = new NetworkConnectionsPage();
		productDetailspage = new ProductDetailsPage();
		offerspage = new OffersPage();
	}


	@Test
	public void Test_appInstallation() throws InterruptedException, IOException
	{

		//appInstallation();

	}


	/*@Test
	public void Test_registrationPage() throws IOException, InterruptedException
	{

		Thread.sleep(1000);
		// Registration page tests
		//reg.registerClick();
		reg.registration();
	}

	@Test
	public void Test_LoginPage() throws IOException, InterruptedException
	{
		//SignIn page Tests
		signIn.Login();
		signOut.Logout();
	}

	@Test
	public void Test_forgotPasswordPage() throws IOException, InterruptedException
	{
		// Forgot Password Tests
		signIn.ForgotPassword();
		//homePage.accountDetails();
		//homePage.addAddress();
	}

	@Test
	public void Test_profilePage() throws IOException, InterruptedException
	{	
		profilePage.myAccountDetails();
		profilePage.addAddress();
		profilePage.viewTransactionHistory();
	}

	@Test
	public void Test_facebookLogin() throws IOException, InterruptedException
	{	

		signIn.FaceBookLogin();
		signOut.Logout();
	}

	@Test
	public void Test_gmailLogin() throws IOException, InterruptedException
	{	

		signIn.GoogleLogin();
		signOut.Logout();


	}
	
	@Test
	public void Test_horizontalScroll() throws IOException, InterruptedException
	{	

		signIn.Login();
		offerspage.horizontalScroll();
		homePage.homeClick();
		signOut.Logout();


	}


	@Test
	public void Test_productDetailspage() throws IOException, InterruptedException
	{
		productDetailspage.productdetails();
	}*/

	@Test
	public void Test_networkConnection() throws InterruptedException, IOException
	{

		networkPage.networkConnections();
		
	}
	
	@AfterTest
	public void closeConnections()
	{
		mpage.quit();

	}

}
