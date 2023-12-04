package com.base.cucumber.stepdefinitions;

import com.base.cucumber.page.HomePage;
import com.base.cucumber.util.ConfigReader;
import com.base.cucumber.util.Driver;
import com.base.cucumber.util.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Steps {

    private HomePage homePage;

    @When("User goes to home page")
    public void getHomePage() {
        homePage = new HomePage();
    }

    @And("User accepts cookies")
    public void acceptCookies() {
        ReusableMethods.clickFunction(homePage.acceptCookies);
    }

    @Then("Verify user is on homepage")
    public void verifyUserIsOnHomepage() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), ConfigReader.getProperties().getProperty("expected_url"));
    }

    @And("User searches for phone")
    public void searchProduct() {
        ReusableMethods.sendKeysFunction(homePage.searchField, "phone");
        ReusableMethods.clickFunction(homePage.searchButton);
    }

    @And("User selects a random product")
    public void selectRandomProduct() {
        WebElement randomProduct = ReusableMethods.selectRandomElement(homePage.searcProductList);
        ReusableMethods.clickFunction(randomProduct);
    }

    @Then("User adds the product to the cart")
    public void addProductToCart() {
        ReusableMethods.clickFunction(homePage.addToBasketButton);
    }
}
