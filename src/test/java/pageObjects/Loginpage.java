package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Loginpage extends BasePage{
	
	WebDriver driver;
	
	public Loginpage(WebDriver driver) {
		super(driver);
	}
	
	//Login to your account elements
	@FindBy(xpath="//h2[normalize-space()='Login to your account']")
	private WebElement loginLabel;
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	private WebElement LoginEmailTxt;
	
	@FindBy(xpath="//input[@data-qa='login-password']")
	private WebElement LoginPwdTxt;
	
	@FindBy(xpath="//button[@data-qa='login-button']")
	private WebElement LoginBtn;
	
	//New User Signup! elements
	
	@FindBy(xpath="//h2[contains(text(),'New User Signup!')]")
	private WebElement NewUserLabel;
	
	
	@FindBy(xpath="//input[@data-qa='signup-name']")
	private WebElement SignupNameTxt;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	private WebElement SignupEmailTxt;
	
	@FindBy(xpath="//button[@data-qa='signup-button']")
	private WebElement SignupBtn;
	
	//login error message
	@FindBy(xpath="//input[@data-qa='login-password']/following-sibling::p")
	private WebElement Errormsgtxt;
	
	//Logout---.//a[contains(text(),'Logout')]
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private WebElement LogoutBtn;
	
	//Errormsg
		//input[@value='signup']/following-sibling::p
		@FindBy(xpath="//input[@value='signup']/following-sibling::p")
		private WebElement ErrormsgSignuptxt;
	
	
	//Action methods--- Login
	
	public String loginlabel() {
		//return loginLabel.getText();
		
		//---using PageActions class
		return pageActions.GetText(loginLabel);
	}
	
	public void enterLoginEmail(String LoginEmail) {
		//LoginEmailTxt.sendKeys(LoginEmail);
		pageActions.enterText(LoginEmailTxt, LoginEmail);
	}
	
	public void enterLoginPassword(String LoginPwd) {
		//LoginPwdTxt.sendKeys(LoginPwd);
		pageActions.enterText(LoginPwdTxt, LoginPwd);
	}
	
	public void LoginButton() {
		//LoginBtn.click();
		pageActions.click(LoginBtn);
	}
	
	
	//Action methods---->Sign up
	
	public String NewUserlabel() {
		//return NewUserLabel.getText();
		return pageActions.GetText(NewUserLabel);
	}
	
	public void enterSignupName(String SignupName) {
		//SignupNameTxt.sendKeys(SignupName);
		pageActions.enterText(SignupNameTxt, SignupName);
	}
	
	public void enterSignupEmail(String signupEmail) {
		//SignupEmailTxt.sendKeys(signupEmail);
		pageActions.enterText(SignupEmailTxt, signupEmail);
	}
	
	public void SignupButton() {
		//SignupBtn.click();
		pageActions.click(SignupBtn);
	}	
	
	public String Errormsg() {
		return pageActions.GetText(Errormsgtxt);
	}
	
	public void logout() {
		pageActions.click(LogoutBtn);
	}
	
	public String ErrorSignupMsg() {
		return pageActions.GetText(ErrormsgSignuptxt);
	}
}
