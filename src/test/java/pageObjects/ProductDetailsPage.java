package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {
	
	WebDriver driver;

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='product-information']/h2")
	private WebElement ProductInfo_ProductName;
	
	@FindBy(xpath="//div[@class='product-information']/p[1]")
	private WebElement ProductInfo_CategoryLabelTxt;
	
	@FindBy(xpath="//div[@class='product-information']/p[2]")
	private WebElement ProductInfo_AvailablityLabelTxt;
	
	@FindBy(xpath="//div[@class='product-information']/p[3]")
	private WebElement ProductInfo_ConditionLabelTxt;
	
	@FindBy(xpath="//div[@class='product-information']/p[4]")
	private WebElement ProductInfo_BrandLabelTxt;
	
	@FindBy(xpath="//div[@class='product-information']/span/span")
	private WebElement ProductInfo_PriceTxt;
	
	@FindBy(xpath="//input[@id='quantity']")
	private WebElement QuantityTxt;
	
	@FindBy(xpath="//button[@class='btn btn-default cart']")
	private WebElement AddtoCartBtn;
	
	@FindBy(xpath = "//div[@class='modal-content']//div[2]//a[@href='/view_cart']")
	private WebElement ViewCartBtn;
	
	@FindBy(xpath="//table[@id='cart_info_table']//td[@class='cart_description']//a[contains(text(),'Blue Top')]/ancestor::td/following-sibling::td[2]/button")
	private WebElement ProductQuantity;
	
	
	@FindBy(xpath="//a[normalize-space()='Write Your Review']")
	private WebElement WriteReviewLabelTxt;
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement YourNameTxtBox;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement EmailAddTxtBox;
	
	@FindBy(xpath="//textarea[@id='review']")
	private WebElement AddReviewTxtArea;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement SubmitBTN;
	
	//Thank you for your Review message
	
	@FindBy(xpath="//div[@class='alert-success alert']/span")
	private WebElement ThankYouReviewMsg;
	
	
	public String productName() {
		return pageActions.GetText(ProductInfo_ProductName);
	}
	
	public String category() {
		return pageActions.GetText(ProductInfo_CategoryLabelTxt);
	
	}
	
	public String Availability() {
		return pageActions.GetText(ProductInfo_AvailablityLabelTxt);
	}
	
	public String Price() {
		return pageActions.GetText(ProductInfo_PriceTxt);
	}
	
	public String Condition() {
		return pageActions.GetText(ProductInfo_ConditionLabelTxt);
	}
	
	public String Brand() {
		return pageActions.GetText(ProductInfo_BrandLabelTxt);
	}
	
	
	public boolean AllDetailsVisible() {
		
		if(ProductInfo_ProductName.isDisplayed()&&ProductInfo_CategoryLabelTxt.isDisplayed()&&ProductInfo_PriceTxt.isDisplayed()&&ProductInfo_AvailablityLabelTxt.isDisplayed()&&ProductInfo_ConditionLabelTxt.isDisplayed()&&ProductInfo_BrandLabelTxt.isDisplayed()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public void Quantity(String str) {
		 pageActions.enterText(QuantityTxt, str);
	}
	
	public void ClickAddToCart() {
		pageActions.click(AddtoCartBtn);
	}
	
	public void ClickViewCart() {
		pageActions.click(ViewCartBtn);
	}
	
	public String ProductQuantity() {
		return pageActions.GetText(ProductQuantity);
	}
	
	
	public String WriteYourReviewLabel() {
		
		return pageActions.GetText(WriteReviewLabelTxt);
	}
	
	public void EnterYourName(String Name) {
		pageActions.enterText(YourNameTxtBox, Name);
		
	}
	
	public void EnterEmailAddress(String EmailAdd) {
		pageActions.enterText(EmailAddTxtBox, EmailAdd);
		
	}
	
	public void EnterAddReviewArea(String AreaText) {
		pageActions.enterText(AddReviewTxtArea, AreaText);
		
	}
	
	public void ClickSubmitBTN() {
		pageActions.click(SubmitBTN);
	}
	
	public String GetThankYouForReviewMsg() {
		
		return pageActions.GetText(ThankYouReviewMsg);
	}
	
	
	
}
