package app.freecharge.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.pageobjects.MorePageObjects;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class SignOutPage extends DriverInitialization{		

	MorePageObjects morePageObjects = new  MorePageObjects();
	public SignOutPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver),
				morePageObjects);
	}


	Logger logger=Logger.getLogger(SignOutPage.class);
	@Override
	public void Logout() throws InterruptedException{

		morePageObjects.MORE_LINK.click();
		result = null;
		result =morePageObjects.MORE_LINK.getText();
		assert result.equals("More"):"Expected value: More:" + result;
		driver.scrollTo("Sign out");
		morePageObjects.SIGN_OUT.click();
		logger.info("User Successfully LoggedOut");
	}

}
