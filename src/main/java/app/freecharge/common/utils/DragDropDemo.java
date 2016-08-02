package app.freecharge.common.utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.android.AndroidDriver;

public class DragDropDemo {
	//4200724bfc298203
	String appiumjs="C:/Progra~2/Appium/node_modules/appium/bin/appium.js";
	String nodeexe="C:/Progra~2/Appium/node.exe";
	String cmd = nodeexe +" "+ appiumjs;
	Process p;
//	Process p;
//	 // Set path of your node.exe file.
//	 // Progra~1 represents Program Files folder.
//	 String nodePath = "C:/Progra~2/Appium/node.exe";
//	 // Set path of your appium.js file.
//	 String appiumJSPath = "C:/Progra~2/Appium/node_modules/appium/bin/appium.js";
//	 String cmd = nodePath + " " + appiumJSPath;
//	 AndroidDriver driver;

	public void startAppium() throws IOException, InterruptedException
	{
		p=Runtime.getRuntime().exec(cmd);
		Thread.sleep(10000);
		if(p!=null)
		{
			System.out.println("Appium Server Started now");;
		}
	}
	public void stopAppium() throws IOException, InterruptedException
	{
		if(p!=null)
		{
			System.out.println("Appium Server stoping now");
			p.destroy();
		}
	}
	AndroidDriver driver=null;
	@BeforeTest
	public void setUp() throws IOException, InterruptedException{
		startAppium();
		File app=new File("C:/Users/Shiva/AppData/Local/Android/sdk/platform-tools/com.mobeta.android.demodslv-0.5.0-3_APKdot.com.apk");
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("deviceName", "4200724bfc298203");
		caps.setCapability("platformversion", "5.1.1");
		caps.setCapability("platformname", "android");
		caps.setCapability("app",app.getAbsolutePath());
		caps.setCapability("apppackage", "com.mobeta.android.demodslv");
		caps.setCapability("appactivity", "com.mobeta.android.demodslv.Launcher");
		driver=new AndroidDriver((new URL("http://127.0.0.1:4723/wd/hub")), caps);
		WebDriverWait wait=new WebDriverWait(driver, 10);
	}
	@Test
	public void runAppium()
	{

	}
	@AfterTest
	public void quitConnections() throws IOException, InterruptedException
	{
		stopAppium();
		driver.quit();
	}
}
