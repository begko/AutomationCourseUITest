package homework14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CssSelectorClickButtonTest {

    @Test
    public void clickButtonTest() {

        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Open URL
        driver.get("https://demoqa.com/elements");

        // Wait until the "Buttons" menu item is clickable and click it.
        WebElement clickButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("li#item-4"))
        );
        clickButton.click();

        // Assert that the text of the clicked menu item is "Buttons"
        Assert.assertEquals(clickButton.getText(), "Buttons",
                "The menu item text is not 'Buttons'!");

        // Wait until the target button (excluding double/right click buttons) is clickable
        WebElement clickClickMe = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button.btn-primary:not(#doubleClickBtn,#rightClickBtn)")
                )
        );

        // Scroll to the button
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", clickClickMe);

        // Click the button
        clickClickMe.click();

        // Wait for the message and assert
        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dynamicClickMessage"))
        );
        Assert.assertEquals(message.getText(), "You have done a dynamic click",
                "Button click did not work as expected!");

        // Close the browser
        driver.quit();
    }
}
