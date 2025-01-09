package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features", // Path to your feature files
        glue = "TestDef",// Package containing step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // Reporting
        monochrome = true // Make the console output more readable
)

public class TestRunner extends AbstractTestNGCucumberTests {
}

