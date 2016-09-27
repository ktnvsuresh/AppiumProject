package app.freecharge.pageobjects;


import org.openqa.selenium.By;
import app.freecharge.androiddriver.DriverInitialization;
import app.freecharge.common.utils.ByLocator;

public class SignInPage extends DriverInitialization{		

	public SignInPage(){
		super();
	}

	public ResetPasswordPage resetPassword = null;
	public NetworkConnectionsPage networkPage = null;

	@Override
	public void Login() throws InterruptedException
	{
		typeEditBox(ByLocator.id,"com.freecharge.android:id/email_edit_text", "9177306662");
		typeEditBox(ByLocator.id,"com.freecharge.android:id/password_edit_text", "kowtha");
		clickButton(ByLocator.id, "com.freecharge.android:id/login_button");
		Thread.sleep(10000);
		result = null;
		result = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/action_bar_title') and @text='Suresh']")).getText();
		assert result.equals("Suresh"):"Expected value: Suresh:" + result;
		//popupClose();
	}

	@Override
	public void ForgotPassword() throws InterruptedException
	{

		clickButton(ByLocator.id, "com.freecharge.android:id/signin_forgot_password");
		typeEditBox(ByLocator.id, "com.freecharge.android:id/forgot_pwd_email_box", "ramyamca1@gmail.com");
		clickButton(ByLocator.id, "com.freecharge.android:id/forgot_pwd_submit");
		//clickButton(ByLocator.id, "com.freecharge.android:id/rememeber_login");
		Thread.sleep(5000);
		typeEditBox(ByLocator.id,"com.freecharge.android:id/forgot_enter_pwd_box", "xxxxxxxxx");
		typeEditBox(ByLocator.id,"com.freecharge.android:id/forgot_reenter_pwd_box", "xxxxxxxxx");
		driver.hideKeyboard();
		clickButton(ByLocator.id, "com.freecharge.android:id/forgot_reset_submit");
		result = null;
		result = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/reset_pwd_err') and @text='Password must contain at least one digit and atleast one alphabet']")).getText();
		assert result.equals("Password must contain at least one digit and atleast one alphabet"):"Expected value: password confirmPassword mismatch:" + result;
	}

	@Override
	public void FaceBookLogin() throws InterruptedException
	{
		clickButton(ByLocator.id, "com.freecharge.android:id/facebook_signin_btn");
		Thread.sleep(10000);
		//popupClose();
		result = null;
		result = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/action_bar_title') and @text='Ramya Suresh']")).getText();
		assert result.equals("Ramya Suresh"):"Expected value: Ramya Suresh:" + result;
		

	}

	@Override
	public void GoogleLogin() throws InterruptedException
	{
		//networkPage.networkConnections();
		clickButton(ByLocator.id, "com.freecharge.android:id/google_signin_btn");
		radioButton("ramyamca1@gmail.com");
		driver.findElement(By.name("OK")).click();
		Thread.sleep(10000);
		//popupClose();
		result = null;
		result = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.freecharge.android:id/action_bar_title') and @text='Ramya Suresh']")).getText();
		assert result.equals("Ramya Suresh"):"Expected value: Ramya Suresh:" + result;

	}
}
