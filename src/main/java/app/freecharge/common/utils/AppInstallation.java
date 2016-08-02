package app.freecharge.common.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class AppInstallation {
AndroidDriver driver;
Process p;
String cmd="adb install D:/Softwares/APPIUM/Sample_apk_files/FreeCharge.apk";
public void initConfig() throws MalformedURLException
{
	DesiredCapabilities caps=new DesiredCapabilities();
	caps.setCapability("deviceName", "emulator-5554");
	caps.setCapability("platformName", "Android");
	caps.setCapability("platformVersion", "6.1");
	caps.setCapability("appPackage", "com.freecharge.android");
	caps.setCapability("LaunchActivity", "com.freecharge.android");
	driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}
@BeforeTest
public void setup() throws MalformedURLException
{
	initConfig();
}
@Test
public void testCMD() throws IOException
{
	p=Runtime.getRuntime().exec(cmd);
	if(p!=null)
	{
		System.out.println("App installed");
	}
}
@AfterTest
public void closeConnections()
{
	driver.quit();
}
	
}
