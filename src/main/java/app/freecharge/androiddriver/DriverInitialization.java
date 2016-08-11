/**
 * 
 */
package app.freecharge.androiddriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import app.freecharge.common.utils.ByLocator;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;

/**
 * @author suresh.kowtharapu
 *
 */
public class DriverInitialization {

	public static AndroidDriver driver;
	public static boolean isdriverinitialized;
	public static Logger logger = Logger.getLogger(DriverInitialization.class);


	public DriverInitialization(){
		initElements();
	}

	public void initElements(){
		if(!isdriverinitialized)
			initializeDriver();
		else
			logger.info("App is already opened");
	}

	public void initializeDriver(){

		DesiredCapabilities caps=new DesiredCapabilities();
		try{

			caps.setCapability("deviceName", "emulator-5554");
			//caps.setCapability("deviceName", "acd2ccd3");
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "6.1");
			caps.setCapability("appPackage", "com.freecharge.android");
			caps.setCapability("appActivity", "com.freecharge.ui.MainSplashActivity");
			driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			isdriverinitialized=true;
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.id("action_bar_title"))).build().perform();
		}catch(Exception e){

		}
	}


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
				break;
			}
		}

		else
			logger.error("Failed to find edit box with Locator: "+driver.findElement(By.id(locator)));
		return;
	}


	public static void clickButton(ByLocator locatorType,String locator)
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

	public void dropDown_Select(String locator, String value){
		if(locator!=null){
			driver.scrollToExact(locator).click();
			driver.scrollTo(value).click();
		}
		else
			logger.error("Failed to find Locator: "+driver.findElement(By.id(locator)));

	}

	public void ForgotPassword() {
		// TODO Auto-generated method stub

	}

	public void FaceBookLogin() {
		// TODO Auto-generated method stub

	}

	public void Login() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	public void accountDetails() {
		// TODO Auto-generated method stub

	}

	public void addAddress() {
		// TODO Auto-generated method stub

	}


}
