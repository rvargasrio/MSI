package dev.rvargas.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/", 
		glue = "dev.rvargas.steps", 
		tags = {"@AllCenarios" },
		monochrome = true, snippets = SnippetType.CAMELCASE, dryRun = false, strict = false)

public class Runner {

}
