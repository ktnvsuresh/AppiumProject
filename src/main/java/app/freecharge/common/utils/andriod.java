package app.freecharge.common.utils;


import java.io.File; 
import java.net.MalformedURLException;
import java.net.URL; 
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

import io.appium.java_client.android.AndroidDriver; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class andriod {

	File appDir = new File("d:\\Softwares\\APPIUM");
	WebDriver driver;

	@BeforeClass

	public void Androidsetup() throws MalformedURLException{

		File app = new File(appDir, "loginsignupdemo.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		//mandatory capabilities
		capabilities.setCapability("deviceName","emulator-5554");
		capabilities.setCapability("platformName","Android");

		//other caps
		capabilities.setCapability("app", app.getAbsolutePath());
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		 capabilities.setCapability("browserName", "Android");
		 capabilities.setCapability("platformVersion", "25.1.3");
		 capabilities.setCapability("platformName", "Android");
		 capabilities.setCapability("appPackage", "com.sourcey.materialloginexample");
		 capabilities.setCapability("appActivity", "com.sourcey.materialloginexample");
		  System.out.println("Test Started");
          try{
          	driver.findElement(By.id("com.sourcey.materialloginexample:id/input_email")).sendKeys("test@test.com");
          	driver.findElement(By.id("com.sourcey.materialloginexample:id/input_password")).sendKeys("test");
          	driver.findElement(By.id("com.sourcey.materialloginexample:id/btn_login")).click();
  	        System.out.println("Test Ended");	
          }
          catch(Exception e){
          	e.printStackTrace();
          }

	}
	
	@Test
	
	public void Test1()
	{
	    //com.sourcey.materialloginexample:id/input_email
		//com.sourcey.materialloginexample:id/input_password
		//com.sourcey.materialloginexample:id/btn_login
		   
		 
	        
	}
}


