package stepdefinations;

//import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.ContactUspage;
import pageObjects.CreateAccountPage;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.ProductDetailsPage;
import pageObjects.Productspage;
import pageObjects.TestCasespage;
import utilities.PageActions;
import utilities.ReadConfig;

/*Parent Class*/
public class BaseClass {

	// Commonly used Methods, pages and variables placed in Base Class

	public static WebDriver driver;
	public PageActions pageActions;
	public Loginpage loginpage;
	public Homepage homepage;
	public CreateAccountPage CreateAccpage;
	public ContactUspage contactUspage;
	public TestCasespage testcasespage;
	public Productspage productspage;
	public ProductDetailsPage productDetailspage;
	
	// public static Logger log;
	public static ReadConfig readConfig;
	public static Logger log;

	// To Generate Random Email Address
	public String generateEmailId() {
		String random = RandomStringUtils.randomAlphabetic(6);
		return random;
	}

	@SuppressWarnings("static-access")
	public void setlog(Logger log) {
		this.log = log;
	}
}
