package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//Features/Login_Test.feature",
		glue="stepDefinition",
		tags="@Sanity",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:target/HtmlReports"
				
		}
		
		)
public class TestRun {

}
