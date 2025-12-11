package homework16.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class ButtonsPage {

    //Define Buttons Page Elements
    private SelenideElement clickButton = $("#item-4");
    private SelenideElement clickMeButton = $("button.btn-primary:not(#doubleClickBtn,#rightClickBtn)");
    private SelenideElement clickMeMessage = $("#dynamicClickMessage");


    //Open Elements Page
    public void openElementsPage() {
        open("https://demoqa.com/elements");
    }

    //Click Button
    public void clickButtons(){
        clickButton.click();
    }

    //Click Click Me Button
    public void clickClickMeButton(){
        clickMeButton.scrollIntoView(true).click();
    }

    public void verifyButtonName(){
        clickButton.shouldHave(text("Buttons"));
    }

    public void verifyClickMeButton(){
        clickMeButton.shouldHave(text("Click Me"));
    }

    public void verifyClickMeButtonMessage() {
        clickMeMessage.shouldHave(text("You have done a dynamic click"));
    }



}
