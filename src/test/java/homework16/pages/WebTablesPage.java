package homework16.pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class WebTablesPage {

    //Define Web Tables Page Elements
    private SelenideElement addButton = $("#addNewRecordButton");
    private SelenideElement firstNameField = $("#firstName");
    private SelenideElement lastNameField = $("#lastName");
    private SelenideElement userEmailField = $("#userEmail");
    private SelenideElement ageField = $("#age");
    private SelenideElement salaryField = $("#salary");
    private SelenideElement departmentField = $("#department");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement editButton = $("#edit-record-4");

    public void addRecord(String firstName, String lastName, String userEmail, int age, int salary, String department) {
        //Fill form values
        firstNameField.setValue(firstName);
        lastNameField.setValue(lastName);
        userEmailField.setValue(userEmail);
        ageField.setValue(String.valueOf(age));
        salaryField.setValue(String.valueOf(salary));
        departmentField.setValue(department);

        //Verify from values
        firstNameField.shouldHave(value(firstName));
        lastNameField.shouldHave(value(lastName));
        userEmailField.shouldHave(value(userEmail));
        ageField.shouldHave(value(String.valueOf(age)));
        salaryField.shouldHave(value(String.valueOf(salary)));
        departmentField.shouldHave(value(department));
    }

    public void openWebTablesPage() {
        open("https://demoqa.com/webtables");
    }

    //Click Add button
    public void clickAddButton(){
        addButton.click();
    }

    //Click Submit button
    public void clickSubmitButton(){
        submitButton.click();
    }

    //Click Edit button
    public void clickEditButton() {
        editButton.scrollTo().click();

    }

    public void editRecord(String firstName) {
        //Fill form values
        firstNameField.setValue(firstName);

        //Verify from values
        firstNameField.shouldHave(value(firstName));
    }
}
