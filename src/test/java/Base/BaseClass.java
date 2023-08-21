package Base;

import Logger.Log;
import Utilities.ReadConfig;
import Utilities.TakeScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;


    @BeforeClass
    public static void startDriver(){
        ReadConfig readConfig = new ReadConfig();
        if (readConfig.getbrowser().equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readConfig.getDriverPath());
            driver = new ChromeDriver();
            Log.info("chrome browser launched");
        } else if (readConfig.getbrowser().equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", readConfig.getDriverPath());
            driver = new FirefoxDriver();
        } else if (readConfig.getbrowser().equals("edge")) {
            System.setProperty("webdriver.edge.driver", readConfig.getDriverPath());
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        // Global implicit Wait
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @AfterClass
    public  void  tearDown() {
        Log.info("browser closed!");
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }


    @AfterMethod
    public void screenShotOnFailure(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking Screen Shot.....");
            TakeScreenshot.captureScreenShot(driver, testResult.getMethod().getMethodName());
        }
    }

    public void validateFileDownload() {
        ReadConfig config = new ReadConfig();
        String expectedFileName = config.getFileName();
        String downloadFolderPath = config.getDownloadPath();

        File downloadedFile = new File(downloadFolderPath + File.separator + expectedFileName);
        boolean isFileDownloaded = downloadedFile.exists();
        if (isFileDownloaded) {
            System.out.println("File downloaded successfully.");
        } else {
            System.out.println("File download failed.");
        }
    }
}

