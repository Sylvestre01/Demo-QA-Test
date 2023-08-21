package PageObject;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {

    WebDriver rdriver;

    public RegisterPage(WebDriver driver) {
        super(driver);
        rdriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstName) {
        waitForElementToBeClickable(first_name);
        setTextElementText(first_name, firstName);
        sleep(1);
    }

    public void enterLastName(String lastName) {
        waitForElementToBeClickable(last_name);
        setTextElementText(last_name, lastName);
        sleep(1);
    }

    public void enterUserName(String userName) {
        waitForElementToBeClickable(user_name);
        setTextElementText(user_name, userName);
        sleep(1);
    }

    public void enterPassword(String password) {
        waitForElementToBeClickable(pass_word);
        setTextElementText(pass_word, password);
        sleep(1);
    }

    public void clickReCaptcha() {
        scrollIntoViewWithJavascript(register);
        waitForFrameToBeAvailableAndSwitchToIt(By.xpath("//*[@id=\"g-recaptcha\"]/div/div/iframe"));
        waitForElementToBeClickable(captcha);
        clickButton(captcha);
        sleep(30);
    }

    public void clickRegisterBtn() {
        rdriver.switchTo().parentFrame();
        waitForElementToBeClickable(register);
        clickButton(register);
        sleep(2);
    }

    public void clickBackToLogin() {
        clickButton(back_to_login);
        sleep(2);
    }

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement first_name;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement last_name;

    @FindBy(xpath = "//input[@id='userName']")
    private WebElement user_name;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement pass_word;

    @FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[1]")
    private WebElement captcha;

    @FindBy(xpath = "//button[@id='register']")
    private WebElement register;

    @FindBy(xpath = "//button[@id='gotologin']")
    private WebElement back_to_login;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement login_text;

}

