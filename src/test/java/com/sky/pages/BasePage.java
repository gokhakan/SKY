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

}
