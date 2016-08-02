package app.freecharge.common.utils;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class calcDEMO {

 WebDriver driver;

 @Test
 public void setUp() throws Exception {

 DesiredCapabilities capabilities = new DesiredCapabilities();
 capabilities.setCapability("deviceName", "Android Emulator");
 // capabilities.setCapability("browserName", "Android");
 capabilities.setCapability("platformVersion", "6.1");
 capabilities.setCapability("platformName", "Android");
 capabilities.setCapability("appPackage", "com.android.calculator2");
 capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
 driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 System.out.println("Click Delete ");
 driver.findElement(By.name("delete")).click();
 System.out.println("Click 2 ");
 driver.findElement(By.name("2")).click();
 System.out.println("Click + ");
  driver.findElement(By.name("+")).click();
  System.out.println("Click 5 ");
 driver.findElement(By.name("5")).click();
 System.out.println("Click = ");
 driver.findElement(By.name("=")).click();
 System.out.println("Result is");
 driver.quit();
 }
}