package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutpage extends BasePage {
	
	WebDriver driver;
	
	public CheckOutpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//ul[@class='address item box']/li/following-sibling::li")
	private List<WebElement> YourDeliveryAdd;
	
	@FindBy(xpath="//ul[@class='address alternate_item box']/li/following-sibling::li")
	private List<WebElement> YourBillingAdd;
	
	@FindBy(xpath="//textarea[@name='message']")
	private WebElement TextAreaTxt;
	
	@FindBy(xpath="//a[contains(text(),'Place Order')]")
	private WebElement PlaceOrderBtn;
	
	
	public List<String> YourDeliveryAddInfo() {
		
		List<String> al= new ArrayList<>();
		
		
		for(WebElement ele:YourDeliveryAdd) {
			al.add(ele.getText());
		}
		return al;
		
	}
	
	public List<String> YourBillingAddInfo() {
		
		List<String> al= new ArrayList<>();
		
		
		for(WebElement ele:YourBillingAdd) {
			al.add(ele.getText());
		}
		return al;
		
	}
	
	
	public void EnterTextArea(String msg) {
		pageActions.enterText(TextAreaTxt, msg);
	}
	
	public void ClickPlaceOrder() {
		pageActions.click(PlaceOrderBtn);
	}
	
	
	
	

}
