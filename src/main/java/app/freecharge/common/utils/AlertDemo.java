package app.freecharge.common.utils;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class AlertDemo {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
	AndroidDriver driver;
//	File classpathRoot = new File(System.getProperty("user.dir"));
	  
	  //Set folder name "Apps" where .apk file is stored.
//	  File appDir = new File(classpathRoot, "/app");
	  
	  //Set Drag-Sort Demos .apk file name.  
	//  File app = new File(appDir, "ApiDemos.apk");  
	              
	  // Created object of DesiredCapabilities class.
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  
	  // Set android deviceName desired capability. Set your device name.
	  capabilities.setCapability("deviceName", "android emulator");

	  // Set BROWSER_NAME desired capability. It's Android in our case here.
	  capabilities.setCapability("browserName", "Android");

	  // Set android VERSION desired capability. Set your mobile device's OS version.
	  capabilities.setCapability("platformVersion", "5.1.1");

	  // Set android platformName desired capability. It's Android in our case here.
	  capabilities.setCapability("platformName", "Android");
	  
	  //Set .apk file's path capabilities.
	  capabilities.setCapability("appPackage", "io.appium.android.apis");
	  capabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");
	  // Created object of AndroidDriver and set capabilities.
	  // Set appium server address and port number in URL string.
	  // It will launch Drag-Sort Demos app in emulator.
	  driver = new AndroidDriver(new URL("http://127.0.0.1:"
	  		+ "4723/wd/hub"), capabilities);
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.scrollTo("App");
	  // Click on App.
	  driver.findElement(By.name("App")).click();
	  // Scroll till element which contains "Alert Dialogs" text.
	  driver.scrollTo("Alert Dialogs");
	  // Click on Alert Dialogs.
	  driver.findElement(By.name("Alert Dialogs")).click();
	  // Click on "OK Cancel dialog with a message" button.
	  driver.findElement(By.name("OK Cancel dialog with a message")).click();
	  // Get the text from alert dialog.
	  String result = driver.findElementById("android:id/alertTitle").getText();
	  System.out.println("Alert text Is -> " + result);
	  // Click on OK button of alert dialog.
	  driver.findElement(By.name("OK")).click();
	  // Click on Cancel button of alert dialog.
	  // driver.findElement(By.name("Cancel")).click();
	}

}
