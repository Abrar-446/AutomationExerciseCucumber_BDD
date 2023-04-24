package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepdefinations.BaseClass;

public class PageActions extends BaseClass {
	
	//Method is to movetoelement
	public void MoveHover(WebElement ele) {
		
		Actions act= new Actions(driver);
		
		act.moveToElement(ele).perform();
			
	}
	
	//Mehtod is to Wait using Explicit 
	
	public void explicitWait(int num,WebElement ele) {
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(num));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
	}

	// Method is to click on the element

	public void click(WebElement element) {
		try {
			element.click();

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	// Method is to enter text in textbox field

	public void enterText(WebElement element, String value) {
		try {
			element.clear();
			element.sendKeys(value);

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	// Method is to get the text of webElement
	public String GetText(WebElement element) {

		return element.getText();

	}

	// Method is to generate random string
	public String generateRamdomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	// Method is to generate random numeric digits
	public String generateRamdomNumerals() {
		String generatedString = RandomStringUtils.randomNumeric(5);
		return (generatedString);
	}

	// Method is to generate random Alpha Numeric
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);

		return (st + "@" + num);
	}

	// Method is to select the dropdown using value
	public void selectValueFromDropDownByValue(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByValue(value);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	// Method is to select the dropdown using Visible Text

	public void selectValueFromDropDownBytext(WebElement element, String Text) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(Text);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	// Method is to select the dropdown using index
	public void selectValueFromDropDownByIndex(WebElement element, int index) {
		try {
			Select select = new Select(element);
			select.selectByIndex(index);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	// Method is to capture screesnhot along with timestamp

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

	// Method is to Upload the file using ROBOT class

	public void uploadFile(String file){
		
		StringSelection str = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, (ClipboardOwner) this);

		// creating object of Robot class
		Robot rb;
		try {
			rb = new Robot();
		

		// press Contol+V for pasting
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		// release Contol+V for pasting
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		// for pressing and releasing Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Method is to wait for specific seconds using thread.sleep

	public void waitForSeconds(int seconds) {
		// System.out.println("Waiting for "+seconds+" seconds");

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {

		}
	}

	//Handle Alerts
	
	/*
	 * public void alertAccept(WebDriver driver) {
	 * 
	 * driver.switchTo().alert().accept();
	 * 
	 * }
	 * 
	 * public void alertDismiss(WebDriver driver) {
	 * 
	 * driver.switchTo().alert().dismiss();
	 * 
	 * }
	 * 
	 * public String alertText(WebDriver driver) {
	 * 
	 * return driver.switchTo().alert().getText();
	 * 
	 * }
	 */
	
	public void ScrollDown(WebElement ele) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
		
		
	}
	
	public void JSClick(WebElement ele) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", ele);
		
	}
	
	public String JSGetText() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		 String script = "return   document.getElementByXPath('//span[@id='empty_cart']//b').getText();";
		 String Text = jse.executeScript(script).toString();
		 return Text;
		
	}
	
}
