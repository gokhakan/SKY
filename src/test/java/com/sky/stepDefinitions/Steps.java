package com.sky.stepDefinitions;

import com.sky.pages.BasePage;
import com.sky.pages.DealsPage;
import com.sky.pages.SignInPage;
import com.sky.utilities.BrowserUtils;
import com.sky.utilities.ConfigurationReader;
import com.sky.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.logging.Logger;

public class Steps {
    BasePage basePage = new BasePage();
    SignInPage signInPage = new SignInPage();
    DealsPage dealsPage = new DealsPage();
    Logger logger = Logger.getLogger(Steps.class.getName());

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitForPageToLoad(100);
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String tabName) {
        BrowserUtils.waitForPageToLoad(40);
        //Accept all cookies
        Driver.get().switchTo().frame(2);
        Driver.get().findElement(By.xpath("//*[@id=\"notice\"]/div[3]/button[1]")).click();
        BrowserUtils.waitForPageToLoad(100);
        basePage.Deals.click();

    }

    @Then("the user should be on the {string} page")
    public void the_user_should_be_on_the_page(String expectedPage) {
        System.out.println("expectedPage = " + expectedPage);
        String expectedPageTitle = "Sky Deals - See our latest offers | Sky.com";
        System.out.println("expectedPageTitle = " + expectedPageTitle);
        String actualPageTitle = Driver.get().getTitle();
        System.out.println("actualPageTitle = " + actualPageTitle);

        switch (expectedPage) {
            case "deals":
                Assert.assertEquals(expectedPageTitle, actualPageTitle);
                break;
            default:
                logger.info("TEST FAIL: Page is wrong!");
        }
    }

    @When("I try to sign in with invalid credentials")
    public void i_try_to_sign_in_with_invalid_credentials() {
        BrowserUtils.waitForPageToLoad(100);
        //Accept all cookies
        Driver.get().switchTo().frame(2);
        Driver.get().findElement(By.xpath("//*[@id=\"notice\"]/div[3]/button[1]")).click();

        BrowserUtils.waitForPageToLoad(100);
        basePage.SignIn.click();
        BrowserUtils.waitForPageToLoad(100);
        Driver.get().switchTo().frame(1);
        signInPage.EmailOrUsername.sendKeys(ConfigurationReader.get("invalidUserEmail"));
        signInPage.Continue.click();
    }

    @Then("I should see a box with the text {string}")
    public void i_should_see_a_box_with_the_text(String message) {
        System.out.println("message = " + message);
        String expectedPageTitle = "Sign in to your Sky account";
        String actualPageTitle = Driver.get().getTitle();
        System.out.println("actualPageTitle = " + actualPageTitle);
        switch (message) {
            case "Create your My Sky password":
                Assert.assertEquals(expectedPageTitle, actualPageTitle);
                break;
            default:
                logger.info("TEST FAIL: Title not matching");
        }
    }

    @Then("I see a list of deals with a price to it")
    public void i_see_a_list_of_deals_with_a_price_to_it() {
        int numberOfDeals = dealsPage.Deals.size();
        for (int i = 0; i < numberOfDeals; i++) {
            String DealDetails = dealsPage.Deals.get(i).getText();
            String PriceOfDeal = DealDetails.substring(DealDetails.indexOf("£"), DealDetails.indexOf("£") + 3).trim();
            int count = i + 1;
            String PriceOfTestDeal = "dealPrice" + count;
            System.out.println("PriceOfDeal = " + PriceOfDeal);
            System.out.println("PriceOfTestDeal = " + PriceOfTestDeal);
            Assert.assertEquals(ConfigurationReader.get(PriceOfTestDeal), PriceOfDeal);
        }

    }

    @When("I search {string} in the search bar")
    public void i_search_in_the_search_bar(String searchWord) {
        BrowserUtils.waitForPageToLoad(40);

        //Accept all cookies
        Driver.get().switchTo().frame(2);
        Driver.get().findElement(By.xpath("//*[@id=\"notice\"]/div[3]/button[1]")).click();
        BrowserUtils.waitForPageToLoad(100);

        basePage.searchButton.click();
        BrowserUtils.waitForPageToLoad(100);
        basePage.searchBox.sendKeys(searchWord);
        BrowserUtils.waitForPageToLoad(100);

    }

    @Then("I should see an editorial section")
    public void i_should_see_an_editorial_section() {
        BrowserUtils.waitForPageToLoad(100);
        Assert.assertTrue(basePage.editorialSection.isDisplayed());
    }
}
