package PageObject;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    WebDriver lDriver;

    public LoginPage(WebDriver driver) {
        super(driver);
        lDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickNewUser() {
        clickButton(new_user_btn);
        sleep(2);
    }

    public void enterUserName(String userName) {
        waitForElementToBeClickable(user_name);
        clearText(user_name);
        setTextElementText(user_name, userName);
        sleep(2);
    }

    public void enterPassword(String password) {
        waitForElementToBeClickable(pass_word);
        clearText(pass_word);
        setTextElementText(pass_word, password);
        sleep(2);
    }

    public void clickLoginBtn() {
        clickButton(login_btn);
        sleep(2);
    }


    @FindBy(xpath = "//button[@id='newUser']")
    public WebElement new_user_btn;

    @FindBy(xpath = "//button[@id='login']")
    private WebElement login_btn;

    @FindBy(xpath = "//input[@id='userName']")
    private WebElement user_name;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement pass_word;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement profile_header;
}
