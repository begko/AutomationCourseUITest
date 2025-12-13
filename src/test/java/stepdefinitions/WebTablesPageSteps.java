package stepdefinitions;

import homework16.pages.WebTablesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebTablesPageSteps {

    WebTablesPage webTablesPage = new WebTablesPage();

    @Given("User is on the Web Tables page")
    public void openWebTablesPage() {
        webTablesPage.openWebTablesPage();
        System.out.println("Step 1 : User opened the Web Tables page");
    }

    @When("User clicks the Add button")
    public void clickAddButton() {
        webTablesPage.clickAddButton();
        System.out.println("Step 2 : User clicked Add button");
    }

    @And("User fills in the new record form with {string} {string} {string} {int} {int} {string}")
    public void fillRecordForm(
            String firstName,
            String lastName,
            String email,
            int age,
            int salary,
            String department) {

        webTablesPage.addRecord(firstName, lastName, email, age, salary, department);
        System.out.println("Step 3 : User filled in the new record form with valid data");
    }

    @And("User submits the form with {string} {string} {string} {int} {int} {string}")
    public void clickSubmitButton(String firstName,
                                  String lastName,
                                  String email,
                                  int age,
                                  int salary,
                                  String department) {
        webTablesPage.clickSubmitButton();
        webTablesPage.verifyRecordInTable(firstName, lastName, email, age, salary, department);
        System.out.println("Step 4 : User clicked Submit button");
    }


    @And("User edits the last added record of first name field with {string}")
    public void editFirstNameField(String newFirstName) {
        webTablesPage.clickEditButton();
        webTablesPage.editRecord(newFirstName);
        System.out.println("Step 5 : User changed name field");
    }

    @Then("User updates the data in the record with {string}")
    public void clickEditSubmitButton(String firstName) {
        webTablesPage.clickSubmitButton();
        webTablesPage.verifyEditRecordInTable(firstName);
        System.out.println("Step 6 : User clicked Submit button");
    }
}
