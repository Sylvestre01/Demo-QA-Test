package Utilities.listeners;

import Base.BaseClass;
import Logger.Log;
import Utilities.extentreport.ExtentManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static Utilities.extentreport.ExtentTestManager.getTest;

public class TestListeners extends BaseClass implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Log.info("Process is onStart method " + iTestContext.getName());
        iTestContext.setAttribute("Webdriver", BaseClass.driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.info("Process is onfinish method " + iTestContext.getName());
        ExtentManager.extentReports.flush();
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " is starting");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " has succeeded");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " has failed");
        if (driver != null) {
            String failedScreenShot = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            getTest().log(Status.FAIL, "Test has Failed", getTest().addScreenCaptureFromBase64String(failedScreenShot).getModel().getMedia().get(0));
        } else {
            Log.error("Driver is null. Unable to capture screenshot.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " is skipped");
        getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }
}
