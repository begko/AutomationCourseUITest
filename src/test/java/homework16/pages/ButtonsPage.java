package homework16.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class ButtonsPage {

    //Define Buttons Page Elements
    private SelenideElement clickButton = $("#item-4");
    private SelenideElement clickMeButton = $("button.btn-primary:not(#doubleClickBtn,#rightClickBtn)");
    private SelenideElement clickMeMessage = $("#dynamicClickMessage");

    @Step("Open Elements Page")
    //Open Elements Page
    public void openElementsPage() {
        open("https://demoqa.com/elements");
    }

    @Step("Click 'Buttons' button")
    //Click Button
    public void clickButtons() {
        clickButton.click();
    }

    @Step("Click 'Click Me' button")
    //Click Click Me Button
    public void clickClickMeButton() {
        clickMeButton.scrollIntoView(true).click();
    }

    @Step("Verify 'Buttons' button text")
    public void verifyButtonName() {
        clickButton.shouldHave(text("Buttons"));
    }

    @Step("Verify 'Click Me' button")
    public void verifyClickMeButton() {
        clickMeButton.shouldHave(text("Click Me"));
    }

    @Step("Verify 'Click Me' button message")
    public void verifyClickMeButtonMessage() {
        clickMeMessage.shouldHave(text("You have done a dynamic click"));
    }


}
