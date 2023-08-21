package PageObject;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablesPage extends BasePage {

    WebDriver wdriver;

    public WebTablesPage(WebDriver driver) {
        super(driver);
        wdriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickElementTabDown() {
        clickButton(element_tab_down);
        sleep(2);
    }

    public void clickElementTabUp() {
        clickButton(element_tab_up);
        sleep(2);
    }

    public void clickWebTables() {
        clickButton(web_tables);
        sleep(3);
    }

    public void clickAdd() {
        clickButton(add);
        sleep(2);
    }

    public void enterFirstName(String firstName) {
        waitForElementToBeClickable(first_name);
        setTextElementText(first_name, firstName);
        sleep(2);
    }

    public void enterLastName(String lastName) {
        waitForElementToBeClickable(last_name);
        setTextElementText(last_name, lastName);
        sleep(2);
    }

    public void enterEmail(String email_Add) {
        waitForElementToBeClickable(email);
        setTextElementText(email, email_Add);
        sleep(2);
    }

    public void enterAge(String age) {
        waitForElementToBeClickable(age_field);
        setTextElementText(age_field, age);
        sleep(2);
    }

    public void enterSalary(String salary) {
        waitForElementToBeClickable(salary_field);
        setTextElementText(salary_field, salary);
        sleep(2);
    }

    public void enterDepartment(String department) {
        waitForElementToBeClickable(department_field);
        setTextElementText(department_field, department);
        sleep(2);
    }

    public void clickSubmitBtn() {
        clickButton(submit_btn);
        sleep(5);
    }

    public void clickDeletionBtn() {
        clickButton(delete_icon);
        sleep(2);
    }

    public void assertRecordIsDeleted() {
        By record = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]");
        boolean isElementDeleted = checkIfElementIsDeleted(wdriver, record);
        if (isElementDeleted) {
            System.out.println("record deletion successful.");
        } else {
            System.out.println("record deletion failed.");
        }
    }



    @FindBy(xpath = "//*[name()='path' and contains(@d,'M16 132h41')]")
    WebElement element_tab_down;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]")
    WebElement element_tab_up;

    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-3']//*[name()='svg']")
    WebElement web_tables;

    @FindBy(xpath = "//button[@id='addNewRecordButton']")
    WebElement add;

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement first_name;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement last_name;

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement email;

    @FindBy(xpath = "//input[@id='age']")
    WebElement age_field;

    @FindBy(xpath = "//input[@id='salary']")
    WebElement salary_field;

    @FindBy(xpath = "//input[@id='department']")
    WebElement department_field;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement submit_btn;

    @FindBy(xpath = "//span[@id='delete-record-4']//*[name()='svg']//*[name()='path' and contains(@d,'M864 256H7')]")
    WebElement delete_icon;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]")
    public WebElement record_data;
}
