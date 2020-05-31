package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/featureFiles", glue = "stepDefinitions", tags = {
		"@Acceptance , @Regression" }, plugin = { "pretty", "html:target/html/" }, monochrome = true)

public class TestRunner {

}
