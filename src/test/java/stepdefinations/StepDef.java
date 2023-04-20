package stepdefinations;

import java.io.File;
import java.time.Duration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.mortbay.log.Log;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ContactUspage;
import pageObjects.CreateAccountPage;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.ProductDetailsPage;
import pageObjects.Productspage;
import pageObjects.TestCasespage;
import utilities.ReadConfig;

public class StepDef extends BaseClass {

	@Before
	public void setup1() {
		log = LogManager.getLogger(StepDef.class);
		// initialize logger
		// log = LoggerFactory.getLogger(loginStepDefination.class);
		// log=LoggerFactory.getLogger(loginStepDefination.class);
		// log=LogManager.getLogger("loginStepDefination");
//		log =Logger.getLogger("nopEcommerce");
		//PropertyConfigurator.configure("Log4j.properties");
		readConfig = new ReadConfig();
		System.out.println("Setup the browser");

		String browser = readConfig.getBrowser();
		System.out.println(browser);

		// launch browser
		switch (browser.toLowerCase()) {
		case "chrome":
			//Chrome Options for Adblocker extension
			/*
			 * //Step 1) AdBlocker extension must be installed on Chrome browser before
			 * using Chrome Options class
			 * 
			 * Step 2) Extract the CRX File corresponding to AdBlocker extension through
			 * http://crxextractor.com/
			 * 
			 * Step 3) Pass the downloaded CRX File path to Chrome Options class
			 * 
			 * Step 4) Instantiate the web driver using the desired capabilities class and
			 * Chrome Options in Selenium object
			 */
			 ChromeOptions options = new ChromeOptions();
			 Map<String, Object> preferences = new Hashtable<String, Object>();
			 options.setExperimentalOption("prefs", preferences);
			 
			/*
			 * ChromeOptions options=new ChromeOptions();
			 * options.addArguments("--remote-allow-origins=*");
			 */
			// WebDriverManager.chromedriver().setup();

			// This below code is to disable the ads in webpage by using crx
			//ChromeOptions options = new ChromeOptions();
			options.addExtensions(new File(".//CRX//extension_1_549_0_0.crx"));
			driver = new ChromeDriver(options);
			// driver = new ChromeDriver();
			break;

		case "msedge":
			driver = new EdgeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}

		log.info(" Browser Setup executed");
	}

	/*
	 * @After public void tearDown(Scenario sc) throws IOException {
	 * System.out.println("TearDown method executed");
	 * 
	 * if(sc.isFailed()==true) {
	 * 
	 * pageActions.captureScreen(sc.getName());
	 * 
	 * 
	 * } }
	 */

