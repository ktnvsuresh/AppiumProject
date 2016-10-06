package app.freecharge.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductDetailsPageObjects {

	
	@AndroidFindBy (name ="Shopping")
	public MobileElement SHOPPING;
	
	@AndroidFindBy (xpath ="//android.widget.ImageButton")
	public MobileElement IMAGE_BUTTON;
	
	
	@AndroidFindBy(xpath = "//android.view.View[@index = '1']")
	public MobileElement Product_INDEX_1;

	@AndroidFindBy(xpath = "//android.view.View[@index = '2']")
	public MobileElement Product_INDEX_2;

	@AndroidFindBy(xpath = "//android.view.View[@index = '3']")
	public MobileElement Product_INDEX_3;

	@AndroidFindBy(xpath = "//android.view.View[@index = '4']")
	public MobileElement Product_INDEX_4;
}
