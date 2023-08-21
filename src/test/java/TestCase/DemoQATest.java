package TestCase;

import Base.BaseClass;
import Logger.Log;
import PageObject.*;
import Utilities.ReadConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static Utilities.extentreport.ExtentTestManager.startTest;

public class DemoQATest extends BaseClass {

    ReadConfig readConfig = new ReadConfig();
    UploadDownloadPage uploadDownloadPage;
    NestedFramesPage nestedFramesPage;
    RegisterPage registerPage;
    ProfilePage profilePage;
    WebTablesPage webTables;
    WidgetPage widgetPage;
    LoginPage loginPage;



    @Test(priority = 1, description = "Verify user can navigate to Demo QA")
    public void navigateToDemoQA(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Demo QA test");
        // navigate to app url
        driver.get(readConfig.getApplicationURL());
        Assert.assertEquals(readConfig.getApplicationURL(), driver.getCurrentUrl());
        Log.info("navigated to demo qa web page");
    }

    @Test(priority = 2, description = "Verify user can select new user")
    public void selectANewUser(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Demo QA test");
        //click on new user to register
        loginPage = new LoginPage(driver);
        loginPage.clickNewUser();
        Log.info("clicked a new user");
    }

    @Test(priority = 3, description = "Verify user can register on the website")
    public void registerAUser(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Demo QA test");
        //capture new user details and register
        registerPage = new RegisterPage(driver);
        registerPage.enterFirstName(readConfig.getFirstname());
        registerPage.enterLastName(readConfig.getLastname());
        registerPage.enterUserName(readConfig.getUsername());
        registerPage.enterPassword(readConfig.getPassword());
        registerPage.clickReCaptcha();
        registerPage.clickRegisterBtn();
        registerPage.clickBackToLogin();
        Assert.assertEquals(registerPage.login_text.getText(), "Login");
        Log.info("registered a new user");
    }

    @Test(priority = 4, description = "Verify user can log in to book store")
    public void loginARegisteredUser(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Demo QA test");
        //login a user with captured details
        loginPage = new LoginPage(driver);
        loginPage.enterUserName(readConfig.getUsername());
        loginPage.enterPassword(readConfig.getPassword());
        loginPage.clickLoginBtn();
        Assert.assertEquals(loginPage.profile_header.getText(), "Profile");
        Log.info("logged in a new user");
    }

    @Test(priority = 5, description = "Verify user can select text box under element tab and capture all the fields")
    public void underElementTabSelectTextBoxAndCaptureAllFields(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Demo QA test");
        //select text box under element tab, capture all fields and submit
        profilePage = new ProfilePage(driver);
        profilePage.clickElementTab();
        profilePage.clickTextBox();
        profilePage.enterFullName(readConfig.getFullName());
        profilePage.enterEmail(readConfig.getEmailAddress());
        profilePage.enterCurrentAddress(readConfig.getCurrentAddress());
        profilePage.enterPermanentAddress(readConfig.getPermanentAddress());
        profilePage.clickSubmitBtn();
        Assert.assertTrue(profilePage.profile_description.isDisplayed());
        Log.info("selected text box under element tab and captured all the fields");
    }

    @Test(priority = 6, description = "Verify user can select web tables under element tab, add and delete a record")
    public void underElementTabSelectWebTablesAddAndDeleteARecord(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Demo QA test");
        //select web tables under element tab, add and delete a record
        webTables = new WebTablesPage(driver);
        webTables.clickElementTabUp();
        webTables.clickElementTabDown();
        webTables.clickWebTables();
        webTables.clickAdd();
        webTables.enterFirstName(readConfig.getFirstname());
        webTables.enterLastName(readConfig.getLastname());
        webTables.enterEmail(readConfig.getEmailAddress());
        webTables.enterAge(readConfig.getAge());
        webTables.enterSalary(readConfig.getSalary());
        webTables.enterDepartment(readConfig.getDepartment());
        webTables.clickSubmitBtn();
        Assert.assertTrue(webTables.record_data.isDisplayed(), "Record addition failed");
        webTables.clickDeletionBtn();
        webTables.assertRecordIsDeleted();
        Log.info("selected web tables under element tab, added and deleted a record");
    }

    @Test(priority = 7, description = "Verify user can select upload and download under element tab, upload and download a file")
    public void underElementTabSelectUploadAndDownloadFile(Method method) {
        startTest(method.getName(),  method.getAnnotation(Test.class).description(), "Demo QA test");
        //select upload and download under element tab, upload and download a file
        uploadDownloadPage = new UploadDownloadPage(driver);
        uploadDownloadPage.clickElementTabUp();
        uploadDownloadPage.clickElementTabDown();
        uploadDownloadPage.clickUploadDownload();
        uploadDownloadPage.uploadAFile();
        Assert.assertTrue(uploadDownloadPage.uploadFile.isDisplayed(), "Upload failed!");
        uploadDownloadPage.downloadFile();
        validateFileDownload();
        uploadDownloadPage.clickElementTabUp();
        Log.info("selected upload and download under element tab, uploaded and downloaded a file");
    }

    @Test(priority = 8, description = "Verify user can select nested frames under alerts,frames and windows tab, print parent and child frame")
    public void underAlertsFramesWindowsTabSelectNestedFrames(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Demo QA test");
        //select nested frames under alerts tab, upload and download a file
        nestedFramesPage = new NestedFramesPage(driver);
        nestedFramesPage.clickAlertFramesWindowsTabDown();
        nestedFramesPage.clickNestedFrames();
        nestedFramesPage.printParentFrame();
        nestedFramesPage.printChildFrame();
        nestedFramesPage.clickAlertFramesWindowsTabUp();
        Log.info("selected nested frames under alerts,frames and windows tab, print parent and child frame");
    }

    @Test(priority = 9, description = "Verify user can select slider under widget tab, drag the displayed slider to 75")
    public void underWidgetTabSelectSlider(Method method) {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "Demo QA test");
        //select slider under widget tab, drag the displayed slider to 75
        widgetPage = new WidgetPage(driver);
        widgetPage.clickWidgetTab();
        widgetPage.clickSlider();
        widgetPage.dragSliderTo75();
        Log.info("selected slider under widget tab, dragged the displayed slider to 75");
    }
}



