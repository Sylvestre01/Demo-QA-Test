package Base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver baseDriver;

    public BasePage(WebDriver driver) {
        baseDriver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void clickButton(WebElement button) {
        button.click();
    }

    protected void clickButtonWithJavascript(WebElement button) {
        JavascriptExecutor executor = (JavascriptExecutor) baseDriver;
        executor.executeScript("arguments[0].click();", button);
    }

    protected void setTextElementText(WebElement fieldTxt, String value) {
        fieldTxt.sendKeys(value);
    }


    protected void scrollIntoViewWithJavascript(WebElement button) {
        JavascriptExecutor executor = (JavascriptExecutor) baseDriver;
        executor.executeScript("arguments[0].scrollIntoView();", button);
        sleep(2);
    }

    protected void clearText(WebElement fieldTxt) {
        fieldTxt.clear();
    }


    protected void sleep(int time) {
        try {
            Thread.sleep(time * 1000);//content of sleep is in MS
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(baseDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForFrameToBeAvailableAndSwitchToIt(By element) {
        WebDriverWait wait = new WebDriverWait(baseDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    // Helper method to check if a record exists in the table
    protected static boolean checkIfElementIsDeleted(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
