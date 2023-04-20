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
	
	@FindBy(xpath="//div[@class='features_items']/child::h2")
	private WebElement AllProductsLabeltxt;
	
	@FindBy(xpath="//div[@class='features_items']//div[@class='col-sm-4']")
	private  List<WebElement> AllProducts;
	
	@FindBy(xpath="//div[@class='features_items']//div[@class='col-sm-4']//div/ul/li/a")
	private List<WebElement> viewProductsLink;
	

	@FindBy(xpath="//input[@id='search_product']")
	private WebElement SearchProductTxtBox;
	

	@FindBy(xpath="//button[@id='submit_search']")
	private WebElement SearchBtn;
	
	@FindBy(xpath="//div[@class='features_items']/child::h2")
	private WebElement SearchProductsLabelTxt;
	
	
	
	public String AllproductsMsg() {
		return pageActions.GetText(AllProductsLabeltxt);
	}
	
	public void AllProducts() {
		
		for(WebElement product:AllProducts) {
			
			Log.info(product.getText());
			
			product.click();
			pageActions.waitForSeconds(2);
			
			
		}
	}

	public void ViewProduct() {
		
		for(int i=0;i<viewProductsLink.size();i++) {
			
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
	

}
