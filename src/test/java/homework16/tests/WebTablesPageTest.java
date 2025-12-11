package homework16.tests;

import homework16.pages.WebTablesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.codeborne.selenide.Configuration;


public class WebTablesPageTest {

    @Test
    public void addRecordTest() {
        WebTablesPage page = new WebTablesPage();

        //Open Web Tables Page
        page.openWebTablesPage();

        //Click Add button
        page.clickAddButton();

        //Fill Records field and verify all values
        page.addRecord("Ayse", "Yilmaz", "ayseyilmaz@gmail.com", 24, 50000, "Test Automation");

        //Click Submit button
        page.clickSubmitButton();

        //Click Edit button
        page.clickEditButton();

        //Edit Records first name field and verify
        page.editRecord("Fatma");
        page.clickSubmitButton();


    }


}
