package Utilities.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {


    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("test-report/report.html");
        reporter.config().setReportName("\"DEMO QA REGRESSION TEST REPORT\"");
        reporter.config().thumbnailForBase64();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Test Name", "Demo QA E2E Suite" );
        extentReports.setSystemInfo("Author", "Sylvester Udoh");
        return extentReports;
    }

}
