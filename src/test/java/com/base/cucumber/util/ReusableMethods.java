package com.base.cucumber.util;

import com.base.cucumber.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.Set;
import org.apache.logging.log4j.Logger;

public class ReusableMethods {

    static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    private static final Logger log =  LogManager.getLogger(ReusableMethods.class);

    public static void clickFunction(WebElement clickElement) {
        try {
            log.info("start element <click> process : " + clickElement);

            wait.until(ExpectedConditions.elementToBeClickable(clickElement));
            clickElement.click();

            log.info("element <click> process finish successfully : " + clickElement);

        } catch (Exception e) {
            throw new CustomException(
                    CustomException.ExceptionMessageEnum.NO_SUCH_ELEMENT,
                    CustomException.ExceptionMessageEnum.NO_SUCH_ELEMENT.getMessage());
        }
    }

    public static void sendKeysFunction(WebElement sendKeysElement, String value) {
        try {
            log.info("start element <send key> process : " + sendKeysElement);

            wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
            sendKeysElement.sendKeys(value);

            log.info("element <send key> process finish successfully : " + sendKeysElement);

        } catch (Exception e) {
            throw new CustomException(
                    CustomException.ExceptionMessageEnum.NO_SUCH_ELEMENT,
                    CustomException.ExceptionMessageEnum.NO_SUCH_ELEMENT.getMessage());
        }
    }

    public static WebElement selectRandomElement(List<WebElement> elementList) {
        WebElement selectedElement = null;
        try {
            int randomIndex = new Random().nextInt(elementList.size());
            selectedElement = elementList.get(randomIndex);
            log.info("Random one selected element: " + selectedElement);
        } catch (Exception e) {
            throw new CustomException(
                    CustomException.ExceptionMessageEnum.RANDOM_ITEM_NOT_FOUND,
                    CustomException.ExceptionMessageEnum.RANDOM_ITEM_NOT_FOUND.getMessage());
        }

        return selectedElement;
    }

    public static void focusOnNewWindow() {
        String oldWindow = Driver.getDriver().getWindowHandle();
        Set<String> windowSet = Driver.getDriver().getWindowHandles();
        windowSet.remove(oldWindow);
        String newWindow = windowSet.iterator().next();
        Driver.getDriver().switchTo().window(newWindow);
    }

    public static void clickElementIsVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element)).click();
        } catch (TimeoutException t) {
            log.info("element is not visible then continue..");
        }
    }
}
