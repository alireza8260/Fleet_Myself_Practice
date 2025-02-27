package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.PinBarPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Us03_Pinbar_step_Definition {
    LoginPage loginPage = new LoginPage();
    PinBarPage pinBarPage = new PinBarPage();

    @When("the user clicks on the {string} link")
    public void the_user_clicks_on_the_link(String string) {
        loginPage.pinbarLink.click();


    }
    @Then("the user should see the text {string}")
    public void the_user_should_see_the_text(String expectedString) {
        System.out.println("expectedString = " + expectedString);
        String actualFirstMsg = pinBarPage.firstMsg.getText();
        System.out.println("actualFirstMsg = " + actualFirstMsg);
        Assert.assertEquals("actual Msg is not same as the expected one",expectedString,actualFirstMsg);


    }

    @And("the user also should see the text {string}")
    public void theUserAlsoShouldSeeTheText(String expectedString) {
        System.out.println("expectedString = " + expectedString);
        String actualSecondMsg = pinBarPage.secondMsg.getText();
        System.out.println("actualSecondMsg = " + actualSecondMsg);
        Assert.assertEquals("actual Msg is not same as the expected one",expectedString,actualSecondMsg);
    }

    @Then("the user should see an image with the source {string}")
    public void theUserShouldSeeAnImageWithTheSource(String expectedImageSource) {
        BrowserUtils.waitFor(4);
        String actualImageSource = pinBarPage.image.getAttribute("src");
        System.out.println("expectedImageSource = " + expectedImageSource);
        Assert.assertTrue("actual is not contain the expected one",actualImageSource.contains(expectedImageSource));

    }
}
