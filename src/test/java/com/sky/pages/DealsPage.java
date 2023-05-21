package com.sky.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DealsPage extends BasePage{
    @FindBy(xpath = "//*[@class='box__Box-sc-b7ot9u-0 Wrapper-sc-153la9o-0 hPdlro']")
    public List<WebElement>Deals;
}
