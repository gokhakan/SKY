package com.sky.pages;

import com.sky.utilities.Driver;
import io.cucumber.java.ro.Si;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage{

    @FindBy (id="username")
    public WebElement EmailOrUsername;

    @FindBy (xpath = "//*[@id=\"app-component\"]/div/main/div/div[3]/button")
    public WebElement Continue;

}
