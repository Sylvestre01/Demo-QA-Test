package PageObject;

import Base.BasePage;
import Utilities.ReadConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class UploadDownloadPage extends BasePage {

    WebDriver udriver;

    public UploadDownloadPage(WebDriver driver) {
        super(driver);
        udriver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickElementTabDown() {
        clickButton(element_tab_down);
        sleep(2);
    }

    public void clickUploadDownload() {
        scrollIntoViewWithJavascript(upload_download);
        clickButton(upload_download);
        sleep(2);
    }

    public void uploadAFile() {
        ReadConfig readConfig = new ReadConfig();
        WebElement fileInput = udriver.findElement(By.id("uploadFile"));
        String filePath = readConfig.getUploadFilePath();
        fileInput.sendKeys(filePath);
        sleep(2);
    }

    public void downloadFile() {
        clickButton(download_btn);
        sleep(2);
    }

    public void clickElementTabUp() {
        clickButton(element_tab_up);
        sleep(2);
    }

    @FindBy(xpath = "//*[name()='path' and contains(@d,'M16 132h41')]")
    private WebElement element_tab_down;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]")
    private WebElement element_tab_up;

    @FindBy(xpath = "//span[normalize-space()='Upload and Download']")
    private WebElement upload_download;

    @FindBy(xpath = "//a[@id='downloadButton']")
    private WebElement download_btn;

    @FindBy(id = "uploadedFilePath")
    public WebElement uploadFile;
}
