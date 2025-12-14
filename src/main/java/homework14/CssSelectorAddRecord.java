package homework14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CssSelectorAddRecord {

    public static void main(String[] args) throws InterruptedException {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Open URL
        driver.get("https://demoqa.com/webtables");

        // Create instance of FindLastEmptyRow class
        FindLastEmptyRow findLastEmptyRow = new FindLastEmptyRow(driver);

        // Get last empty row index
        int lastEmptyRowIndex = findLastEmptyRow.getLastEmptyRowIndex();


        WebElement clickAddButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("#addNewRecordButton"))
        );

        // Scroll to the add button
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickAddButton);
        clickAddButton.click();

        // Assert that the text of the clicked menu item is "Add"
        assert clickAddButton.getText().equals("Add") : "The menu item text is not 'Add'!";

        // Verify that the Add Record modal is visible
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-content")));
        assert modal.isDisplayed() : "Modal did not open!";


        //First name field
        WebElement firsNameField = driver.findElement(By.cssSelector("#firstName"));
        firsNameField.sendKeys("Ayse");

        // Verify input value
        String firsNameFieldValue = firsNameField.getAttribute("value");
        assert firsNameFieldValue.equals("Ayse") : "First Name input value is incorrect!";

        //Last Name Field
        WebElement lastNameField = driver.findElement(By.cssSelector("#lastName"));
        lastNameField.sendKeys("Yilmaz");

        // Verify input value
        String lastNameFieldValue = lastNameField.getAttribute("value");
        assert lastNameFieldValue.equals("Yilmaz") : "Last Name input value is incorrect!";


        //Email Field
        WebElement emailField = driver.findElement(By.cssSelector("#userEmail"));
        emailField.sendKeys("ayseyilmaz@gmail.com");

        // Verify input value
        String emailFieldValue = emailField.getAttribute("value");
        assert emailFieldValue.equals("ayseyilmaz@gmail.com") : "User Email input value is incorrect!";

        //Age Field
        WebElement ageField = driver.findElement(By.cssSelector("#age"));
        ageField.sendKeys("24");

        // Verify input value
        String ageFieldValue = ageField.getAttribute("value");
        assert ageFieldValue.equals("24") : "Age input value is incorrect!";

        //Salary Field
        WebElement salaryField = driver.findElement(By.cssSelector("#salary"));
        salaryField.sendKeys("50000");

        // Verify input value
        String salaryFieldValue = salaryField.getAttribute("value");
        assert salaryFieldValue.equals("50000") : "Salary input value is incorrect!";

        //Department Field
        WebElement departmentField = driver.findElement(By.cssSelector("#department"));
        departmentField.sendKeys("Test Automation");

        // Verify input value
        String departmentFieldValue = departmentField.getAttribute("value");
        assert departmentFieldValue.equals("Test Automation") : "Department input value is incorrect!";

        //Click Submit Button
        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        submitButton.click();

        // Find the rows
        List<WebElement> rows = driver.findElements(By.cssSelector("div.rt-tbody > div.rt-tr-group"));

        // Get the specific row (last empty row)
        WebElement lastEmptyRow = rows.get(lastEmptyRowIndex);

        //Verify that the last record in the table matches the given data
        List<WebElement> cells = lastEmptyRow.findElements(By.cssSelector(".rt-td"));
        assert cells.get(0).getText().equals("Ayse") : "First Name value in table is incorrect!";
        assert cells.get(1).getText().equals("Yilmaz") : "Last Name input value is incorrect!";
        assert cells.get(2).getText().equals("24") : "Age input value is incorrect!";
        assert cells.get(3).getText().equals("ayseyilmaz@gmail.com") : "User Email input value is incorrect!";
        assert cells.get(4).getText().equals("50000") : "Salary input value is incorrect!";
        assert cells.get(5).getText().equals("Test Automation") : "Department input value is incorrect!";


        // Find the edit button in that row (Assuming it's a span with the title 'Edit')
        List<WebElement> edits = driver.findElements(By.cssSelector("span[title='Edit']"));
        WebElement lastEditButton = edits.get(edits.size() - 1);

        // Click the Edit button
        lastEditButton.click();

        // Here you can add further steps like editing values
        WebElement firstNameField = driver.findElement(By.cssSelector("#firstName"));
        firstNameField.clear();
        firstNameField.sendKeys("Fatma");

        // Submit the changes
        WebElement editSubmitButton = driver.findElement(By.cssSelector("#submit"));
        editSubmitButton.click();

        // Wait for table to update
        wait.until(ExpectedConditions.textToBePresentInElement(lastEmptyRow, "Fatma"));

        // Verify that the First Name was updated
        rows = driver.findElements(By.cssSelector("div.rt-tbody > div.rt-tr-group"));
        lastEmptyRow = rows.get(lastEmptyRowIndex);
        String updatedRowText = lastEmptyRow.getText();
        assert updatedRowText.contains("Fatma") : "First Name was NOT updated!";

        // Close the browser
        driver.quit();
    }
}
