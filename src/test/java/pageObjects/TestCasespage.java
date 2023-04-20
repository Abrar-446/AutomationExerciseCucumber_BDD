package pageObjects;

import java.util.List;

import org.mortbay.log.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasespage extends BasePage {
	
	WebDriver driver;
	
	public TestCasespage(WebDriver driver) {
		super(driver);
	}
	
	//All Test cases
	//@FindBy(xpath="//section[@id='form']/child::div/div[@class='panel-group']")
	@FindBy(xpath="//section[@id='form']/child::div/div[@class='panel-group']/div[@class='panel panel-default']/div//a[@data-toggle='collapse']/u")
	private List<WebElement> AllTestCasesLink;
	
	public void ExpandTestCase() {
		
		for(int i=0;i<=AllTestCasesLink.size()-1;i++) {
			
			String Testcases=AllTestCasesLink.get(i).getText();
			
			Log.info(Testcases);
			AllTestCasesLink.get(i).click();
			pageActions.waitForSeconds(2);
		}
		
	}
	
	public void CollapseTestCase() {
		
		for(int i=AllTestCasesLink.size()-1;i>0;i--) {
			AllTestCasesLink.get(i).click();
			pageActions.waitForSeconds(2);
		}
		
	}
}

	


