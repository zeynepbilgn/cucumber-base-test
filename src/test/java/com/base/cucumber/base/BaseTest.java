package com.base.cucumber.base;

import com.base.cucumber.util.ConfigReader;
import com.base.cucumber.util.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {
    private static final Logger log = LogManager.getLogger(BaseTest.class);
    private static final String SS_DIRECTORY = "src/test/resources/screenshots";

    @Before
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperties().getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            createDirectory();

            try {
                String screenshotPath = SS_DIRECTORY +
                        "/" +
                        Timestamp.valueOf(LocalDateTime.now()).getTime() +
                        "-" +
                        scenario.getName().replace(" ", "") +
                        ".png";
                FileUtils.writeByteArrayToFile(new File(screenshotPath), screenshot);
                scenario.attach(screenshot, "image/png", "screenshots");

            } catch (IOException e) {
                log.info("Getting an error while taking screen shot !: " + e.getMessage());
            }
        }
        Driver.closeDriver();
    }


    private void createDirectory() {
        File directory = new File(BaseTest.SS_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}