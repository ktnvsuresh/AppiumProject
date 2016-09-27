package app.freecharge.pageobjects;

import org.openqa.selenium.By;
import app.freecharge.androiddriver.DriverInitialization;
import io.appium.java_client.android.AndroidKeyCode;

public class ProductDetailsPage extends DriverInitialization {

	public ProductDetailsPage() {
		super();

	}

	@Override
	public void productdetails() throws InterruptedException{
		driver.findElement(By.name("Shopping")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.view.View[@index = '2']")).click();
		System.out.println("Product Details validation completed");
		driver.sendKeyEvent(AndroidKeyCode.BACK);
	}



}
