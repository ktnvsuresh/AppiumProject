/**
 * 
 */
package app.freecharge.androiddriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import app.freecharge.common.utils.ByLocator;
import app.freecharge.pageobjects.PopupCloseObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.apache.log4j.Logger;

/**
 * @author suresh.kowtharapu
 *
 */
public class DriverInitialization {

	public static AppiumDriver<MobileElement> driver;

	public static boolean isdriverinitialized;
	public static Logger logger = Logger.getLogger(DriverInitialization.class);
	public String result =null;	
	public Process p,p1;
	public String cmd="adb install D:/Softwares/APPIUM/Sample_apk_files/FreeCharge.apk";
	public String nodePath = "C:/Appium/node.exe"; // Set path of your node.exe file.
	// Set path of your appium.js file.
	public String appiumJSPath = "C:/Appium/node_modules/appium/bin/appium.js";
	public String cmd1 = nodePath + " " + appiumJSPath;
	public String OTPValue=null;

	/*protected static Properties elementprop;
	static {
		loadElementLocators();
	}*/

	public DriverInitialization(){
		initElements();
	}

	public void initElements() {
		if(!isdriverinitialized)
			initializeDriver();
	}

	public void initializeDriver() {

		DesiredCapabilities caps=new DesiredCapabilities();

		try{

			caps.setCapability("deviceName", "emulator-5554");
			//caps.setCapability("deviceName", "acd2ccd3");
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "6.1");
			caps.setCapability("appPackage", "com.freecharge.android");
			caps.setCapability("appActivity", "com.freecharge.ui.MainSplashActivity");
			/*	if (!restApplication)
				caps.setCapability("noReset", true);*/
			driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			isdriverinitialized=true;
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.id("action_bar_title"))).build().perform();
		}catch(Exception e){

		}
	}

	// This method Is responsible for starting appium server.
	public void appiumStart() throws IOException, InterruptedException {
		// Execute command string to start appium server.
		p1 = Runtime.getRuntime().exec(cmd1);
		Thread.sleep(10000);
		if (p1 != null) {
			System.out.println("Appium server Is started now.");
			logger.info("Appium server Is started now.");
		}
	}

	// This method Is responsible for stopping appium server.
	public void appiumStop() throws IOException, InterruptedException {
		if (p1 != null) {
			p1.destroy();
		}
		System.out.println("Appium server Is stopped now.");
		logger.info("Appium server Is stopped now.");
		Thread.sleep(10000);
	}


	public void appInstallation() throws IOException
	{

		p=Runtime.getRuntime().exec(cmd);
		if(p!=null)
		{
			System.out.println("App installed");
			logger.info("App installed");
		}
	}

	/*public static void loadElementLocators(){
		elementprop = new Properties();
		String workingDir = System.getProperty("user.dir");
		logger.info(workingDir);
		File f = new File(workingDir + "//src//main//java//app//freecharge//pageobjects//Freecharge_ElementLocators.properties");

		if( f.exists()){
			logger.info(f.getName() + " is exist !");
			try {
				elementprop.load(new FileInputStream(f));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			logger.info(f.getName() + " not found!!!");
		}
	}*/


	public static void typeEditBox(ByLocator locatorType,String locator, String value)
	{
		driver.findElement(By.id(locator)).clear();	
		if(driver.findElement(By.id(locator))!=null)
		{
			switch (locatorType) {

			case id:
				driver.findElement(By.id(locator)).sendKeys(value);
				break;
			case name:
				driver.findElement(By.id(locator)).sendKeys(value);
				break;
			default:
				System.out.println("Please provide valid locator");
				logger.info("Please provide valid locator");
				break;
			}
		}

		else
			logger.error("Failed to find edit box with Locator: "+driver.findElement(By.id(locator)));
		return;
	}


	public static void clickButton(ByLocator locatorType, String locator)
	{
		if(driver.findElement(By.id(locator))!=null)
		{
			switch (locatorType) {
			case id:
				driver.findElement(By.id(locator)).click();
				break;
			case name:
				driver.findElement(By.name(locator)).click();
				break;

			default:
				System.out.println("Please provide valid button name");
				logger.info("Please provide valid button name");
				break;
			}
		}
		else
		{
			logger.error("Failed to find button with Locator: "+driver.findElement(By.id(locator)));
			return;
		}
	}

	public void clickLink(String linktext){
		if(driver.findElementByLinkText(linktext)!=null)
			driver.findElementByLinkText(linktext).click();
	}

	public void select_CheckBox(String locator){
		WebElement checkBox= driver.findElement(By.id(locator));
		try {
			if (checkBox.isSelected()) {
				logger.info("Checkbox: " + checkBox + "is already selected");
			} else {
				// Select the checkbox
				checkBox.click();
			}
		}
		catch (Exception e) {
			logger.error("Unable to select the checkbox: " + checkBox);
		}
	}

	public void deSelect_CheckBox(String locator){
		WebElement checkBox= driver.findElement(By.id(locator));
		try {
			if (checkBox.isSelected()) {
				checkBox.click();

			} else {
				// Select the checkbox
				logger.info("Checkbox: " + checkBox + "is already deselected");
			}
		}
		catch (Exception e) {
			logger.error("Unable to deselect the checkbox: " + checkBox);
		}
	}

	public void radioButton(String locator){
		WebElement radioButton= driver.findElementByName((locator));
		try {
			radioButton.click();
		}
		catch (Exception e) {
			logger.error("Unable to select the Radiobutton: " + radioButton);
		}
	}
	public void dropDown_Select(String locator, String value){
		if(locator!=null){
			driver.scrollToExact(locator).click();
			driver.scrollTo(value).click();
		}
		else
			logger.error("Failed to find Locator: "+driver.findElement(By.id(locator)));

	}

	PopupCloseObjects popupCloseObjects =new PopupCloseObjects();
	public void popupClose(){
		//if(driver.findElement(By.id("com.freecharge.android:id/frag_web_view"))!=null){
		try{


			if ( popupCloseObjects.IMAGE_CLOSE.isDisplayed() == true || popupCloseObjects.SPLASH_MESSAGE_CLOSE.isDisplayed()== true){
				//if(driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/frag_web_view')]"))!=null){
				popupCloseObjects.SPLASH_MESSAGE_CLOSE.click();;
			}
			else
			{
				logger.info("Popup image is not displayed");
			}

		}
		catch (Exception e) {
			logger.info("Addon's are not displayed");
			//logger.error(e);
		}

	}

	public static void takescreenshot(String filename) throws IOException{
		String outputfile = System.getProperty("user.dir")+"/Screenshots/"+filename;
		logger.info("Taking the screenshot into a file: "+outputfile);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(outputfile));
	}

	public void ForgotPassword() throws InterruptedException, Exception {
		// TODO Auto-generated method stub

	}

	public void FaceBookLogin() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	public void GoogleLogin() throws InterruptedException{
		// TODO Auto-generated method stub

	}
	public void Login() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	public void addAddress() throws InterruptedException{
		// TODO Auto-generated method stub

	}

	public void viewTransactionHistory() throws InterruptedException{
		// TODO Auto-generated method stub

	}

	public void myAccountDetails() throws InterruptedException{
		// TODO Auto-generated method stub

	}

	public void Logout() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	public void signOut() {
		// TODO Auto-generated method stub

	}

	public void quit() {
		// TODO Auto-generated method stub

	}

	public void resetPassword() {
		// TODO Auto-generated method stub

	}

	public void enableInterNet(boolean isEnabled) {
		// TODO Auto-generated method stub

	}


	public void networkConnections() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	public void productdetails() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	public void horizontalScroll() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	public void Login_WithOutNetwork() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	public void registration() {
		// TODO Auto-generated method stub

	}

	public void switchToWebUI() throws InterruptedException{
		// TODO Auto-generated method stub

	}

	public String Notifications() throws Exception {
		return OTPValue;
		// TODO Auto-generated method stub

	}

	public void ClearAllNotifications()  {
		// TODO Auto-generated method stub

	}

	public void InvalidLogin() throws InterruptedException {
		// TODO Auto-generated method stub

	}
}
