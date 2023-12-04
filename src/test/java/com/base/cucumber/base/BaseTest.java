package com.base.cucumber.base;

import com.base.cucumber.util.ConfigReader;
import com.base.cucumber.util.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.logging.Logger;

public class BaseTest {
    private static final Logger log = Logger.getLogger(String.valueOf(BaseTest.class));

    @Before
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperties().getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        Driver.closeDriver();
    }
}

