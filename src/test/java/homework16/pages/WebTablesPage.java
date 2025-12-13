package homework16.pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class WebTablesPage {

    // Define Web Tables Page Elements
    private SelenideElement addButton = $("#addNewRecordButton");
    private SelenideElement firstNameField = $("#firstName");
    private SelenideElement lastNameField = $("#lastName");
    private SelenideElement userEmailField = $("#userEmail");
    private SelenideElement ageField = $("#age");
    private SelenideElement salaryField = $("#salary");
    private SelenideElement departmentField = $("#department");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement editButton = $$("span[title='Edit']").last();

    // Open the Web Tables page
    public void openWebTablesPage() {
        open("https://demoqa.com/webtables");
    }

    // Click the Add button to open the new record form
    public void clickAddButton() {
        addButton.click();
    }

    // Fill in the form with given values and verify that the form is correctly filled
    public void addRecord(String firstName, String lastName, String userEmail, int age, int salary, String department) {
        firstNameField.setValue(firstName);
        lastNameField.setValue(lastName);
        userEmailField.setValue(userEmail);
        ageField.setValue(String.valueOf(age));
        salaryField.setValue(String.valueOf(salary));
        departmentField.setValue(department);

        // Verify that the form fields have correct values
        firstNameField.shouldHave(value(firstName));
        lastNameField.shouldHave(value(lastName));
        userEmailField.shouldHave(value(userEmail));
        ageField.shouldHave(value(String.valueOf(age)));
        salaryField.shouldHave(value(String.valueOf(salary)));
        departmentField.shouldHave(value(department));
    }

    // Verify that the last record in the table matches the given data
    public void verifyRecordInTable(String firstName, String lastName, String email, int age, int salary, String department) {
        // Select the last row dynamically
        ElementsCollection rows = $$("div.rt-tr-group");
        SelenideElement row = rows.findBy(text(email));
        ElementsCollection tableCells = row.$$(".rt-td");

        tableCells.get(0).shouldHave(text(firstName));
        tableCells.get(1).shouldHave(text(lastName));
        tableCells.get(2).shouldHave(text(String.valueOf(age)));
        tableCells.get(3).shouldHave(text(email));
        tableCells.get(4).shouldHave(text(String.valueOf(salary)));
        tableCells.get(5).shouldHave(text(department));
    }

    // Click the Submit button to save the form
    public void clickSubmitButton() {
        submitButton.click();
    }

    // Click the Edit button of the last row
    public void clickEditButton() {
        editButton.scrollTo().click();
    }

    // Edit the first name field of the record and verify the change
    public void editRecord(String firstName) {
        firstNameField.setValue(firstName);

        // Verify that the form field is updated
        firstNameField.shouldHave(value(firstName));
    }

    // Verify that the last record's first name was changed correctly
    public void verifyEditRecordInTable(String firstName) {
        // Select the last row dynamically
        ElementsCollection rows = $$("div.rt-tr-group");
        SelenideElement row = rows.findBy(text(firstName));
        ElementsCollection tableCells = row.$$(".rt-td");

        tableCells.get(0).shouldHave(text(firstName));
    }
}
