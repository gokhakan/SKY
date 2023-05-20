package com.sky.stepDefinitions;

import com.sky.pages.BasePage;
import com.sky.utilities.BrowserUtils;
import com.sky.utilities.ConfigurationReader;
import com.sky.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {
    BasePage basePage = new BasePage();
    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("I navigate to {string}")
    public void i_navigate_to(String tabName) {
        BrowserUtils.waitForPageToLoad(20);
        //Accept all cokies
        Driver.get().switchTo().frame(2);
        Driver.get().findElement(By.xpath("//*[@id=\"notice\"]/div[3]/button[1]")).click();

        basePage.Deals.click();

    }
    @Then("the user should be on the {string} page")
    public void the_user_should_be_on_the_page(String expectedPage) {
        System.out.println("expectedPage = " + expectedPage);
        String expectedPageTitle = "Sky Deals - See our latest offers | Sky.com";
        System.out.println("expectedPageTitle = " + expectedPageTitle);
        String actualPageTitle= Driver.get().getTitle();
        System.out.println("actualPageTitle = " + actualPageTitle);

        switch (expectedPage){
            case "deals":
                Assert.assertEquals(expectedPageTitle, actualPageTitle);
                break;
            default:
                System.out.println("Fail: Page is wrong!");
        }
    }
    @When("I try to sign in with invalid credentials")
    public void i_try_to_sign_in_with_invalid_credentials() {
        System.out.println("Login with invalid email");
    }

    @Then("I should see a box with the text {string}")
    public void i_should_see_a_box_with_the_text(String message) {
        System.out.println(message);
    }

}
