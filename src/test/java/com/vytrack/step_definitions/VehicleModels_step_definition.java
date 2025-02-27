package com.vytrack.step_definitions;

import com.vytrack.pages.VehiclesModelPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class VehicleModels_step_definition {
    VehiclesModelPage vehiclesModelPage = new VehiclesModelPage();

    @When("the user navigates to the Vehicles Model page")
    public void the_user_navigates_to_the_vehicles_model_page() {
        vehiclesModelPage.fleetModuleFromMainMenu.click();
        vehiclesModelPage.vehicleModelOptionFromFleet.click();

    }
    @Then("the user should see the following columns:")
    public void the_user_should_see_the_following_columns(List<String> expectedColumnsList) {
        BrowserUtils.waitFor(3);
        System.out.println("expectedColumnsList = " + expectedColumnsList);
        List<String>actualColumnslist = new ArrayList<>();
        for (WebElement each : vehiclesModelPage.allHeaderColumnsVehiclePage) {
            actualColumnslist.add(each.getText());
        }
        System.out.println("actualColumnslist = " + actualColumnslist);

    }
}
