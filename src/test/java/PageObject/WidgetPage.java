package PageObject;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WidgetPage extends BasePage {

    WebDriver wdriver;

    public WidgetPage(WebDriver driver) {
        super(driver);
        wdriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickWidgetTab() {
        waitForElementToBeClickable(widget);
        clickButtonWithJavascript(widget);
        sleep(2);
    }

    public void clickSlider() {
        scrollIntoViewWithJavascript(slider);
        clickButton(slider);
        sleep(2);
    }

    public void dragSliderTo75() {
        int targetPosition = 128;
        Actions moveSlider = new Actions(wdriver);
        Action action = moveSlider.dragAndDropBy(slider_range, targetPosition, 0).build();
        action.perform();
        sleep(2);
    }


    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[4]/span/div")
    WebElement widget;

    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-3']//*[name()='svg']")
    WebElement slider;

    @FindBy(xpath = "//input[@type='range']")
    WebElement slider_range;
}
