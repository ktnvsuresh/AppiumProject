package app.freecharge.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import app.freecharge.androiddriver.DriverInitialization;


public class SignOutPage extends DriverInitialization{		

	public SignOutPage() {
		super();
	}

	
	Logger logger=Logger.getLogger(SignOutPage.class);
	@Override
	public void Logout() throws InterruptedException{

		driver.findElement(By.xpath(elementprop.getProperty("MORE_LINK"))).click();
		result = null;
		result = driver.findElement(By.xpath(elementprop.getProperty("MORE_LINK"))).getText();
		assert result.equals("More"):"Expected value: More:" + result;
		driver.scrollTo("Sign out");
		driver.findElement(By.xpath(elementprop.getProperty("SIGN_OUT")) ).click();
		logger.info("User Successfully LoggedOut");
	}
	
}
