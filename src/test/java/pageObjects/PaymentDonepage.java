package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentDonepage extends BasePage {
	
WebDriver driver;
	
	public PaymentDonepage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[@data-qa='order-placed']//following-sibling::p")
	private WebElement OrderPlacedMessageTxtLabel;

	@FindBy(xpath="//a[contains(text(),'Download Invoice')]")
	private WebElement DownloadInvoiceBtn;
	
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	private WebElement ContinueBtn;
	
	
	public String OrderPlacedMessage() {
		return pageActions.GetText(OrderPlacedMessageTxtLabel);
	}
	
	public void ClickDownloadInvoice() {
		pageActions.click(DownloadInvoiceBtn);
	}
	
	public void ClickContinue() {
		pageActions.click(ContinueBtn);
	}
	
	
}
