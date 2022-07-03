package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/features/",
        glue = "stepDefinitions",
        tags = "@Test",
        plugin = { "pretty", "html:target/surefire-reports/cucumber-report" }
)

public class RunTest extends AbstractTestNGCucumberTests { }
