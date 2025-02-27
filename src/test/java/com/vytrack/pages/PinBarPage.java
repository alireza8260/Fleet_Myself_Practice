package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinBarPage {
    public PinBarPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@id='container']//h3")
    public WebElement firstMsg;

    @FindBy(xpath = "//div[@id='container']//p")
    public WebElement secondMsg;

    @FindBy(css = "img[src='/bundles/oronavigation/images/pinbar-location.jpg']")
    public WebElement image;
}