	@AfterStep
	public void addScreenshot(Scenario scenario) {

		if (scenario.isFailed()) { // This statement needs to be removed in order to take screenshot for every step

			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		loginpage = new Loginpage(driver);
		homepage = new Homepage(driver);
		CreateAccpage = new CreateAccountPage(driver);
		contactUspage=new ContactUspage(driver);
		testcasespage=new TestCasespage(driver);
		productspage=new Productspage(driver);
		productDetailspage=new ProductDetailsPage(driver);

		log.info("Chrome browser Launched");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		log.info("url opened");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//GetWindow handle is used due to Adding extensions for blocking the add
		String parent=driver.getWindowHandle();
		Set<String> handles=driver.getWindowHandles();
		for(String w:handles) {
		String ActTitle=driver.switchTo().window(w).getTitle();
		String ExpTitle="Stands Extension";
		
		if(ActTitle.equals(ExpTitle)) {
			driver.switchTo().window(parent);
		}
		
		}
		

	}

	@Then("Verify that home page is visible successfully")
	public void verify_that_home_page_is_visible_successfully() {
		boolean result = homepage.isImagepresent();
		if (result == true) {
			Assert.assertTrue(true);
			log.info("Homepage page is visible successfully");
		} else {
			Assert.assertTrue(false);
			log.warn("Homepage is not visible");
		}

	}

	@Then("Click on Signup_Login button")
	public void click_on_signup_login_button() {
		homepage.Login();

	}

	@Then("Verify New User Signup! is visible")
	public void verify_new_user_signup_is_visible() {

		String Act = loginpage.NewUserlabel();
		String Exp = "New User Signup!";

		if (Act.equals(Exp)) {
			Assert.assertTrue(true);
			log.info("New user signup is visible");
		} else {
			Assert.assertTrue(false);
			log.warn("New user signup is not visible");
		}
	}

	@Then("Enter name and email address")
	public void enter_name_and_email_address() {
		loginpage.enterSignupName("Test8012");
		loginpage.enterSignupEmail("Test8012@test.com");

	}

	@Then("Click Signup button")
	public void click_signup_button() {
		loginpage.SignupButton();

	}

	@Then("Verify that ENTER ACCOUNT INFORMATION is visible")
	public void verify_that_enter_account_information_is_visible() {
		String actual = CreateAccpage.EnterAccInfoMsg();
		String expected = "ENTER ACCOUNT INFORMATION";
		if (actual.equals(expected)) {
			Assert.assertTrue(true);
			log.info("ENTER ACCOUNT INFORMATION is visible");
		} else {
			Assert.assertTrue(false);
			log.warn("ENTER ACCOUNT INFORMATION is not visible");
		}

	}

	@Then("Fill details: Title, Name, Email, Password, Date of birth")
	public void fill_details_title_name_email_password_date_of_birth() {
		CreateAccpage.MrRadio();
		CreateAccpage.EnterPwd("Test@123");
		CreateAccpage.selectDate("19");
		CreateAccpage.selectMonth("November");
		CreateAccpage.selectYear("1992");

	}

	@Then("Select checkbox Sign up for our newsletter!")
	public void select_checkbox_sign_up_for_our_newsletter() {
		CreateAccpage.signupcheck();

	}

	@Then("Select checkbox Receive special offers from our partners!")
	public void select_checkbox_receive_special_offers_from_our_partners() {

		CreateAccpage.recievecheck();
	}

	@Then("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
	public void fill_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() {
		CreateAccpage.enterFirstName("Abrar");
		CreateAccpage.enterLastName("Ahmed");
		CreateAccpage.enterComany("EVRY");
		CreateAccpage.enterAddressOne("Bangalore");
		CreateAccpage.enterAddressTwo("ADDDF");
		CreateAccpage.selectCountry("Canada");
		CreateAccpage.enterState("Karnataka");
		CreateAccpage.enterCity("Bangalore");

		CreateAccpage.enterZipCode("51289");
		CreateAccpage.enterMobNum("9876543210");

	}

	@Then("Click Create Account button")
	public void click_create_account_button() {
		CreateAccpage.createaccount();

	}

	@Then("Verify that ACCOUNT CREATED! is visible")
	public void verify_that_account_created_is_visible() {
		String act = CreateAccpage.accountCreatedmsg();
		String exp = "ACCOUNT CREATED!";

		if (act.equals(exp)) {
			Assert.assertTrue(true);
			log.info("Account created is visible");
		} else {
			Assert.assertTrue(false);
			log.warn("Account created is not visible");
		}

	}

	@Then("Click on continue button")
	public void click_on_continue_button() {
		CreateAccpage.continueb();

	}

	@Then("Verify that Logged in as username is visible")
	public void verify_that_logged_in_as_username_is_visible() {

		String loggedin = CreateAccpage.loggedInUser();

		if (loggedin.equals("Test8012")) {
			Assert.assertTrue(true);
			log.info("Logged in username is visible");
		} else {
			Assert.assertTrue(false);
			log.warn("Not visible");
		}
	}

	@Then("Click Delete Account button")
	public void click_delete_account_button() {
		CreateAccpage.DeleteAccount();

	}

	@Then("Verify that ACCOUNT DELETED! is visible")
	public void verify_that_account_deleted_is_visible() {
		String accdel = CreateAccpage.AccDeletedmsg();

		if (accdel.equals("ACCOUNT DELETED!")) {
			Assert.assertTrue(true);
			log.info("ACCOUNT DELETED! is visible");
		} else {
			Assert.assertTrue(false);
			log.warn("ACCOUNT DELETED! is Not visible");
		}

		CreateAccpage.continueb();

	}
	// **********TestCase-2: Login with valid Email and password*********

	@Then("Verify Login to your account is visible")
	public void verify_login_to_your_account_is_visible() {
		String Act = loginpage.loginlabel();

		if (Act.contains("Login to your account")) {
			Assert.assertTrue(true);
			log.info("Login to your account is visible");
		} else {
			Assert.assertTrue(false);
			log.warn("Login to your account is not visible");
		}

	}

	@Then("Enter correct email address and password")
	public void enter_correct_email_address_and_password() {
		loginpage.enterLoginEmail("test8001@test.com");
		loginpage.enterLoginPassword("Test@123");

	}

	@Then("Click login button")
	public void click_login_button() {
		loginpage.LoginButton();

	}

//**********TestCase-3: Login with Invalid Email and password*********

	@Then("Enter Incorrect email address and password")
	public void enter_incorrect_email_address_and_password() {

		loginpage.enterLoginEmail("test8001@test.com");
		loginpage.enterLoginPassword("Test@123");
	}

	@Then("Verify error {string} is visible")
	public void verify_error_is_visible(String ExpErrormsg) {

		String ActualErrormsg = loginpage.Errormsg();

		if (ActualErrormsg.equals(ExpErrormsg)) {
			Assert.assertTrue(true);
			Log.info("Error message is visible");
		} else {
			Assert.assertTrue(false);
			Log.warn("Error message is not visible");
		}
	}

//**********TestCase-4: Logout user Test*********

	@Then("Click Logout button")
	public void click_logout_button() {
		loginpage.logout();

	}

	@Then("Verify that user is navigated to login page")
	public void verify_that_user_is_navigated_to_login_page() {
		String url = driver.getCurrentUrl();

		if (url.contains("login")) {
			Assert.assertTrue(true);
			Log.info("User Logged out successfully");
		} else {
			Assert.assertTrue(false);
			Log.warn("User does not Logged out");
		}
	}

//**********TestCase-5: Register User with existing email*********

	@Then("Enter name and already registered email address")
	public void enter_name_and_already_registered_email_address() {
		loginpage.enterSignupName("Test001");
		loginpage.enterSignupEmail("Test001@test.com");
	}

	@Then("Verify  signup error {string} is visible")
	public void verify_signup_error_is_visible(String ExpSignupError) {
		String ActErrormsg = loginpage.ErrorSignupMsg();
		if (ActErrormsg.equals(ExpSignupError)) {
			Assert.assertTrue(true);
			Log.info("Email Address already exist!' is visible");
		} else {
			Assert.assertTrue(false);
			Log.warn("Email Address already exist!' is NOT visible");

		}
	}

//**********TestCase-6: Contact Us From Test*********
	
	@Then("Click on Contact Us button")
	public void click_on_contact_us_button() {
	    homepage.ContactUs();
	    
	}
	@Then("Verify {string} is visible")
	public void verify_is_visible(String Exptext) {
	    
		String Actualtext=contactUspage.GetInTouch();
		if (Actualtext.equals(Exptext)) {
			Assert.assertTrue(true);
			Log.info("Get in Touch is visible");
		} else {
			Assert.assertTrue(false);
			Log.warn("Get in Touch is NOT visible");

		}
	    
	}
	@Then("Enter name, email, subject and message")
	public void enter_name_email_subject_and_message(){
	    contactUspage.EnterName("Test");
	    contactUspage.EnterEmail("Test991@test.com");
	    contactUspage.EnterSubject("Selenium");
	    contactUspage.EnterYourMsgTxtArea("This is complete suite of automation tests using SELENIUM, java and Cucucmber");
   
	}
	@Then("Upload file")
	public void upload_file()  {
		contactUspage.ClickUploadFile();
	    
	}
	@Then("Click Submit button")
	public void click_submit_button() {
		
	   contactUspage.ClickSubmit(); 
	    
	}
	@Then("Click OK buttons")
	public void click_ok_buttons() {
	    Alert alert=driver.switchTo().alert();
	    String Atext=alert.getText();
	    
	    if(Atext.equals("Press OK to proceed!")) {
	    	alert.accept();
	    }else {
	    	alert.dismiss();
	    }   
	    
	}
	@Then("Verify success message {string} is visible")
	public void verify_success_message_is_visible(String ExpSuccMsg) {
		
		String Actualmsg=contactUspage.successMsg();
		if (Actualmsg.equals(ExpSuccMsg)) {
			Assert.assertTrue(true);
			Log.info("Success Message is visible");
		} else {
			Assert.assertTrue(false);
			Log.warn("Success message is NOT visible");
		}
   
	    
	}
	@Then("Click Home button and verify that landed to home page successfully")
	public void click_home_button_and_verify_that_landed_to_home_page_successfully() {
		contactUspage.CickHome();
		boolean result = homepage.isImagepresent();
		if (result == true) {
			Assert.assertTrue(true);
			log.info("Homepage page is visible successfully");
		} else {
			Assert.assertTrue(false);
			log.warn("Homepage is not visible");
		}
	}
	
//**********TestCase-7: Verify Test cases page *********	
	@Then("Click on Test Cases button")
	public void click_on_test_cases_button() {
		homepage.Testcases();
	}
	

	
@Then("Verify user is navigated to test cases page successfully")
public void verify_user_is_navigated_to_test_cases_page_successfully() {
	String Actual=driver.getCurrentUrl();
	
	String Expected="test_cases";
	
	if(Actual.contains(Expected)) {
		Assert.assertTrue(true);
		log.info("user is navigated to test cases page successfully");
	} else {
		Assert.assertTrue(false);
		log.warn("user is NOT navigated to test cases page");
	}
		
	}

@Then("Expand all test cases")
public void expand_all_test_cases() {
	testcasespage.ExpandTestCase();
}

@Then("Collapse all test cases")
public void collapse_all_test_cases() {
	testcasespage.CollapseTestCase();
	
}

//**********TestCase-8: Verify All Products and product detail page *********

@Then("Click on Products button")
public void click_on_products_button() {
    homepage.products();
    
}
@Then("Verify user is navigated to ALL PRODUCTS page successfully")
public void verify_user_is_navigated_to_all_products_page_successfully() {
   String ActualTxt=productspage.AllproductsMsg();
   String ExpTxt="ALL PRODUCTS";
   if(ActualTxt.equals(ExpTxt)) {
		Assert.assertTrue(true);
		log.info("user is navigated to ALL PRODUCTS page successfully");
	} else {
		Assert.assertTrue(false);
		log.warn("user is NOT navigated to ALL PRODUCTS page");
	}  
}
@Then("The products list is visible")
public void the_products_list_is_visible() {
    productspage.AllProducts();
	
    
}
@Then("Click on View Product of first product")
public void click_on_view_product_of_first_product() {
	
	productspage.ViewProduct();
    
}
@Then("User is landed to product detail page")
public void user_is_landed_to_product_detail_page() {
	String Actual=driver.getCurrentUrl();
	
	String Expected="product_details";
	
	if(Actual.contains(Expected)) {
		Assert.assertTrue(true);
		log.info("User is landed to product detail page successfully");
	} else {
		Assert.assertTrue(false);
		log.warn("User is  NOT landed to product detail page");
	}
	
    
    
}
@Then("Verify that detail detail is visible: product name, category, price, availability, condition, brand")
public void verify_that_detail_detail_is_visible_product_name_category_price_availability_condition_brand() {
    
	if(productDetailspage.AllDetailsVisible()==true) {
		Assert.assertTrue(true);
		log.info("All details are visible successfully");
	} else {
		Assert.assertTrue(false);
		log.warn("All details are NOT visible");
	}
	
    
}


//**********TestCase-9: Search product test *********

@Then("Enter product name in search input and click search button")
public void enter_product_name_in_search_input_and_click_search_button() {
    productspage.EnterSearchProduct("Tshirt");
    productspage.search();
}

@Then("Verify {string} products is visible")
public void verify_products_is_visible(String Expected) {
	String Actual=productspage.SearchProducts();
	if(Actual.contains(Expected)) {
		Assert.assertTrue(true);
		log.info("Searched products is visible");
	} else {
		Assert.assertTrue(false);
		log.warn("Searched products is not visible");
	}
}

@Then("Verify all the products related to search are visible")
public void verify_all_the_products_related_to_search_are_visible() {
	productspage.ViewProduct();
	String searchedProduct=productDetailspage.productName();
	
	if(searchedProduct.contains("Tshirt")){
		Assert.assertTrue(true);
		log.info("All the products related to search are visible");
	} else {
		Assert.assertTrue(false);
		log.warn("All the products related to search are  NOT visible");
	}
		
	}

//**********TestCase-10: Verify Subscription in home page *********

@Then("Scroll down to footer")
public void scroll_down_to_footer() {
    homepage.scroll();
    
}
@Then("Verify text {string}")
public void verify_text(String ExpTxt) {
	
	String ActualTxt=homepage.Susbscription();
	if(ActualTxt.equals(ExpTxt)) {
		Assert.assertTrue(true);
		log.info("user is navigated to ALL PRODUCTS page successfully");
	} else {
		Assert.assertTrue(false);
		log.warn("user is NOT navigated to ALL PRODUCTS page");
	}  
    
    
}
@Then("Enter email address in input and click arrow button")
public void enter_email_address_in_input_and_click_arrow_button() {
    homepage.enterEmail("Test677@test.com");
    homepage.subscribe();
    
    
}
@Then("Verify success subscribe message {string} is visible")
public void verify_success_subscribe_message_is_visible(String ExpTxt) {
    
	String ActualTxt=homepage.SuccessMessage();
	if(ActualTxt.equals(ExpTxt)) {
		Assert.assertTrue(true);
		log.info("Success Subscribe Message is Visible");
	} else {
		Assert.assertTrue(false);
		log.warn("Success Subscribe Message is  NOT Visible");
	}  
    
}
    
}




