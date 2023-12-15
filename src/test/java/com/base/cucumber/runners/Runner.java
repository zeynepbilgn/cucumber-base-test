package com.base.cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/cucumber-reports/cucumber.json",
        },
        features = "src/test/resources/features",
        glue = {"com/base/cucumber/stepdefinitions", "com/base/cucumber/base"},
        tags = "@e2e",
        dryRun = false
)
public class Runner {
}

