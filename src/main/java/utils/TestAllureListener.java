package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
//import org.testng.ITestListener;
import org.testng.ITestResult;

import General.TestBase;
import io.qameta.allure.Attachment;


public class TestAllureListener implements ITestListener {



    // Text attachments for Allure
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshotFailure(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    // HTML attachments for Allure
    @Attachment(value = "Stacktrace", type = "text/plain")
    public static String SaveLogs(String message) {
        return message;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshotFailure(TestBase.getDriver());
        SaveLogs(result.getMethod().getConstructorOrMethod().getName());
    }



    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub

    }





    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub

    }

}
