package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Us01_AccessingAllModule_step_Definition {
    private static final Logger log = LoggerFactory.getLogger(Us01_AccessingAllModule_step_Definition.class);
    LoginPage loginPage = new LoginPage();


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("User is already in login Page from Hook");
    }
    @Given("the user logged in asa Store or Sales manager {string}")
    public void the_user_logged_in_asa_store_or_sales_manager(String userType) {
        loginPage.loginWithUsertype(userType);



    }
    @When("the user views the main menu")
    public void the_user_views_the_main_menu() {
        BrowserUtils.waitFor(5);
        int expectedNumberModules = loginPage.mainMenuOptions.size();
        int actualNumberModules = loginPage.mainMenuOptions.size();
        System.out.println("actualNumberModules = " + actualNumberModules);
        Assert.assertEquals("Actual number is not same as the expected one",expectedNumberModules,actualNumberModules);


    }
    @Then("the user should see Eight module names")
    public void theUserShouldSeeEightModuleNames(List<String> expectedModules) {
        System.out.println("allModules = " + expectedModules);
       List<String> actualModule = new ArrayList<>();
        for (WebElement each : loginPage.mainMenuOptions) {
            actualModule.add(each.getText());
        }
        System.out.println("ActualModule = " + actualModule);
        Assert.assertEquals(expectedModules,actualModule);

    }


    @Given("the user logged in as a driver {string}")
    public void theUserLoggedInAsADriver(String userType) {
        loginPage.loginWithUsertype(userType);

    }


    @Then("the user should see Four module names")
    public void theUserShouldSeeFourModuleNames(List<String>expectedModules2) {
        List<String>actualModules = new ArrayList<>();
        for (WebElement each : loginPage.mainMenuOptions) {
            actualModules.add(each.getText());
        }
        Assert.assertEquals(expectedModules2,actualModules);
    }
}
