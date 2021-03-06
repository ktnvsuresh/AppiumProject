package app.freecharge.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;
import app.freecharge.pages.ForgotPasswordPage;
import app.freecharge.pages.HomePage;
import app.freecharge.pages.MainActivityPage;
import app.freecharge.pages.NetworkConnectionsPage;
import app.freecharge.pages.NotificationsPage;
import app.freecharge.pages.OffersPage;
import app.freecharge.pages.ProductDetailsPage;
import app.freecharge.pages.ProfilePage;
import app.freecharge.pages.RegisterationPage;
import app.freecharge.pages.SignInPage;
import app.freecharge.pages.SignOutPage;
import app.freecharge.pages.SwitchToWebUIPage;
import io.appium.java_client.android.AndroidKeyCode;
import org.apache.log4j.*;

public class FreechargeAppTests extends DriverInitialization {

	public FreechargeAppTests() {
		super();
		// TODO Auto-generated constructor stub
	}

	Process p;
	String cmd="adb install D:/Softwares/APPIUM/Sample_apk_files/FreeCharge.apk";


	public RegisterationPage registration = null;
	//public AppiumStartAndStop appActions = null;
	public MainActivityPage mainActivity = null;
	public SignInPage signIn=null;
	public SignOutPage signOut=null;
	public ForgotPasswordPage forgotPassword = null;
	public HomePage homePage = null;
	public  NetworkConnectionsPage networkPage = null;
	public ProductDetailsPage productDetailspage = null;
	public OffersPage offerspage=null;
	public SwitchToWebUIPage switchToWebUI=null;
	public ProfilePage profilePage = null;
	public NotificationsPage notificationsPage = null;

	@BeforeSuite
	public void setup() throws IOException, InterruptedException{
		//appiumStop();
		//appiumStart();
		mainActivity = new MainActivityPage();
		registration=new RegisterationPage();
		//appActions = new AppiumStartAndStop();
		signIn = new SignInPage();
		signOut = new SignOutPage();
		homePage = new HomePage();
		profilePage = new ProfilePage();
		networkPage = new NetworkConnectionsPage();
		productDetailspage = new ProductDetailsPage();
		offerspage = new OffersPage();
		forgotPassword = new ForgotPasswordPage();
		switchToWebUI=new SwitchToWebUIPage();
		notificationsPage = new NotificationsPage();
		
	}

	@Test (priority =1)
	public void Test_appInstallation() throws InterruptedException, IOException
	{
		appInstallation();
	}

	@Test (priority =2)
	public void Test_LoginPage() throws IOException, InterruptedException
	{
		//SignIn page Tests
		signIn.Login();
		signOut.Logout();
	}
	
	@Test (priority =3)
	public void Test_InValidLogin() throws IOException, InterruptedException
	{
		//SignIn page Tests
		signIn.InvalidLogin();
		
	}


	@Test (priority =4)
	public void Test_forgotPasswordPage() throws Exception
	{
		// Forgot Password Tests
		forgotPassword.ForgotPassword();
	}

	@Test (priority =5)
	public void Test_profilePage() throws IOException, InterruptedException
	{	
		//Profile page Tests
		signIn.Login();
		profilePage.myAccountDetails();
		profilePage.addAddress();
		profilePage.viewTransactionHistory();
		signOut.Logout();
	}

	@Test (priority =6)
	public void Test_facebookLogin() throws IOException, InterruptedException
	{	//FaceBook Login validation
		signIn.FaceBookLogin();
		signOut.Logout();
	}

	@Test (priority =7)
	public void Test_gmailLogin() throws IOException, InterruptedException
	{	//Google ID login validation
		signIn.GoogleLogin();
		signOut.Logout();
	}

	@Test (priority =8)
	public void Test_horizontalScroll() throws IOException, InterruptedException
	{	//Horizontal Scroll validation
		signIn.Login();
		offerspage.horizontalScroll();
		homePage.homeClick();
		signOut.Logout();
	}


	@Test (priority =9)
	public void Test_productDetailspage() throws IOException, InterruptedException
	{ // Product Details Validation tests
		signIn.Login();
		productDetailspage.productdetails();
		signOut.Logout();
	}

	@Test(priority =10)
	public void Test_SwitchToWebUIPage() throws InterruptedException, IOException
	{ // Switch to Freecharge WEBUI
		signIn.Login();
		switchToWebUI.switchToWebUI();
		signOut.Logout();

	}

	@Test (priority =11)
	public void Test_registrationPage() throws IOException, InterruptedException
	{
		Thread.sleep(1000);
		// Registration page tests
		registration.registration();
	}

	/*@Test (priority =12)
	public void Test_networkConnection() throws InterruptedException, IOException
	{ // Disable Network and try to Login with Google ID and Enable Network
		signIn.Login_WithOutNetwork();
	}
*/

	@AfterTest
	public void closeConnections()
	{
		mainActivity.quit();

	}

}
