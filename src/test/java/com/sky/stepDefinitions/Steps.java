package com.sky.stepDefinitions;

import com.sky.utilities.ConfigurationReader;
import com.sky.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Steps {
    @Given("I am on the home page")
    public void i_am_on_the_home_page() {

        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String tabName) {
        System.out.println("tabName = " + tabName);


    }
    @Then("the user should be on the {string} page")
    public void the_user_should_be_on_the_page(String expectedPage) {
        System.out.println("expectedPage = " + expectedPage);
    }

}
