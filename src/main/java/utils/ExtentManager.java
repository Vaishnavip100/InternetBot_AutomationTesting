package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    public static ExtentReports getInstance() {
        if (extent==null) {
            String reportDir=System.getProperty("user.dir") + "/reports/";
            File dir=new File(reportDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String reportPath=reportDir+"ExtentReport.html";
            ExtentSparkReporter spark=new ExtentSparkReporter(reportPath);
            spark.config().setReportName("Automation Test Results");
            spark.config().setDocumentTitle("InternetBot Report");

            extent=new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}