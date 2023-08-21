package PageObject;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramesPage extends BasePage {

    WebDriver ndriver;

    public NestedFramesPage(WebDriver driver) {
        super(driver);
        ndriver = driver;
        PageFactory.initElements(driver, this);
    }



    public void clickAlertFramesWindowsTabDown() {
        waitForElementToBeClickable(alerts_frames_windows_down);
        clickButtonWithJavascript(alerts_frames_windows_down);
        sleep(2);
    }

    public void clickNestedFrames() {
        scrollIntoViewWithJavascript(nested_frames);
        waitForElementToBeClickable(nested_frames);
        clickButtonWithJavascript(nested_frames);
        sleep(2);
    }

    public void printParentFrame() {
        ndriver.switchTo().defaultContent();
        ndriver.switchTo().frame(ndriver.findElement(By.xpath("//*[@id=\"frame1\"]")));
        String parentFrameText = "Parent frame";
        String xpathExpression = "//body[contains(., '" + parentFrameText + "')]";
        WebElement bodyElement = ndriver.findElement(By.xpath(xpathExpression));
        System.out.println("parent frame content: " + bodyElement.getText());
        sleep(1);
    }

    public void printChildFrame() {
        ndriver.switchTo().frame(ndriver.findElements(By.xpath("/html/body/iframe")).get(0));
        String childFrameText = ndriver.findElement(By.cssSelector("body > p")).getAttribute("innerHTML");
        System.out.println("child frame content: " +  childFrameText);
        ndriver.switchTo().defaultContent();
        sleep(1);
    }

    public void clickAlertFramesWindowsTabUp() {
        waitForElementToBeClickable(alerts_frames_windows_up);
        clickButtonWithJavascript(alerts_frames_windows_up);
        sleep(2);
    }

    public void assertParentFrameIsPrinted() {

    }


    @FindBy(xpath = "//div[normalize-space()='Alerts, Frame & Windows']")
    WebElement alerts_frames_windows_down;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/span[1]/div[1]/div[1]")
    WebElement alerts_frames_windows_up;

    @FindBy(xpath = "//span[normalize-space()='Nested Frames']")
    WebElement nested_frames;
}
