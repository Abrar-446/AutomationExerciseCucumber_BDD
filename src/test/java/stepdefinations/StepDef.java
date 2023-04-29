package stepdefinations;

import java.io.File;
import java.time.Duration;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;

import org.mortbay.log.Log;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckOutpage;
import pageObjects.ContactUspage;
import pageObjects.CreateAccountPage;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.PaymentDonepage;
import pageObjects.ProductDetailsPage;
import pageObjects.Productspage;
import pageObjects.TestCasespage;
import pageObjects.ViewCartpage;
import utilities.PageActions;
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
		// PropertyConfigurator.configure("Log4j.properties");
		readConfig = new ReadConfig();
		System.out.println("Setup the browser");

		String browser = readConfig.getBrowser();
		System.out.println(browser);

		// launch browser
		switch (browser.toLowerCase()) {
		case "chrome":
			// Chrome Options for Adblocker extension
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
			// ChromeOptions options = new ChromeOptions();
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

	/*
	 * @After public void onFinish(Scenario scenario) { try { URL url = new
	 * URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
	 * 
	 * // Create the email message ImageHtmlEmail email = new ImageHtmlEmail();
	 * email.setDataSourceResolver(new DataSourceUrlResolver(url));
	 * email.setHostName("smtp.googlemail.com"); email.setSmtpPort(465);
	 * email.setAuthenticator(new
	 * DefaultAuthenticator("pavanoltraining@gmail.com","password"));
	 * email.setSSLOnConnect(true); email.setFrom("pavanoltraining@gmail.com");
	 * //Sender email.setSubject("Test Results");
	 * email.setMsg("Please find Attached Report....");
	 * email.addTo("pavankumar.busyqa@gmail.com"); //Receiver email.attach(url,
	 * "extent report", "please check report..."); email.send(); // send the email }
	 * catch(Exception e) { e.printStackTrace(); } }
	 */
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		loginpage = new Loginpage(driver);
		homepage = new Homepage(driver);
		CreateAccpage = new CreateAccountPage(driver);
		contactUspage = new ContactUspage(driver);
		testcasespage = new TestCasespage(driver);
		productspage = new Productspage(driver);
		productDetailspage = new ProductDetailsPage(driver);
		Viewcartpage = new ViewCartpage(driver);
		Paymentpage = new pageObjects.Paymentpage(driver);
		paymentDonePage = new PaymentDonepage(driver);
		Checkoutpage = new CheckOutpage(driver);

		log.info("Chrome browser Launched");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		log.info("url opened");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// GetWindow handle is used due to Adding extensions for blocking the add
		String parent = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String w : handles) {
			String ActTitle = driver.switchTo().window(w).getTitle();
			String ExpTitle = "Stands Extension";

			if (ActTitle.equals(ExpTitle)) {
				//driver.close();
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
		loginpage.enterSignupName("Test1151");
		loginpage.enterSignupEmail("Test1151@test.com");

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
		CreateAccpage.EnterPwd("test@123");
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
		CreateAccpage.enterFirstName("Test1151_FN");
		CreateAccpage.enterLastName("Test1151_LN");
		CreateAccpage.enterComany("EVRY");
		CreateAccpage.enterAddressOne("Bangalore");
		CreateAccpage.enterAddressTwo("Karnataka");
		CreateAccpage.selectCountry("Canada");
		CreateAccpage.enterState("Karnataka");
		CreateAccpage.enterCity("Bangalore");
		CreateAccpage.enterZipCode("51289");
		CreateAccpage.enterMobNum("9876543210");
		
		/*
		 * String name=CreateAccpage.GetFN_LN(); String
		 * company=CreateAccpage.GetCompany(); String
		 * AddressOne=CreateAccpage.GetAddressOne(); String
		 * AddressTwo=CreateAccpage.GetAddressTwo(); String
		 * City_State_ZIP=CreateAccpage.GetCityStateZipCode(); String
		 * Number=CreateAccpage.GetMobNum();
		 */
		
		

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

		if (loggedin.equals("Test1130")) {
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
		loginpage.enterLoginEmail("Test1128@test.com");
		loginpage.enterLoginPassword("test@123");

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

		String Actualtext = contactUspage.GetInTouch();
		if (Actualtext.equals(Exptext)) {
			Assert.assertTrue(true);
			Log.info("Get in Touch is visible");
		} else {
			Assert.assertTrue(false);
			Log.warn("Get in Touch is NOT visible");

		}

	}

	@Then("Enter name, email, subject and message")
	public void enter_name_email_subject_and_message() {
		contactUspage.EnterName("Test");
		contactUspage.EnterEmail("Test991@test.com");
		contactUspage.EnterSubject("Selenium");
		contactUspage
				.EnterYourMsgTxtArea("This is complete suite of automation tests using SELENIUM, java and Cucucmber");

	}

	@Then("Upload file")
	public void upload_file() {
		contactUspage.ClickUploadFile();

	}

	@Then("Click Submit button")
	public void click_submit_button() {

		contactUspage.ClickSubmit();

	}

	@Then("Click OK buttons")
	public void click_ok_buttons() {
		Alert alert = driver.switchTo().alert();
		String Atext = alert.getText();

		if (Atext.equals("Press OK to proceed!")) {
			alert.accept();
		} else {
			alert.dismiss();
		}

	}

	@Then("Verify success message {string} is visible")
	public void verify_success_message_is_visible(String ExpSuccMsg) {

		String Actualmsg = contactUspage.successMsg();
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
		String Actual = driver.getCurrentUrl();

		String Expected = "test_cases";

		if (Actual.contains(Expected)) {
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
		String ActualTxt = productspage.AllproductsMsg();
		String ExpTxt = "ALL PRODUCTS";
		if (ActualTxt.equals(ExpTxt)) {
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
		String Actual = driver.getCurrentUrl();

		String Expected = "product_details";

		if (Actual.contains(Expected)) {
			Assert.assertTrue(true);
			log.info("User is landed to product detail page successfully");
		} else {
			Assert.assertTrue(false);
			log.warn("User is  NOT landed to product detail page");
		}

	}

	@Then("Verify that detail detail is visible: product name, category, price, availability, condition, brand")
	public void verify_that_detail_detail_is_visible_product_name_category_price_availability_condition_brand() {

		if (productDetailspage.AllDetailsVisible() == true) {
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
		String Actual = productspage.SearchProducts();
		if (Actual.contains(Expected)) {
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
		String searchedProduct = productDetailspage.productName();

		if (searchedProduct.contains("Tshirt")) {
			Assert.assertTrue(true);
			log.info("All the products related to search are visible");
		} else {
			Assert.assertTrue(false);
			log.warn("All the products related to search are  NOT visible");
		}
		
		driver.navigate().back();

	}

//**********TestCase-10,11: Verify Subscription in Home Page/Cart Page *********

	@Then("Scroll down to footer")
	public void scroll_down_to_footer() {
		homepage.scroll();

	}

	@Then("Verify text {string}")
	public void verify_text(String ExpTxt) {

		String ActualTxt = homepage.Susbscription();
		if (ActualTxt.equals(ExpTxt)) {
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

		String ActualTxt = homepage.SuccessMessage();
		if (ActualTxt.equals(ExpTxt)) {
			Assert.assertTrue(true);
			log.info("Success Subscribe Message is Visible");
		} else {
			Assert.assertTrue(false);
			log.warn("Success Subscribe Message is  NOT Visible");
		}

	}

//**********TestCase-12: Add Products in Cart *********

	@Then("Hover over first product and click Add to cart")
	public void hover_over_first_product_and_click_add_to_cart() {
		productspage.FirstHover();

		productspage.FirstAddToCart();
		// pageActions.waitForSeconds(5);

	}

	@Then("Click Continue Shopping button")
	public void click_continue_shopping_button() {
		productspage.waitExplicit();
		productspage.ClickContinueShopping();
		// pageActions.waitForSeconds(2);

	}

	@Then("Hover over second product and click Add to cart")
	public void hover_over_second_product_and_click_add_to_cart() {
		// pageActions.waitForSeconds(1);
		productspage.SecondHover();

		productspage.SecondAddToCart();
		// pageActions.waitForSeconds(1);

	}

	@Then("Click View Cart button")
	public void click_view_cart_button() {
		productspage.ClickViewCart();

	}

	@Then("Verify both products are added to Cart")
	public void verify_both_products_are_added_to_cart() {

		boolean result = Viewcartpage.products();

		if (result == true) {
			Assert.assertTrue(true);
			log.info("Both products added to cart");
		} else {
			Assert.assertTrue(false);
			log.warn("Both products are not added to cart");
		}

	}

	@Then("Verify their prices, quantity and total price")
	public void verify_their_prices_quantity_and_total_price() {

		if (Viewcartpage.FirstProductPrice() == 500 && Viewcartpage.FirstProductQuantity() == 1
				&& Viewcartpage.FirstProductTotal() == 500 && Viewcartpage.SecondProductPrice() == 400
				&& Viewcartpage.SecondProductQuantity() == 1 && Viewcartpage.SecondProductTotal() == 400) {
			Assert.assertTrue(true);
			log.info("Both Product Details are equal");
		} else {
			Assert.assertTrue(false);
			log.warn("Both product Details are not equal");
		}

	}

//**********TestCase-13: Verify Product Quantity in Cart *********
	@Then("Increase quantity to {int}")
	public void increase_quantity_to(Integer int1) {
		String Quantity = Integer.toString(int1);

		productDetailspage.Quantity(Quantity);

	}

	@Then("Click Add to cart button")
	public void click_add_to_cart_button() {
		productDetailspage.ClickAddToCart();

	}

	@Then("Verify that product is displayed in cart page with exact quantity")
	public void verify_that_product_is_displayed_in_cart_page_with_exact_quantity() {
		String ActQuantity = productDetailspage.ProductQuantity();
		if (ActQuantity.equals("4")) {
			Assert.assertTrue(true);
			log.info("Product is displayed in Cart page with Quantity:" + ActQuantity);
		} else {
			Assert.assertTrue(false);
			log.warn("Product is  NOT displayed in Cart page with Quantity:" + ActQuantity);
		}
	}

	@Then("Verify the total price")
	public void verify_the_total_price() {
		int Actualtotal = Viewcartpage.FirstProductTotal();

		if (Actualtotal == 2000) {
			Assert.assertTrue(true);
			log.info("Exact Total price:" + Actualtotal);
		} else {
			Assert.assertTrue(false);
			log.warn("Not Exact Total price:" + Actualtotal);
		}
	}

	// **********TestCase-14: Place Order: Register while Checkout Test case
	// *********

	@Then("Click Cart button")
	public void click_cart_button() {

		homepage.cart();

	}

	@Then("Verify that Cartpage is displayed")
	public void verify_that_cartpage_is_displayed() {
		String Actcart = driver.getCurrentUrl();

		if (Actcart.contains("view_cart")) {
			Assert.assertTrue(true);
			log.info("Cartpage is displayed");
		} else {
			Assert.assertTrue(false);
			log.warn("Cartpage is  NOT displayed");
		}

	}

	@Then("Click Proceed To Checkout")
	public void click_proceed_to_checkout() {
		Viewcartpage.ClickProceedToChkOut();

	}

	@Then("Click Register_Login button in page")
	public void click_register_login_button_in_page() {
		Viewcartpage.ClickRegister_loginLink();

	}

	@Then("Verify Address Details and Review Your Order")
	public void verify_address_details_and_review_your_order() {
		List<String> st = Checkoutpage.YourDeliveryAddInfo();
		// Mr. Test1151_FN Test1151_LN
		if (st.contains("Mr. Test1151_FN Test1151_LN")) {
			Assert.assertTrue(true);
			log.info("Address Details are Displayed");
		} else {
			Assert.assertTrue(false);
			log.warn("Address Details are Displayed");
		}

	}

	@Then("Enter description in comment text area and click Place Order")
	public void enter_description_in_comment_text_area_and_click_place_order() {
		Checkoutpage.EnterTextArea("Extra 50% off.............Hurray");
		Checkoutpage.ClickPlaceOrder();

	}

	@Then("Verify payment page is Displayed")
	public void verify_payment_page_is_displayed() {
		String ActPage = driver.getCurrentUrl();

		if (ActPage.contains("payment")) {
			Assert.assertTrue(true);
			log.info("payment page is Displayed");
		} else {
			Assert.assertTrue(false);
			log.warn("payment page is NOT displayed");
		}

	}

	@Then("Enter payment details: Name on Card, Card Number, CVC, Expiration date")
	public void enter_payment_details_name_on_card_card_number_cvc_expiration_date() {
		Paymentpage.EnterNameOnCard("Abrar");
		Paymentpage.EnterCardNumber("123456989047");
		Paymentpage.EnterCVC("028");
		Paymentpage.EnterExpiry("06");
		Paymentpage.EnterYear("2025");

	}

	@Then("Click Pay and Confirm Order button")
	public void click_pay_and_confirm_order_button() {
		Paymentpage.ClickPayConfirmOrder();

	}

	@Then("Verify success message {string}")
	public void verify_success_message(String ExpMsg) {
		String ActMsg = paymentDonePage.OrderPlacedMessage();
		if (ActMsg.equals(ExpMsg)) {
			Assert.assertTrue(true);
			log.info("Congratulations! Your order has been confirmed");
		} else {
			Assert.assertTrue(false);
			log.warn("Sorry! Your order has NOT been confirmedd");
		}
	}

//**********TestCase-15: Place Order: Register before Checkout Test Case *********  

	// All the Steps of Testcase-14 are common for Testcase-15 too, Just change the
	// structure of execution of steps

	// **********TestCase-16: Place Order: Login before Checkout Test Case *********

	// All the Steps for Testcase-15 is already been implemented in other Test
	// cases, Just need to change the structure of execution of steps

//**********TestCase-17: Remove Products from Cart Test Case *********  

	@Then("Click X button corresponding to particular product")
	public void click_x_button_corresponding_to_particular_product() {
		Viewcartpage.DeleteAllProducts();
	}

	@Then("Verify that product is removed from the cart")
	public void verify_that_product_is_removed_from_the_cart() {

		
		String ExpMsg = "Cart is empty!";

		String ActMsg = Viewcartpage.CartEmptyMessage();
		if (ActMsg.equals(ExpMsg)) {
			Assert.assertTrue(true);
			log.info("Cart is empty! All orders have been successfully deleted");
		} else {
			Assert.assertTrue(false);
			log.warn("Sorry! All orders have NOT been deleted");
		}	
		}
	

		/*
		 * if(Viewcartpage.MSGDisplayed()==true) { Assert.assertTrue(true);
		 * log.info("Cart is empty! All orders have been successfully deleted"); } else
		 * { Assert.assertTrue(false);
		 * log.warn("Sorry! All orders have NOT been deleted"); }
		 */


	//**********TestCase-18: View Category Products Test Case *********  	

@Then("Verify that categories are visible on left side bar")
public void verify_that_categories_are_visible_on_left_side_bar() {
    String ActCat=homepage.categoryLabel();
    String ExpCat="CATEGORY";
    if (ActCat.equals(ExpCat)) {
		Assert.assertTrue(true);
		log.info("categories are visible on left side bar");
	} else {
		Assert.assertTrue(false);
		log.warn("Sorry! categories are NOT visible on left side bar");
	}
    
    
}
@Then("Click on Women category")
public void click_on_women_category() {
	
	homepage.Selectcategory("WOMEN");
    
    
}
@Then("Click on any category link under {string} category, for example: Dress")
public void click_on_any_category_link_under_category_for_example_dress(String string) {
	
	homepage.SelectSubcategory("TOPS");
    
    
}
@Then("Verify that category page is displayed and confirm text {string}")
public void verify_that_category_page_is_displayed_and_confirm_text(String txt) {
    
    if(homepage.AllBrandsLabel().equals(txt)&&driver.getCurrentUrl().contains("category_products")) {
    	Assert.assertTrue(true);
		log.info("category page is displayed and confirm text is Visible");
	} else {
		Assert.assertTrue(false);
		log.warn("Sorry! category page is NOT displayed and confirm text is NOT Visible");
	}
    }

@Then("On left side bar, click on any sub-category link of Men category")
public void on_left_side_bar_click_on_any_sub_category_link_of_men_category() {
	homepage.Selectcategory("MEN");
    
}
@Then("Verify that user is navigated to that category page")
public void verify_that_user_is_navigated_to_that_category_page() {
	if(driver.getCurrentUrl().contains("category_products")) {
    	Assert.assertTrue(true);
		log.info("user is navigated to that category page");
	} else {
		Assert.assertTrue(false);
		log.warn("Sorry! user is NOT navigated to that category page");
	}
    }

//**********TestCase-19: View & Cart Brand Products Test Case *********  

@Then("Verify that Brands are visible on left side bar")
public void verify_that_brands_are_visible_on_left_side_bar() {
    String ActTxt=homepage.BrandLabel();
    String ExpTxt="BRANDS";
    if(ActTxt.equals(ExpTxt)){
    Assert.assertTrue(true);
	log.info("Brands are visible on left side bar");
} else {
	Assert.assertTrue(false);
	log.warn("Sorry! Brands are NOT visible on left side bar");
}
}


@Then("Click on any brand name")
public void click_on_any_brand_name() {
    //homepage.SelectBrand("Biba");
	homepage.ClickBIBA();
    
}
@Then("Verify that user is navigated to brand page and brand products are displayed")
public void verify_that_user_is_navigated_to_brand_page_and_brand_products_are_displayed() {
  String ActTxt=homepage.AllBrandsLabel();
  String ExpTxt="Brand - Biba Products";
  
    if(ActTxt.equalsIgnoreCase(ExpTxt)) {
    	Assert.assertTrue(true);
		log.info("user is navigated to brand page and brand products are displayed");
	} else {
		Assert.assertTrue(false);
		log.warn("Sorry! user is  NOT navigated to brand page and brand products are  NOT displayed");
	}
    }
    
@Then("On left side bar, click on any other brand link")
public void on_left_side_bar_click_on_any_other_brand_link() {
    //homepage.SelectBrand("Polo");
	homepage.ClickPOLO();
}
@Then("Verify that user is navigated to that brand page and can see products")
public void verify_that_user_is_navigated_to_that_brand_page_and_can_see_products() {
	String ActTxt=homepage.AllBrandsLabel();
	  String ExpTxt="Brand - Polo Products";
	  
	    if(ActTxt.equalsIgnoreCase(ExpTxt)) {
	    	Assert.assertTrue(true);
			log.info("user is navigated to brand page and brand products are displayed");
		} else {
			Assert.assertTrue(false);
			log.warn("Sorry! user is  NOTnavigated to brand page and brand products are  NOT displayed");
		}     
}

//**********TestCase-20: Search Products and Verify Cart After Login Test Case *********  

/*
 * @Then("Verify the products related to search are visible") public void
 * verify_the_products_related_to_search_are_visible() { List<String>
 * prod=productspage.GetSearchedProducts();
 * 
 * String ActProd=prod.get(0);
 * 
 * if(ActProd.contains("Tshirt")) {
 * 
 * Assert.assertTrue(true); log.info("products related to search are visible");
 * } else { Assert.assertTrue(false);
 * log.warn("Sorry! products related to search are  NOT visible"); } }
 */
    
@Then("Add those products to cart")
public void add_those_products_to_cart() {
    //driver.navigate().back();
	productspage.MouseHover_AddToCart_ContinueBtn();
	//productspage.ScrollUP();
	productspage.ClickArrow();
	homepage.cart();
   
}
@Then("verify that products are visible in cart")
public void verify_that_products_are_visible_in_cart() {
	List<String>  products=Viewcartpage.CartProducts();
	
	if(products.size()==6) {
		Assert.assertTrue(true);
		log.info("products are visible in cart");
	} else {
		Assert.assertTrue(false);
		log.warn("Sorry! products are NOT visible in cart");
	}   
			
   
}
@Then("Verify that those products are visible in cart after login as well")
public void verify_that_those_products_are_visible_in_cart_after_login_as_well() {
List<String>  products=Viewcartpage.CartProducts();
	
	if(products.size()==6) {
		Assert.assertTrue(true);
		log.info("products are visible in cart after Login");
	} else {
		Assert.assertTrue(false);
		log.warn("Sorry! products are NOT visible in cart after Login");
	}    
}

//**********TestCase-21: Add review on product Test Case *********  

@Then("Verify {string} label information  is visible")
public void verify_label_information_is_visible(String ExpTxt) {
	String ActTxt=productDetailspage.WriteYourReviewLabel();
	
	if(ActTxt.equalsIgnoreCase(ExpTxt)) {
    	Assert.assertTrue(true);
		log.info("Write Your Review Information is Visible");
	} else {
		Assert.assertTrue(false);
		log.warn("Sorry! Write Your Review Information is  NOT Visible");
	} 
    
}
@Then("Enter name, email and review")
public void enter_name_email_and_review() {
    
	productDetailspage.EnterYourName("Test4467");
	productDetailspage.EnterEmailAddress("Test1009@test.com");
	productDetailspage.EnterAddReviewArea("This Product is Really Awesome.... I would Recommend everyone to buy this product.....Thank you very much AutomationExercise for this amazing product");
    
}
@Then("Click Submit button in Product Details page")
public void click_submit_button_in_product_details_page() {
    
	productDetailspage.ClickSubmitBTN();
    
}
@Then("Verify success message with {string} is visible")
public void verify_success_message_with_is_visible(String ExpMsg) {
String ActMsg=productDetailspage.GetThankYouForReviewMsg();
	
	if(ActMsg.equalsIgnoreCase(ExpMsg)) {
    	Assert.assertTrue(true);
		log.info("Thank you for your review! message is Visible");
	} else {
		Assert.assertTrue(false);
		log.warn("Thank you for your review! message is NOT Visible");
	} 
    
}

//**********TestCase-22: Add to cart from Recommended items Test Case *********  

@Then("Scroll to bottom of page")
public void scroll_to_bottom_of_page() {
    homepage.scrollDOWN();;
    
}
@Then("Verify {string} are visible")
public void verify_are_visible(String ExpTxt) {
    
	String ActTxt=homepage.GetRecommendedItemsText();
	
	if(ActTxt.equalsIgnoreCase(ExpTxt)) {
    	Assert.assertTrue(true);
		log.info("Recommended Items Information is Visible");
	} else {
		Assert.assertTrue(false);
		log.warn("Sorry! Recommended Items Information is  NOT Visible");
	} 
    
}
@Then("Click on Add To Cart on Recommended product")
public void click_on_add_to_cart_on_recommended_product() {
    
	homepage.ClickFirstRecommendedITem();
    
}
@Then("Click on View Cart button")
public void click_on_view_cart_button() {
    
	productspage.ClickViewCart();
    
}
@Then("Verify that product is displayed in cart page")
public void verify_that_product_is_displayed_in_cart_page() {
    
	if(Viewcartpage.ProductDisplayed()==true) {
		
		Assert.assertTrue(true);
		log.info("product is displayed in cart page");
	} else {
		Assert.assertTrue(false);
		log.warn("Sorry! product is NOT displayed in cart page");
	} 
}

//**********TestCase-23: Verify address details in checkout page Test Case *********  

@Then("Verify that the delivery address is same address filled at the time registration of account")
public void verify_that_the_delivery_address_is_same_address_filled_at_the_time_registration_of_account() {
	
	List<String> YourdeliveryAdd=Checkoutpage.YourDeliveryAddInfo();
	//Mr. Test1151_FN Test1151_LN
	String name="Mr."+" "+"Test1151_FN"+" "+"Test1151_LN";
	String company="EVRY";
	String AddressOne="Bangalore";
	String AddressTwo="Karnataka";
	String City_State_ZIP="Bangalore"+" "+"Karnataka"+" "+"51289";
	String country="Canada";
	String Number="9876543210";
	if(YourdeliveryAdd.get(0).equals(name)&&
			YourdeliveryAdd.get(1).equals(company)&&
			YourdeliveryAdd.get(2).equals(AddressOne)&&
			YourdeliveryAdd.get(3).equals(AddressTwo)&&
			YourdeliveryAdd.get(4).equals(City_State_ZIP)&&
			YourdeliveryAdd.get(5).equals(country)&&
			YourdeliveryAdd.get(6).equals(Number)) {
		
		Assert.assertTrue(true);
		log.info("delivery address is same address filled at the time registration of account");
	} else {
		Assert.assertTrue(false);
		log.warn("Sorry! Delivery address details are not same");
	} 
	}

//**********TestCase-24: Download Invoice after purchase order Test Case ********* 

@Then("Click Download Invoice button and verify invoice is downloaded successfully")
public void click_download_invoice_button_and_verify_invoice_is_downloaded_successfully() {
	
	paymentDonePage.ClickDownloadInvoice();
	
	boolean result=paymentDonePage.IsFileDownloadedTe();
	
	
		//Assert.assertTrue(PageActions.isFileDownloaded("invoice","txt",6000));

		if (result == true) {
			Assert.assertTrue(true);
			log.info("Invoice is downloaded successfully and available in Downlaods folder");
		} else {
			Assert.assertTrue(false);
			log.warn("Sorry! Invoice is NOT downloaded successfully");
		}

}


//**********TestCase-25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality Test Case ********* 


@Then("Verify {string} text is visible")
public void verify_text_is_visible(String ExpTxt) {
    
	String ActTxt=homepage.GetSubscribeLabel();
	
	if(ActTxt.equals(ExpTxt)) {
		Assert.assertTrue(true);
		log.info("Subscribe text is Visible");
	} else {
		Assert.assertTrue(false);
		log.warn("Sorry! Subscribe text is NOT Visible");
	}
}
@Then("Click on arrow at bottom right side to move upward")
public void click_on_arrow_at_bottom_right_side_to_move_upward() {
    
	productspage.ClickArrow();
    
}
@Then("Verify that page is scrolled up and {string} text is visible on screen")
public void verify_that_page_is_scrolled_up_and_text_is_visible_on_screen(String ExpTxt) {
String ActTxt=homepage.GetFullFledgeTextInfo();
	
	if(ActTxt.equals(ExpTxt)) {
		Assert.assertTrue(true);
		log.info("Full-Fledged practice website for Automation Engineers text is Visible");
	} else {
		Assert.assertTrue(false);
		log.warn("Sorry! Full-Fledged practice website for Automation Engineers text is NOT Visible");
	}
    
}

//**********TestCase-26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality Test Case ********* 

@Then("Scroll up to the top")
public void scroll_up_to_the_top() {
	
	productspage.ScrollUP();
	
}

//Testcase-27: Data Driven testing for Login 


@Then("user enters email as {string} and Password as {string}")
public void user_enters_email_as_and_password_as(String emailadd, String password) {
	
	loginpage.enterLoginEmail(emailadd);
	loginpage.enterLoginPassword(password);
	
}

//Simple login with Data table with single parameters 
@When("Enter correct emailaddress and password with datatable")
public void Enter_correct_emailaddress_and_password_with_datatable(DataTable credentials){
	List<List<String>> data=credentials.cells();
	driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(data.get(0).get(0));
	driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys(data.get(0).get(1));		
}


//  # Simple login with Data table with Multiple parameters-Header
@When("Enter correct emailaddress and password with Multiple data using Datatable Header")
public void Enter_correct_emailaddress_and_password_with_Multiple_data_using_Datatable_Header(DataTable credentials){
	List<Map<String, String>> data=credentials.asMaps(String.class,String.class);
	WebElement email=driver.findElement(By.xpath("//input[@data-qa='login-email']"));
	email.clear();
	email.sendKeys(data.get(0).get("emailaddress"));
	WebElement password=driver.findElement(By.xpath("//input[@data-qa='login-password']"));
	password.clear();
	password.sendKeys(data.get(0).get("password"));
	
	
	
}


}




