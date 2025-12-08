package homework15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindLastEmptyRow {

    private WebDriver driver;

    // Constructor
    public FindLastEmptyRow(WebDriver driver) {
        this.driver = driver;
    }

    public int getLastEmptyRowIndex() {
        // Find the rows before adding a new record
        List<WebElement> rowsBefore = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        int oldCount = rowsBefore.size();  // Store the current number of rows

        // Iterate through all rows to find the last empty row
        int lastEmptyRowIndex = -1;
        for (int i = 0; i < rowsBefore.size(); i++) {
            WebElement row = rowsBefore.get(i);
            List<WebElement> cells = row.findElements(By.xpath(".//div[@class='rt-td']"));

            // Check if the row is empty (all cells are empty)
            boolean isRowEmpty = true;
            for (WebElement cell : cells) {
                if (!cell.getText().trim().isEmpty()) {
                    isRowEmpty = false;
                    break;
                }
            }

            // If the row is empty, store the index
            if (isRowEmpty) {
                lastEmptyRowIndex = i;
                break;
            }
        }

        // If no empty row found, last row will be used for editing, otherwise, use the empty row
        if (lastEmptyRowIndex == -1) {
            // No empty row, proceed to the next available row
            lastEmptyRowIndex = rowsBefore.size();  // Set to the next available row
        }

        return lastEmptyRowIndex;
    }
}
