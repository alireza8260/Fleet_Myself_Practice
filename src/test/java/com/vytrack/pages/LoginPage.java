package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "input[id=prependedInput]")
    public WebElement username;

    @FindBy(css = "input[id=prependedInput2]")
    public WebElement password;

    @FindBy(css = "button[name=_submit]")
    public WebElement loginBtn;

    public void loginWithUsertype(String userType){
        String userName = null;
        String passWord = null;

        if (userType.equalsIgnoreCase("driver")){
            userName = ConfigurationReader.getProperty("driver_username");
            passWord = ConfigurationReader.getProperty("driver_password");
        } else if (userType.equalsIgnoreCase("sales_manager")) {
            userName = ConfigurationReader.getProperty("sales_manager_username");
            passWord = ConfigurationReader.getProperty("sales_manager_password");

        } else if (userType.equalsIgnoreCase("store_manager")) {
            userName = ConfigurationReader.getProperty("store_manager_username");
            passWord = ConfigurationReader.getProperty("store_manager_password");

        }
        username.sendKeys(userName);
        password.sendKeys(passWord);
        loginBtn.click();
    }

    public void loginAsDriver(){
        username.sendKeys(ConfigurationReader.getProperty("driver_username"));
        password.sendKeys(ConfigurationReader.getProperty("driver_password"));
        loginBtn.click();
    }
}
