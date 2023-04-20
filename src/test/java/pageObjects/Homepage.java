package pageObjects;

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
	
	//div[@class='logo pull-left']//img
	@FindBy(xpath="//div[@class='logo pull-left']//img")
	private WebElement imageicon;
	
	@FindBy(xpath="//div[@class='footer-widget']//div[@class='single-widget']/h2")
	private WebElement Subscriptionlabeltxt;
	
	//success msg---> Problem: FInd the xpath of the success msg which goes hidden in a flash in few Nano seconds
	//sol: Open Dev Options-->Go to sources tab-->On the Extreme right side click on "Pause script execution" button
	@FindBy(xpath="//div[@class='form-row']//div[@class='alert-success alert']")
	private WebElement SuccessMsgTxt;
	
	
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
		pageActions.ScrollDown(emailAddTxt);
	}
	
	public String Susbscription() {
		return pageActions.GetText(Subscriptionlabeltxt);
	}
	
	public String SuccessMessage() {
		return pageActions.GetText(SuccessMsgTxt);
	}

}
