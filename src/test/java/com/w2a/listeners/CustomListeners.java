package com.w2a.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.w2a.utilities.ExtentManager;
import com.w2a.utilities.TestUtil;
import org.testng.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;

public class CustomListeners implements ITestListener {

    static Date d = new Date();
    static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
    static String messageBody;
    private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+fileName);
    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();


    public void onTestStart(ITestResult result) {


        ExtentTest test = extent.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());
        testReport.set(test);


    }

    public void onTestSuccess(ITestResult result) {


        String methodName=result.getMethod().getMethodName();
        String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";
        Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        testReport.get().pass(m);


    }

    public void onTestFailure(ITestResult result) {
//        Reporter.log("AddUnit tset successfully executed");
//        Reporter.log("<a target= \"_blank\" href=\"D:\\screenshot\\error.jpg\">Screenshot</a>");
//        Reporter.log("<br>");
//        Reporter.log("<a target= \"_blank\" href=\"D:\\screenshot\\error.jpg\"><img src=\"D:\\screenshot\\error.jpg\" height=200 width=200></img></a>");



        String excepionMessage=Arrays.toString(result.getThrowable().getStackTrace());
        testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
                + "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");

        System.setProperty("org.uncommons.reportng.escape-output", "false");
        try {

            TestUtil.captureScreenshot();
            testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
                    MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotName)
                            .build());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //   Reporter.log("Click to see Screenshot");

        String failureLogg="TEST CASE FAILED";
        Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
        testReport.get().log(Status.FAIL, m);

    }

    public void onTestSkipped(ITestResult result) {
        String methodName=result.getMethod().getMethodName();
        String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";
        Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
//        testReport.get().skip(m);

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onStart(ITestContext context) {



    }

//    public void onFinish(ISuite arg0) {
//
//        MonitoringMail mail = new MonitoringMail();
//
//        try {
//            messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
//                    + ":8080/job/DataDrivenLiveProject/Extent_Reports/";
//        } catch (UnknownHostException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
////        try {
////            mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
////        } catch (AddressException e) {
////            // TODO Auto-generated catch block
////            e.printStackTrace();
////        } catch (MessagingException e) {
////            // TODO Auto-generated catch block
////            e.printStackTrace();
////        }
//
//
//    }

    public void onStart(ISuite arg0) {
        // TODO Auto-generated method stub

    }

    public void onFinish(ITestContext context) {


        if (extent != null) {

            extent.flush();
        }

    }












//    static Date d = new Date();
//    static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
//    static String messageBody;
//    private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+fileName);
//    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
//
//
//    public void onTestStart(ITestResult result) {
//
//
//    }
//
//    public void onTestSuccess(ITestResult result) {
//
//
//    }
//
//    public void onTestFailure(ITestResult result) {
//        System.setProperty("org.uncommons.reportng.escape-output", "false");
//        try {
//            TestUtil.captureScreenshot();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Reporter.log("Capturing screenshot");
////        Reporter.log("<a target=\"_blank\" href=\"D:\\screenshot\\error.png\">Screenshot</a>");
//        Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
//        Reporter.log("<br>");
//     //   Reporter.log("<a target=\"_blank\" href=\"D:\\screenshot\\error.png\"><img src =\"D:\\screenshot\\error.png\" height =200 width=200></img></a>");
//        Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src ="+TestUtil.screenshotName+" height =200 width=200></img></a>");
//
//
//    }
//
//    public void onTestSkipped(ITestResult result) {
//
//
//    }
//
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        // TODO Auto-generated method stub
//
//    }
//
//    public void onStart(ITestContext context) {
//
//
//
//    }
//
//    public void onFinish(ISuite arg0) {
//
//
//    }
//
//    public void onStart(ISuite arg0) {
//        // TODO Auto-generated method stub
//
//    }
//
//    public void onFinish(ITestContext context) {
//
//
//        if (extent != null) {
//
//            extent.flush();
//        }
//
//    }
}
