package com.base.cucumber.util;

import com.base.cucumber.base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;

public class ReusableMethods extends BaseTest {

    static WebDriverWait wait = new WebDriverWait(driver, 10);
    private static final Logger log = Logger.getLogger(String.valueOf(ReusableMethods.class));

    public static void acceptCookies(WebElement acceptButton) {
        try {
            if (acceptButton.isDisplayed()) {
                acceptButton.click();
            }
        } catch (NoSuchElementException e) {
            throw new RuntimeException("No Such Element !");
        }
    }

    public static void clickFunction(WebElement clickElement) {
        log.info("start element <click> process");

        wait.until(ExpectedConditions.elementToBeClickable(clickElement));
        clickElement.click();
        log.info("element <click> process finish successfully");
    }
    public static void sendKeysFunction(WebElement sendKeysElement, String value) {
        log.info("start element <send key> process");

        wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
        sendKeysElement.sendKeys(value);

        log.info("element <send key> process finish successfully");
    }
    public static WebElement selectRandomElement(List<WebElement> elementList, String elementName) {

        if (elementList.isEmpty()) {
            log.info(elementName + " list is empty.");
            return null;
        }

        int randomIndex = new Random().nextInt(elementList.size());
        WebElement selectedElement = elementList.get(randomIndex);

        log.info("Random one " + elementName + " selected: " + selectedElement.getText());

        return selectedElement;
    }

    public static void focusOnNewWindow() {
        String oldWindow = driver.getWindowHandle();
        Set<String> windowSet = driver.getWindowHandles();
        windowSet.remove(oldWindow);
        String newWindow = windowSet.iterator().next();
        driver.switchTo().window(newWindow);
    }

    public static void clickElementIsVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element)).click();
        } catch (TimeoutException t) {
            log.info("element is not visible then continue..");
        }
    }
}
