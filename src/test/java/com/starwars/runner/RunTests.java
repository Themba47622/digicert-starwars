package com.starwars.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/com/starwars/features",
        glue = "com.starwars.steps",
        plugin = { "pretty", "html:target/cucumber-reports/report-ui.html", "json:target/cucumber-reports/report-ui.json" },
        monochrome = true
)
public class RunTests extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
