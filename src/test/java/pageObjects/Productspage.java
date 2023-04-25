package pageObjects;

import java.util.ArrayList;
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
	
	//AllProductsMouseHover
	@FindBy(xpath="(//div[@class='product-image-wrapper']//div[@class='single-products'])")
	private List<WebElement> AllProductsMouseHover;

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
	
	//SearchedProducts
	@FindBy(xpath="//div[@class='features_items']//div[@class='col-sm-4']//div[@class='overlay-content']//p")
	private List<WebElement> SearchedProductList;
	
	//AllProductsAddToCart
	@FindBy(xpath="//div[@class='product-overlay']//p[contains(text(),'')]/parent::div//a[@class='btn btn-default add-to-cart']")
	private List<WebElement> AllProductsAddToCart;
	
	@FindBy(xpath="//i[@class='fa fa-angle-up']")
	private WebElement ArrowBtn;
	
	@FindBy(xpath="//a[contains(text(),'Cart')]")
	private WebElement cartLink;
	
	public void cart() {
		pageActions.click(cartLink);
	}
	
	
	public List<String> GetSearchedProducts() {
		
		List<String> li=new ArrayList<String>();
		
		for(WebElement p:SearchedProductList) {
			String productText=p.getText();
			li.add(productText);
		}
		return li;
	}
	
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
	
	
	/*
	 * public void mouseHover() {
	 * 
	 * for(WebElement move:AllProductsMouseHover) { pageActions.MoveHover(move);
	 * List<WebElement> li=AllProductsAddToCart; } }
	 */
	
	public void MouseHover_AddToCart_ContinueBtn() {
		
		for(int i=0;i<AllProductsMouseHover.size();i++) {
			pageActions.MoveHover(AllProductsMouseHover.get(i));
			for(int j=i;j<AllProductsAddToCart.size();) {
				pageActions.explicitWait(4, AllProductsAddToCart.get(j));
				pageActions.click(AllProductsAddToCart.get(j));
				pageActions.waitForSeconds(2);
				pageActions.click(ContinueShoppingBtn);
				break;
			}
		}
	}
	
	/*
	 * public void AddToCartButton() { for(WebElement al:AllProductsAddToCart) {
	 * pageActions.click(al); } }
	 */
	
	public void ClickArrow() {
		pageActions.click(ArrowBtn);
	}
	
	public void ScrollUP() {
		pageActions.ScrollUp();
	}

}
