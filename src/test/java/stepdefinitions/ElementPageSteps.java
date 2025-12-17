package stepdefinitions;

import homework16.pages.ButtonsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;


public class ElementPageSteps {

    ButtonsPage buttonsPage = new ButtonsPage();

    @Severity(SeverityLevel.CRITICAL)
    @Step("Step 1: Open the Elements page")
    @Given("User is on the page")
    public void openElementPage() {
        buttonsPage.openElementsPage();
        System.out.println("Step 1 : User opened the Elements page");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Step("Step 2: Click the Buttons menu")
    @When("User clicks the Buttons button")
    public void clickButton() {
        buttonsPage.clickButtons();
        System.out.println("Step 2 : User clicked Buttons menu");
    }

    @Severity(SeverityLevel.NORMAL)
    @Step("Step 3: Click the Click Me button")
    @When("User clicks the Click Me button")
    public void clickClickMe() {
        buttonsPage.clickClickMeButton();
        System.out.println("Step 3 : User clicked the Click Me button");
    }

    @Severity(SeverityLevel.NORMAL)
    @Step("Step 4: Verify the Click Me button message")
    @Then("User sees a button message")
    public void verifyButtonMessage() {
        buttonsPage.verifyClickMeButtonMessage();
        System.out.println("Step 4 : User sees the correct message");
    }
}
