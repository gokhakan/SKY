package com.sky.pages;

import com.sky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy (xpath = "//*[@id=\"masthead-navigation\"]/div/div[1]/div[1]/nav/ul/li[8]/a")
    public WebElement Deals;

    @FindBy(xpath = "//*[@id=\"notice\"]/div[3]/button[1]")
    public WebElement AcceptAll;

    @FindBy (xpath = "//*[@id=\"masthead\"]/div[4]/a")
    public WebElement SignIn;

    @FindBy(xpath = "//button[@id='masthead-search-toggle']")
    public WebElement searchButton;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@data-test-id='editorial-section']")
    public WebElement editorialSection;

}
