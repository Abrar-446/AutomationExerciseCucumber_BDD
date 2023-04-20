package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)// this is for Junit
@CucumberOptions(
		// To run multiple feature mention folder name, it will pick all the features
		// files from folder
		//features= ".//Features",
		features = "D:\\iNeuronWorkSpace\\AutomationExercise\\Features\\Subscription_in_homepage_10.feature",
		
		//features = "D:\\iNeuronWorkSpace\\AutomationExercise\\Features\\Register_User_ExistingEmail_005.feature",
		
		
		
		
		//features = { ".//Features/LoginFeature.feature", ".//Features/AddVendor.feature" },
		// features="D:\\Users\\abrar\\eclipse-workspace\\CucumberE2E\\Features\\AddCustomer.feature",

		glue = "stepdefinations",
		// plugin= {"pretty","html:target/CucumberReport/reports.html"},
		// cucumber plugin
		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
		// plugin=
		// {"pretty","html:target/CucumberReport/Report.html","json:target/CucumberReport/Report.json","junit:target/CucumberReport/Report.xml"},
		dryRun = false,
		// strict=true,
		monochrome = true
		// tags= {"@SanityTest"} //execute only sanity Tests
		// tags= {"@End2EndTest or @RegressionTest"}// executes only the scenarios which
		// are comes under sanity OR regression
		//tags= {"@End2EndTest","@RegressionTest"}//executes comes under both Regresion
		// and E2E test
		// Negative specific cases
		// tags= ("not @End2EndTest") //This will ignore E2E scenarios all other
		// scenarios gets executed

		// CODE STUDIO TAGS BELOW
		//tags = "@Regression and @Sanity"
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
