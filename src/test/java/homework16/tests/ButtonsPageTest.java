package homework16.tests;

import com.codeborne.selenide.Configuration;
import homework16.pages.ButtonsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ButtonsPageTest {

    @BeforeClass
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
    }

    @Test
    public void clickButtonsTest() {
        ButtonsPage page = new ButtonsPage();

        //Open Elements Page
        page.openElementsPage();

        //Click "Button"
        page.clickButtons();

        //Verify Button name
        page.verifyButtonName();

        //Click "Click Me" button
        page.clickClickMeButton();

        //Verify "Click Me" button text
        page.verifyClickMeButton();

        //Verify "Click Me" button message
        page.verifyClickMeButtonMessage();

    }

}
