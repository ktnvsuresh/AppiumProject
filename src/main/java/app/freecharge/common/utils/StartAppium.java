package app.freecharge.common.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class StartAppium {
	AndroidDriver driver;
	File app=new File("D:/APPIUM/SwipeListView Demo_v1.13_apkpure.com.apk");
	String nodeexe="C:/Progra~2/Appium/node.exe";
	String appiumjs="C:/Progra~2/Appium/node_modules/appium/bin/appium.js";
	String cmd=nodeexe + " " + appiumjs;
	Process p;
	public void startAppium() throws IOException, InterruptedException
	{
		p=Runtime.getRuntime().exec(cmd);
		if(p!=null)
		{
			System.out.println("Appium Server started");
		}
		Thread.sleep(10000);

	}
	public void stopAppium()
	{
		p.destroy();

	}
	@BeforeTest
	public void setConfig() throws IOException, InterruptedException
	{
		startAppium();
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("PlatformName", "Android");
		caps.setCapability("platformVersion", "5.1.1");
		caps.setCapability("app", app.getAbsolutePath());
		caps.setCapability("appPackage", "com.fortysevendeg.android.swipelistview");
		caps.setCapability("appActivity", "com.fortysevendeg.android.swipelistview.sample.activities.SwipeListViewExampleActivity");
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}
	@Test
	public void testApp()
	{

	}
	@AfterTest
	public void quitConnections()
	{
		driver.quit();
		stopAppium();
	}



}
