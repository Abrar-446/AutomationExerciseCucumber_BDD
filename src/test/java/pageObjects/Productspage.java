package pageObjects;

import java.util.List;

import org.mortbay.log.Log;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class Productspage extends BasePage {

	WebDriver driver;

	public Productspage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='features_items']/child::h2")
	private WebElement AllProductsLabeltxt;

	@FindBy(xpath = "//div[@class='features_items']//div[@class='col-sm-4']")
	private List<WebElement> AllProducts;

	@FindBy(xpath = "//div[@class='features_items']//div[@class='col-sm-4']//div/ul/li/a")
	private List<WebElement> viewProductsLink;

	@FindBy(xpath = "//input[@id='search_product']")
	private WebElement SearchProductTxtBox;

	@FindBy(xpath = "//button[@id='submit_search']")
	private WebElement SearchBtn;

	@FindBy(xpath = "//div[@class='features_items']/child::h2")
	private WebElement SearchProductsLabelTxt;

	// First Product
	@FindBy(xpath = "//div[@class='product-overlay']//p[contains(text(),'Blue Top')]/parent::div//a[@class='btn btn-default add-to-cart']")
	private WebElement FirstProductBtn;

	// First Product mouseHover
	@FindBy(xpath = "(//div[@class='product-image-wrapper']//div[@class='single-products'])[1]")
	private WebElement MouseHoverFirstProduct;

	@FindBy(xpath ="//button[normalize-space()='Continue Shopping']")
	private WebElement ContinueShoppingBtn;

	// Second Product mouseHover
	@FindBy(xpath = "(//div[@class='product-image-wrapper']//div[@class='single-products'])[2]")
	private WebElement MouseHoverSecondProduct;

	@FindBy(xpath = "//div[@class='product-overlay']//p[contains(text(),'Men Tshirt')]/parent::div//a[@class='btn btn-default add-to-cart']")
	private WebElement SecondProductBtn;

	// View Cart
	@FindBy(xpath = "//div[@class='modal-content']//div[2]//a[@href='/view_cart']")
	private WebElement ViewCartBtn;
	
	public String AllproductsMsg() {
		return pageActions.GetText(AllProductsLabeltxt);
	}

	public void AllProducts() {

		for (WebElement product : AllProducts) {

			Log.info(product.getText());

			product.click();
			pageActions.waitForSeconds(2);

		}
	}

	/*
	 * public void TwoProductsMouseHover() {
	 * 
	 * for(int i=0;i<AllProducts.size()-32;i++) { WebElement ele=AllProducts.get(i);
	 * pageActions.MoveHover(ele);
	 * 
	 * } }
	 */

	public void ViewProduct() {

		for (int i = 0; i < viewProductsLink.size(); i++) {

			viewProductsLink.get(0).click();

		}
	}

	public void EnterSearchProduct(String txt) {
		pageActions.enterText(SearchProductTxtBox, txt);
	}

	public void search() {
		pageActions.click(SearchBtn);
	}

	public String SearchProducts() {
		return pageActions.GetText(SearchProductsLabelTxt);
	}

	/*
	 * public boolean SearchedProducts() {
	 * 
	 * for(int i=0;i<viewProductsLink.size();i++) {
	 * 
	 * viewProductsLink.get(0).click();
	 * 
	 * ProductDetailsPage producDetailsPage=new ProductDetailsPage(driver); String
	 * details=producDetailsPage.productName(); if(details.contains("Tshirt")){
	 * return true;
	 * 
	 * } } return false; }
	 */

	  
	  public void FirstHover() { pageActions.MoveHover(MouseHoverFirstProduct); }
	  
	  public void SecondHover() { pageActions.MoveHover(MouseHoverSecondProduct); }
	 

	public void FirstAddToCart() {
		pageActions.click(FirstProductBtn);
	}

	
	  public void ClickContinueShopping() { pageActions.click(ContinueShoppingBtn);
	  }
	 
	
	/*
	 * public void ClickContinueShopping() {
	 * pageActions.JSClick(ContinueShoppingBtn); }
	 */

	/*
	 * public void SecondAddToCart() { pageActions.click(SecondProductBtn); }
	 */
	
	public void SecondAddToCart() {
		pageActions.JSClick(SecondProductBtn);
	}
	

	public void ClickViewCart() {
		pageActions.click(ViewCartBtn);
	}
	
	
	public void waitExplicit() {
		
		pageActions.explicitWait(5, ContinueShoppingBtn);
		
	}

}
