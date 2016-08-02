package app.freecharge.pageobjects;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.android.AndroidDriver;


public class networkConnections

{
	public AppiumDriver driver;
	
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
				
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.1");
		caps.setCapability("appPackage", "com.freecharge.android");
		caps.setCapability("LaunchActivity", "com.freecharge.android");
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		System.out.println(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

		/*
	 * Script for enable and disable the network connections through appium
	 * settings
	 */
	public networkConnections() throws InterruptedException {
		
		// Identify Network status
		NetworkConnectionSetting networkConnection = ((AndroidDriver) driver).getNetworkConnection();
		Boolean status = networkConnection.wifiEnabled();
		System.out.println(status);
		
		// Turn off the WI-fI connection
		if (!equals(status))
		{
			enableInterNet(false);
			Thread.sleep(2000);
			System.out.println("Network connection Disabled");
		}
		// Turn On the WI-FI connection
		enableInterNet(true);
		Thread.sleep(2000);
		System.out.println("Network connection Enabled");
	}

	// Setting the network connections
	public void enableInterNet(boolean isEnabled) {
		NetworkConnectionSetting networkConnection = new NetworkConnectionSetting(false, isEnabled, false);
		((AndroidDriver) driver).setNetworkConnection(networkConnection);
		
	}

	/*// Script for open the notifications
	@Test(priority = 2)
	public void notifications() throws InterruptedException {
		((AndroidDriver) driver).openNotifications();
		Thread.sleep(8000);
		driver.navigate().back();

	}*/
	
	@AfterTest
	public void end() {
		driver.quit();
	}

}
