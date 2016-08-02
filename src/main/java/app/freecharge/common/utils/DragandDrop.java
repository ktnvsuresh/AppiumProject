
package app.freecharge.common.utils;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragandDrop {

AndroidDriver driver;

@BeforeTest
public void Androidsetup() throws MalformedURLException{

//File app = new File(appDir, "loginsignupdemo.apk");
DesiredCapabilities capabilities = new DesiredCapabilities();
File classpathroot = new File(System.getProperty("user.dir"));
File appdir= new File(classpathroot, "//App");
File app= new File(appdir,"com.mobeta.android.demodslv-0.5.0-3_APKdot.com.apk" );

//mandatory capabilities
capabilities.setCapability("deviceName","emulator-5554");
capabilities.setCapability("platformName","Android");

//other caps
capabilities.setCapability("app", app.getAbsolutePath());
capabilities.setCapability("browserName", "Android");
capabilities.setCapability("platformVersion", "5.1.1");
//capabilities.setCapability(CapabilityType.VERSION, "5.1.1");
capabilities.setCapability("platformName", "Android");
capabilities.setCapability("appPackage", "com.mobeta.android.demodslv");
//capabilities.setCapability("appActivity", "com.mobeta.android.demodslv");
capabilities.setCapability("LaunchActivity", "Launcher");
 
 driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
 
 System.out.println("Test Started");
 
}
@Test
public void sampleTest(){
 driver.findElementByName("Warp").click();
 WebElement ele1 = (WebElement) driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(1);
 WebElement ele2 = (WebElement) driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(8);
 TouchAction action = new TouchAction((MobileDriver) driver);
 //action.longPress(ele1).moveTo(ele2).release().perform();  
 action.longPress(ele1).moveTo(ele2, 2, 8).release().perform();
 
}
@AfterTest
	public void quit(){
		driver.quit();
 
	}
}
