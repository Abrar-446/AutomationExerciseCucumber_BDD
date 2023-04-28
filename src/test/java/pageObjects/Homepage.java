package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Homepage extends BasePage {
	
	WebDriver driver;
	
	public Homepage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	private WebElement homeLink;
	
	@FindBy(xpath="//a[contains(text(),'Products')]")
	private WebElement productsLink;
	
	@FindBy(xpath="//a[contains(text(),'Cart')]")
	private WebElement cartLink;
	
	@FindBy(xpath="//a[contains(text(),' Signup / Login')]")
	private WebElement signupLink;
	
	@FindBy(xpath="//a[contains(text(),' Test Cases')]")
	private WebElement TestCasesLink;
	
	@FindBy(xpath="//a[contains(text(),'API Testing')]")
	private WebElement APITestingLink;
	
	@FindBy(xpath="//a[contains(text(),'Video Tutorials')]")
	private WebElement VideoTutLink;
	
	@FindBy(xpath="//a[contains(text(),'Contact us')]")
	private WebElement ContactUsLink;
	
	
	@FindBy(xpath="//input[@id='susbscribe_email']")
	private WebElement emailAddTxt;
	
	
	@FindBy(xpath="//button[@id='subscribe']")
	private WebElement SubscribeBtn;
	
	@FindBy(xpath="//h2[normalize-space()='Subscription']")
	private WebElement SubscribeLabelTxt;
	
	@FindBy(xpath="//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engin')]")
	private WebElement FullFledgeTextInfo;
	
	//div[@class='logo pull-left']//img
	@FindBy(xpath="//div[@class='logo pull-left']//img")
	private WebElement imageicon;
	
	@FindBy(xpath="//div[@class='footer-widget']//div[@class='single-widget']/h2")
	private WebElement Subscriptionlabeltxt;
	
	//success msg---> Problem: FInd the xpath of the success msg which goes hidden in a flash in few Nano seconds
	//sol: Open Dev Options-->Go to sources tab-->On the Extreme right side click on "Pause script execution" button
	@FindBy(xpath="//div[@class='form-row']//div[@class='alert-success alert']")
	private WebElement SuccessMsgTxt;
	
	//Left Side bar
	@FindBy(xpath="(//div[@class='left-sidebar']//h2)[1]")
	private WebElement CategoryLabelTxt;
	
	
	@FindBy(xpath="(//div[@class='left-sidebar']//h2)[2]")
	private WebElement BrandLabelTxt;
	
	//All Categories
	
	@FindBy(xpath="//div[@class='left-sidebar']//div[@class='panel-group category-products']//a[@data-toggle='collapse']")
	private List<WebElement> AllCategoriesTxt;
	

	@FindBy(xpath="//a[@data-toggle='collapse']//ancestor::div[@class='panel-heading']/following-sibling::div//ul/li//a")
	private List<WebElement> AllCategoryItems;
	
	
	//Women Tops--ALL Lables
	@FindBy(xpath="//div[@class='features_items']/h2")
	private WebElement AllBrandLabelsTxt;
	
	//All Brands
	@FindBy(xpath="//ul[@class='nav nav-pills nav-stacked']//a")
	private List<WebElement> AllBrandsLinks;
	
	
	@FindBy(xpath="//a[@href='/brand_products/Biba']")
	private WebElement BibaLink;
	
	
	@FindBy(xpath="//a[@href='/brand_products/Polo']")
	private WebElement PoloLink;
	
	@FindBy(xpath="//div[@class='recommended_items']/h2")
	private WebElement RecommendedItemsLabelTxt;
	
	@FindBy(xpath="//div[@class='recommended_items']//div[@class='col-sm-4']//a[@class='btn btn-default add-to-cart']")
	private List<WebElement> RecommendedITems;
	
	//Action methods
	public void Login() {
		//signupLink.click();
		//using PageActions
		pageActions.click(signupLink);
		
	}
	
	public void home() {
		pageActions.click(homeLink);
	}
	
	public void products() {
		pageActions.click(productsLink);
	}
	
	public void cart() {
		pageActions.click(cartLink);
	}
	
	public void Testcases() {
		pageActions.click(TestCasesLink);
	}
	
	public void APITesting() {
		pageActions.click(APITestingLink);
	}
	
	public void VideoTutorials() {
		pageActions.click(VideoTutLink);
	}
	
	public void ContactUs() {
		pageActions.click(ContactUsLink);
	}
	
	//send keys method
	public void enterEmail(String email) {
		//emailAddTxt.sendKeys(email);
		//using PageActions
		pageActions.enterText(emailAddTxt, email);
		
	}
	
	public boolean isImagepresent() {
		
		return imageicon.isDisplayed();
	}
	
	public void subscribe() {
		pageActions.click(SubscribeBtn);
	}
	
	public void scroll() {
		pageActions.ScrollDownusingElement(emailAddTxt);
	}
	
	public String Susbscription() {
		return pageActions.GetText(Subscriptionlabeltxt);
	}
	
	public String SuccessMessage() {
		return pageActions.GetText(SuccessMsgTxt);
	}
	
	
	public void ExpandAllcategories() {
		
		for(WebElement category:AllCategoriesTxt) {
			category.click();
		}
	}
	
	public void CollapseAllcategories() {
		
		for(WebElement category:AllCategoriesTxt) {
			category.click();
		}
	}

	public void Selectcategory(String Cat) {

		for (WebElement category : AllCategoriesTxt) {

			if (category.getText().equals(Cat)) {
				category.click();
				break;

			}
		}
	}
	
	public void SelectSubcategory(String subcat) {
		
		for(WebElement subcategory:AllCategoryItems) {
			if (subcategory.getText().equals(subcat)) {
				subcategory.click();
				break;

			}
			
		}
		
	}
	
	public String categoryLabel() {
		return pageActions.GetText(CategoryLabelTxt);
	}
	
	public String BrandLabel() {
		return pageActions.GetText(BrandLabelTxt);
	}
	
	public String AllBrandsLabel() {
		return pageActions.GetText(AllBrandLabelsTxt);
	}
	
	public void SelectBrand(String brand) {
		
		for(WebElement Brand:AllBrandsLinks) {
			if(Brand.getText().equalsIgnoreCase(brand)) {
				Brand.click();
				
			}
		}
	}
	
	public void ClickBIBA() {
		pageActions.click(BibaLink);
	}
	
	public void ClickPOLO() {
		pageActions.click(PoloLink);
	}
	
	
	public void scrollDOWN() {
		pageActions.ScrollDown();
	}
	
	public String GetRecommendedItemsText() {
	
		return pageActions.GetText(RecommendedItemsLabelTxt);
	}
	
	
	public void ClickFirstRecommendedITem() {
		
		for(int i=0;i<=RecommendedITems.size();i++) {
			RecommendedITems.get(0).click();
		}
	}
	
	
	public String GetSubscribeLabel() {
		return pageActions.GetText(SubscribeLabelTxt);
	}
	
	public String GetFullFledgeTextInfo() {
		return pageActions.GetText(FullFledgeTextInfo);
	}
	
	
	
}
	


