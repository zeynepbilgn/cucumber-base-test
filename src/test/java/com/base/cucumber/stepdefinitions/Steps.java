package com.base.cucumber.stepdefinitions;

import com.base.cucumber.base.BaseTest;
import com.base.cucumber.page.HomePage;
import com.base.cucumber.util.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class Steps extends BaseTest {

    private HomePage homePage;
    private static final Logger log = Logger.getLogger(String.valueOf(ReusableMethods.class));

    @When("User goes to home page")
    public void userGoesToHomePage() {
        setUp();
        homePage = new HomePage(driver);
    }
    @And("User accepts cookies")
    public void userAcceptsCookies() {
        ReusableMethods.acceptCookies(homePage.acceptCookies);
    }

    @Then("Verify user is on homepage")
    public void verifyUserIsOnHomepage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.com.tr/");
    }

    @And("User searches for phone")
    public void userSearchesForPhone() {
        ReusableMethods.sendKeysFunction(homePage.searchField, "phone");
        ReusableMethods.clickFunction(homePage.searchButton);
    }

    @And("User selects a random product")
    public void userSelectsARandomProduct() {
        WebElement randomProduct = ReusableMethods.selectRandomElement(homePage.searcProductList,"phone");
        if (randomProduct != null) {
            ReusableMethods.clickFunction(randomProduct);
        } else {
            log.info("Product not found.");
        }
    }

    @Then("User adds the product to the cart")
    public void userAddsTheProductToTheCart() {
        ReusableMethods.clickFunction(homePage.addToBasketButton);
    }

}
