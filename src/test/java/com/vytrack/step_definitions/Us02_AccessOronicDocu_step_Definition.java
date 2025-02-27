package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Us02_AccessOronicDocu_step_Definition {
    String mainWindowId = "";
    LoginPage loginPage = new LoginPage();

    @Given("the user is logged into the application as driver")
    public void the_user_is_logged_into_the_application_as_driver() {
        loginPage.loginAsDriver();
        BrowserUtils.waitFor(3);
        mainWindowId = Driver.getDriver().getWindowHandle();
        System.out.println("mainWindowId = " + mainWindowId);


    }
    @When("the user clicks on the question mark icon")
    public void the_user_clicks_on_the_question_mark_icon() {
        loginPage.questionMark.click();


    }
    @Then("the user should be redirected to the Oroinc Documentation page in a new window")
    public void the_user_should_be_redirected_to_the_oroinc_documentation_page_in_a_new_window() {
        String windowId = Driver.getDriver().getWindowHandle();
        for (String eachWindow : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(eachWindow);
            if (Driver.getDriver().getTitle()=="Welcome to Oro Documentation"){
                return;
            }
        }
        System.out.println("windowId = " + windowId);

    }
    @Then("the title of the new window should contain {string}")
    public void the_title_of_the_new_window_should_contain(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        System.out.println("Driver.getDriver().getWindowHandle() = " + Driver.getDriver().getWindowHandle());
        String windowId2 = Driver.getDriver().getWindowHandle();
        System.out.println("windowId2 = " + windowId2);
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //You can switch to the first window on this way :
        Driver.getDriver().switchTo().window(mainWindowId);
        System.out.println("Driver.getDriver().getWindowHandle() = " + Driver.getDriver().getWindowHandle());

    }
}
