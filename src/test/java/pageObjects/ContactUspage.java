package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUspage extends BasePage {
	
	WebDriver driver;
	
	public ContactUspage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='contact-form']/child::h2")
	private WebElement GetinTouchlabeltxt;
	
	@FindBy(xpath="//input[@data-qa='name']")
	private WebElement NameTxt;
	
	@FindBy(xpath="//input[@data-qa='email']")
	private WebElement EmailTxt;
	
	@FindBy(xpath="//input[@data-qa='subject']")
	private WebElement SubjectTxt;
	
	@FindBy(xpath="//textarea[@data-qa='message']")
	private WebElement YourMesageTxtArea;

	@FindBy(xpath="//input[@type='file']")
	private WebElement ChooseFileBtn;
	
	@FindBy(xpath="//input[@data-qa='submit-button']")
	private WebElement SubmitBtn;
	
	@FindBy(xpath="//div[@class='status alert alert-success']")
	private WebElement SuccessMsgLabelTxt;
	
	@FindBy(xpath="//a[@class='btn btn-success']")
	private WebElement HomeBtn;
	
	public void ClickUploadFile(){
		pageActions.click(ChooseFileBtn);
		//pageActions.uploadFile("C:\\Users\\abrar\\Downloads\\Day48.txt");
	}
	
	public void EnterName(String name) {
		pageActions.enterText(NameTxt, name);
		
	}
	
	public void EnterEmail(String email) {
		pageActions.enterText(EmailTxt, email);
		
	}
	
	public void EnterSubject(String subject) {
		pageActions.enterText(SubjectTxt, subject);
		
	}
	
	public void EnterYourMsgTxtArea(String txtarea) {
		pageActions.enterText(YourMesageTxtArea, txtarea);
		
	}
	
	public void ClickSubmit() {
		pageActions.click(SubmitBtn);
	}
	
	public String GetInTouch() {
		return pageActions.GetText(GetinTouchlabeltxt);
	}
	
	//After click on submit button handle it by alert
	//alert.getText--->Press OK to proceed!
	//if eauals click on ok
	
	public String successMsg() {
		return pageActions.GetText(SuccessMsgLabelTxt);
	}
	
	public void CickHome() {
		pageActions.click(HomeBtn);
	}
	
	

}
