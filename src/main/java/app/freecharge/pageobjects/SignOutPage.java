package app.freecharge.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import app.freecharge.androiddriver.DriverInitialization;


public class SignOutPage  extends DriverInitialization{		

	public SignOutPage() {
		super();
	}

	public MainActivityPage mpage = null;

	public void Logout() throws InterruptedException{

		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title_text') and @text='More']")).click();
		//mpage.signOut();
		result = null;
		result = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title_text') and @text='More']")).getText();
		assert result.equals("More"):"Expected value: More:" + result;
		driver.scrollTo("Sign out");
		driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/title') and @text='Sign out']") ).click();
	}
	
}
