package com.vytrack.step_definitions;
import com.vytrack.utilities.ConfigurationReader;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehiclesModelPage;
import com.vytrack.utilities.BrowserUtils;

import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Us04_AccessVehicleContract {

    LoginPage loginPage = new LoginPage();
    VehiclesModelPage vehiclesModelPage = new VehiclesModelPage();

    @When("the user navigates to the Vehicle Contracts page")
    public void the_user_navigates_to_the_vehicle_contracts_page() {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        BrowserUtils.waitFor(3);
        loginPage.fleetModuleFromMainMenu.click();
        loginPage.vehicleContractOption.click();
    }
    @Then("the user should be redirected to the URL {string}")
    public void the_user_should_be_redirected_to_the_url(String expectedUrl) {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals("actual Url is not same as the expected one",expectedUrl,actualUrl);

    }

    @When("the user attempts to navigate to the Vehicle Contracts page")
    public void the_user_attempts_to_navigate_to_the_vehicle_contracts_page() {
        loginPage.fleetModuleFromMainMenuForDriver.click();
      loginPage.vehicleContractOptionForDriverUser.click();
    }
    @Then("the user should see the message {string}")
    public void the_user_should_see_the_message(String expectedMessage) {

        String actualMeesage = loginPage.messageForDriverContract.getText();
        Assert.assertEquals("actual message is not same as the expected",expectedMessage,actualMeesage);

        List<String>allcolumns = new ArrayList<>();
        for (WebElement each : vehiclesModelPage.allHeaderColumnsVehiclePage) {
            System.out.println("allcolumns.add(each.getText()) = " + allcolumns.add(each.getText()));
        }


    }
}
