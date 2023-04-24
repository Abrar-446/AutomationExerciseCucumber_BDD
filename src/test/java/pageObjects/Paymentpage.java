package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Paymentpage extends BasePage{
	
	WebDriver driver;
	
	public Paymentpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@data-qa='name-on-card']")
	private WebElement NameOnCardTxtBox;
	
	
	@FindBy(xpath="//input[@data-qa='card-number']")
	private WebElement CardNumberTxtBox;
	
	@FindBy(xpath="//input[@data-qa='cvc']")
	private WebElement CVCTxtBox;
	
	@FindBy(xpath="//input[@data-qa='expiry-month']")
	private WebElement ExpiryTxtBox;
	
	@FindBy(xpath="//input[@data-qa='expiry-year']")
	private WebElement YearTxtBox;
		
	@FindBy(xpath="//button[@data-qa='pay-button']")
	private WebElement PayConfirmOrderBtn;
	
	public void EnterNameOnCard(String name) {
		pageActions.enterText(NameOnCardTxtBox, name);
		
	}
	
	public void EnterCardNumber(String CardNum) {
		pageActions.enterText(CardNumberTxtBox, CardNum);
		
	}
	
	public void EnterCVC(String CVC) {
		pageActions.enterText(CVCTxtBox, CVC);
		
	}
	
	public void EnterExpiry(String expiry) {
		pageActions.enterText(ExpiryTxtBox, expiry);
		
	}
	
	public void EnterYear(String year) {
		pageActions.enterText(YearTxtBox, year);
		
	}
	
	public void ClickPayConfirmOrder() {
		pageActions.click(PayConfirmOrderBtn);
	}
	
	

}
