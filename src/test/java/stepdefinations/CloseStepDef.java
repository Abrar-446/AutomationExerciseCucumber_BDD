package stepdefinations;

import io.cucumber.java.en.And;


public class CloseStepDef extends BaseClass {
	@And("close browser")
	public void close_browser() {
		driver.quit();
		//driver.close();
		log.info("Browser Quit");

		
	}

}
