package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCartpage extends BasePage {
	
	WebDriver driver;
	
	public ViewCartpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//table[@id='cart_info_table']/tbody/tr[1]/td[3]/p")
	private WebElement FirstProductPrice;
	
	@FindBy(xpath="//table[@id='cart_info_table']/tbody/tr[1]/td[5]/p")
	private WebElement FirstProductTotalPrice;
	
	
	@FindBy(xpath="//table[@id='cart_info_table']/tbody/tr[1]/td[4]//button")
	private WebElement FirstProductQuantity;
	
	
	@FindBy(xpath="//table[@id='cart_info_table']/tbody/tr[2]/td[3]/p")
	private WebElement SecondProductPrice;
	
	@FindBy(xpath="//table[@id='cart_info_table']/tbody/tr[2]/td[5]/p")
	private WebElement SecondProductTotalPrice;
	
	
	@FindBy(xpath="//table[@id='cart_info_table']/tbody/tr[2]/td[4]//button")
	private WebElement SecondProductQuantity;
	
	//Click Register/Login
	@FindBy(xpath="//a[@href='/login']/u")
	private WebElement Register_LoginLink;

	// cart info table
	@FindBy(xpath = "//table[@id='cart_info_table']/tbody/tr")
	private List<WebElement> AddedCartProductsList;
	
	//Proceed to cart Button
	@FindBy(xpath="//a[contains(text(),'Proceed To Checkout')]")
	private WebElement ProceedToChkOutBtn;
	
	//Delete Button
	@FindBy(xpath="//table[@id='cart_info_table']//tbody//td[@class='cart_delete']//a/i")
	private List<WebElement> DeleteXBtn;

	//cart Empty msg
	@FindBy(xpath="(//a[@href='/products'])[2]")
	private WebElement CartEmptyMsgTxt;
	
	
	//First Product price
		public int  FirstProductPrice() {
			String Fprice=pageActions.GetText(FirstProductPrice);
			String[] price=Fprice.split(" ");
			
			int Firstprice=Integer.parseInt(price[1]);
			return Firstprice;
		}
		
		public int FirstProductTotal() {
			String producttotal=pageActions.GetText(FirstProductTotalPrice);
			String[] total=producttotal.split(" ");
			int totalint=Integer.parseInt(total[1]);
			
			int Acttotal= FirstProductPrice()*FirstProductQuantity();
			if(Acttotal==totalint)
			return Acttotal;
			else
			return (Integer) null;
		}
		public int FirstProductQuantity() {
			return Integer.parseInt(pageActions.GetText(FirstProductQuantity));
		}
		
		//second product details
		public int  SecondProductPrice() {
			String Sprice=pageActions.GetText(SecondProductPrice);
			String[] price=Sprice.split(" ");
			
			int Secondprice=Integer.parseInt(price[1]);
			return Secondprice;
		}
		
		public int SecondProductTotal() {
			String producttotal=pageActions.GetText(SecondProductTotalPrice);
			String[] total=producttotal.split(" ");
			int totalint=Integer.parseInt(total[1]);
			
			int Acttotal= SecondProductPrice()*SecondProductQuantity();
			if(Acttotal==totalint)
			return Acttotal;
			else
			return (Integer) null;
		}
		public int SecondProductQuantity() {
			return Integer.parseInt(pageActions.GetText(SecondProductQuantity));
		}
		
		public boolean  products() {

			/*
			 * for (int i = 1; i < AddedCartProductsList.size(); i++) {
			 * 
			 * //
			 * table[@id='cart_info_table']/tbody/tr[1]/td[2][@class='cart_description']//a
			 * 
			 * String text = driver .findElement(By.xpath(
			 * "//table[@id='cart_info_table']/tbody/tr[" + i +
			 * "]/td[2][@class='cart_description']//a")) .getText();
			 * 
			 * Log.info(text);
			 */
			int NumOfProducts=AddedCartProductsList.size();
			
			if(NumOfProducts==2)
				return true;
				else return false;
			}
	
		public void ClickProceedToChkOut() {
			pageActions.click(ProceedToChkOutBtn);
		}
		
		public void ClickRegister_loginLink() {
			pageActions.click(Register_LoginLink);
		}
		
		public void DeleteAllProducts() {
			
			for(WebElement del:DeleteXBtn) {
				del.click();
			}
		}
		
		
		public String CartEmptyMessage() 
		{ 
		return pageActions.GetText(CartEmptyMsgTxt); 
		}
		 
		 
		  
		/*
		 * public boolean MSGDisplayed() {
		 * 
		 * return CartEmptyMsgTxt.isDisplayed(); }
		 */
		
		/*
		 * public String CartEmptyMessage() {
		 * 
		 * String text=pageActions.JSGetText(); return text; }
		 */
		}
		
		

