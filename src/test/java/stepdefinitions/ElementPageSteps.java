package stepdefinitions;

import homework16.pages.ButtonsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ElementPageSteps {

    ButtonsPage buttonsPage = new ButtonsPage();

    @Given("User is on the page")
    public void openElementPage() {
        buttonsPage.openElementsPage();
        System.out.println("Step 1 : User opened the Elements page");
    }

    @When("User clicks the Buttons button")
    public void clickButton(){
        buttonsPage.clickButtons();
        System.out.println("Step 2 : User clicked Buttons menu");
    }

    @When("User clicks the Click Me button")
    public void clickClickMe(){
        buttonsPage.clickClickMeButton();
        System.out.println("Step 3 : User clicked the Click Me button");
    }

    @Then("User sees a button message")
    public void verifyButtonMessage(){
        buttonsPage.verifyClickMeButtonMessage();
        System.out.println("Step 4 : User sees the correct message");
    }
}
