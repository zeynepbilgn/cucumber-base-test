package com.base.cucumber.base;

import com.base.cucumber.util.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ConfigReader.initialize_Properties();
        driver.get(ConfigReader.getProperties().getProperty("url"));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

