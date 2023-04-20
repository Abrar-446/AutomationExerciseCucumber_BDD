package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.PageActions;

public class BasePage {

	 WebDriver driver;
	 
	 PageActions pageActions;
	    
	   public BasePage(WebDriver driver)
	     {
		     this.driver=driver;
		     PageFactory.initElements(driver,this);
		     pageActions = new PageActions();
		     
	     }
}
