package com.base.cucumber.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchField;
    @FindBy(id = "sp-cc-accept")
    public WebElement acceptCookies;
    @FindBy(id = "nav-search-submit-button")
    public WebElement searchButton;
    @FindBy(css = ".s-image")
    public List<WebElement> searcProductList;
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    public WebElement addToBasketButton;

}
