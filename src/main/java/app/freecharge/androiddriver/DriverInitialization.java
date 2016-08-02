/**
 * 
 */
package app.freecharge.androiddriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author suresh.kowtharapu
 *
 */
public class DriverInitialization {

	public static AndroidDriver driver;
	private static boolean isdriverinitialized;
	
	
	public DriverInitialization(){
		initElements();
	}
	
	public void initElements(){
		if(!isdriverinitialized)
			initializeDriver();
	}
	
	public void initializeDriver(){

		DesiredCapabilities caps=new DesiredCapabilities();
		try{

			caps.setCapability("deviceName", "emulator-5554");
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "6.1");
			caps.setCapability("appPackage", "com.freecharge.android");
			caps.setCapability("appActivity", "com.freecharge.ui.MainSplashActivity");
			driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			isdriverinitialized=true;
		}catch(Exception e){
			
		}
	}

	


}
