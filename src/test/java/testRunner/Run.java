package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@RunWith(Cucumber.class)// this is for Junit
@CucumberOptions(
		// To run multiple feature mention folder name, it will pick all the features
		// files from folder
		//features= ".//Features",
		features = ".\\Features\\Search_Products_and_Verify_Cart_After_Login_20.feature",	
		//features = { ".//Features/LoginFeature.feature", ".//Features/AddVendor.feature" },
		glue = "stepdefinations",
		// plugin= {"pretty","html:target/CucumberReport/reports.html"},
		// cucumber plugin
		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
		// plugin=
		// {"pretty","html:target/CucumberReport/Report.html","json:target/CucumberReport/Report.json","junit:target/CucumberReport/Report.xml"},
		dryRun = false,
		// strict=true,
		monochrome = true
		//tags="@End2End"

		// CODE STUDIO TAGS BELOW
// tags="@Regression or @Sanity" //will run scenarios tagged with Regression or
// sanity
// tags="@Regression and @Sanity" //will run scenarios tagged with Regression as
// well as sanity
// tags=("@Sanity and not @Regression") //will run scenarios tagged with sanity
// but not Regression
)

//Cucumber Notes: Earlier we were using in tags options: ~ replaced with not, {} replaced with (), Comma(,) replaced with |or|
public class Run extends AbstractTestNGCucumberTests {
//public class Run{

}
