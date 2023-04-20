package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {

	WebDriver driver;

	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='login-form']/h2/b")
	private WebElement EnterAccInfoLabelTxt;

	@FindBy(xpath = "//input[@id='id_gender1']")
	private WebElement RadioButton1;

	@FindBy(xpath = "//input[@id='id_gender2']")
	private WebElement RadioButton2;

	@FindBy(xpath = "//input[@data-qa='password']")
	private WebElement PwdTxtbox;

	@FindBy(xpath = "//select[@data-qa='days']")
	private WebElement DayDrpDown;

	@FindBy(xpath = "//select[@data-qa='months']")
	private WebElement MonthDrpDown;

	@FindBy(xpath = "//select[@data-qa='years']")
	private WebElement YearDrpDown;

	// checkboxes

	@FindBy(xpath = "//input[@id='newsletter']")
	private WebElement Signupcheckbox;

	@FindBy(xpath = "//input[@id='optin']")
	private WebElement Recievecheckbox;

	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement FirstNametxtbox;

	@FindBy(xpath = "//input[@id='last_name']")
	private WebElement LastNametxtbox;

	@FindBy(xpath = "//input[@id='company']")
	private WebElement Companytxtbox;

	@FindBy(xpath = "//input[@id='address1']")
	private WebElement Addresstxtbox1;

	@FindBy(xpath = "//input[@id='address2']")
	private WebElement Addresstxtbox2;

	@FindBy(xpath = "//select[@id='country']")
	private WebElement CountryDrpDown;

	@FindBy(xpath = "//input[@id='state']")
	private WebElement Statetxtbox;

	@FindBy(xpath = "//input[@id='city']")
	private WebElement Citytxtbox;

	@FindBy(xpath = "//input[@data-qa='zipcode']")
	private WebElement Zipcodetxtbox;

	@FindBy(xpath = "//input[@id='mobile_number']")
	private WebElement MobileNumtxtbox;

	@FindBy(xpath = "//button[@data-qa='create-account']")
	private WebElement CreateAccButton;

	@FindBy(xpath = "//h2[@data-qa='account-created']")
	private WebElement AccCreatedlabelTxt;

	@FindBy(xpath = "//a[@data-qa='continue-button']")
	private WebElement ContinueBtn;
	
	//loggedIn user
	@FindBy(xpath="//i[@class='fa fa-user']/following-sibling::b")
	private WebElement LoggedInUsertxt;
	
	//Deleteacc button
	@FindBy(xpath="//a[@href='/delete_account']")
	private WebElement DeleteAccBtn;
	
	//Account Deleted msg
	@FindBy(xpath="//h2[@data-qa='account-deleted']/child::b")
	private WebElement AccDeletedMsg;
	
	
	
	
	public String EnterAccInfoMsg() {
		return pageActions.GetText(EnterAccInfoLabelTxt);
	}

	public void MrRadio() {

		pageActions.click(RadioButton1);
	}

	public void MrsRadio() {

		pageActions.click(RadioButton2);
	}

	public void EnterPwd(String pwd) {
		pageActions.enterText(PwdTxtbox, pwd);
	}

	// select date of Birth
	public void selectDate(String date) {
		pageActions.selectValueFromDropDownBytext(DayDrpDown, date);
	}

	public void selectMonth(String month) {
		pageActions.selectValueFromDropDownBytext(MonthDrpDown, month);
	}

	public void selectYear(String year) {
		pageActions.selectValueFromDropDownBytext(YearDrpDown, year);
	}

	public void signupcheck() {
		pageActions.click(Signupcheckbox);
	}

	public void recievecheck() {
		pageActions.click(Recievecheckbox);
	}

	public void enterFirstName(String fname) {
		pageActions.enterText(FirstNametxtbox, fname);
	}

	public void enterLastName(String lname) {
		pageActions.enterText(LastNametxtbox, lname);
	}

	public void enterComany(String compname) {
		pageActions.enterText(Companytxtbox, compname);
	}

	public void enterAddressOne(String add1) {
		pageActions.enterText(Addresstxtbox1, add1);
	}

	public void enterAddressTwo(String add2) {
		pageActions.enterText(Addresstxtbox2, add2);
	}

	public void selectCountry(String text) {
		pageActions.selectValueFromDropDownBytext(CountryDrpDown, text);
	}

	public void enterState(String state) {
		pageActions.enterText(Statetxtbox, state);
	}
	
	public void enterCity(String city) {
		pageActions.enterText(Citytxtbox, city);
	}

	
	public void enterZipCode(String zip) {
		pageActions.enterText(Zipcodetxtbox, zip);
	}

	public void enterMobNum(String num) {
		pageActions.enterText(MobileNumtxtbox, num);
	}

	public void createaccount() {
		pageActions.click(CreateAccButton);
	}

	// verify account created msg

	public String accountCreatedmsg() {
		return pageActions.GetText(AccCreatedlabelTxt);
	}

	public void continueb() {
		pageActions.click(ContinueBtn);
	}
	
	public String loggedInUser() {
		return pageActions.GetText(LoggedInUsertxt);
	}
	
	public void DeleteAccount() {
		pageActions.click(DeleteAccBtn);
	}
	
	public String AccDeletedmsg() {
		return pageActions.GetText(AccDeletedMsg);
	}
	
	
	

	
	
	

}
