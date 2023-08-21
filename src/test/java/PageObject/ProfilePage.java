package PageObject;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage {

    WebDriver pdriver;

    public ProfilePage(WebDriver driver) {
        super(driver);
        pdriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickElementTab() {
        clickButton(element_tab);
        sleep(2);
    }

    public void clickTextBox() {
        clickButton(text_box);
        sleep(2);
    }

    public void enterFullName(String fullName) {
        waitForElementToBeClickable(full_name);
        setTextElementText(full_name, fullName);
        sleep(2);
    }

    public void enterEmail(String email_Add) {
        waitForElementToBeClickable(email);
        setTextElementText(email, email_Add);
        sleep(2);
    }

    public void enterCurrentAddress(String currentAddress) {
        waitForElementToBeClickable(current_address);
        setTextElementText(current_address, currentAddress);
        sleep(2);
    }

    public void enterPermanentAddress(String permAddress) {
        waitForElementToBeClickable(perm_address);
        setTextElementText(perm_address, permAddress);
        sleep(2);
    }

    public void clickSubmitBtn() {
        scrollIntoViewWithJavascript(submit_btn);
        clickButton(submit_btn);
        sleep(2);
    }


    @FindBy(xpath = "//div[contains(@class,'accordion')]//div[1]//span[1]//div[1]//div[2]//div[2]//*[name()='svg']")
    private WebElement element_tab;

    @FindBy(xpath = "//span[normalize-space()='Text Box']")
    private WebElement text_box;

    @FindBy(xpath = "//input[@id='userName']")
    private WebElement full_name;

    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement email;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement current_address;

    @FindBy(xpath = "//textarea[@id='permanentAddress']")
    private WebElement perm_address;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submit_btn;

    @FindBy(xpath = "//*[@id=\"output\"]/div")
    public WebElement profile_description;
}
