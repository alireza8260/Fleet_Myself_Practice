package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "span[class='title title-level-1']")
    public List<WebElement>mainMenuOptions;

    @FindBy(css = "a[target='_blank']")
    public WebElement questionMark;

    @FindBy(linkText = "Learn how to use this space")
    public WebElement pinbarLink;

    @FindBy(xpath = "(//span[@class='title title-level-1'])[2]")
    public WebElement fleetModuleFromMainMenu;

    @FindBy(xpath = "//span[text()='Vehicle Contracts']")
    public WebElement vehicleContractOption;

    @FindBy(xpath = "(//div[@id='main-menu']//span)[1]")
    public WebElement fleetModuleFromMainMenuForDriver;

    @FindBy(xpath = "(//div[@id='main-menu']//span)[7]")
    public WebElement vehicleContractOptionForDriverUser;

    @FindBy(xpath = "(//div[@class='message'])[2]")
    public WebElement messageForDriverContract;

    @FindBy(linkText = "Vehicles Model")
    public WebElement vehicleModelOptionFromFleet;

}
