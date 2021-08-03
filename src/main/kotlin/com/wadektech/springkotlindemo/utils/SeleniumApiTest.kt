package com.wadektech.springkotlindemo.utils

import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.Status
import com.aventstack.extentreports.markuputils.ExtentColor
import com.aventstack.extentreports.markuputils.MarkupHelper
import com.aventstack.extentreports.reporter.ExtentHtmlReporter
import com.aventstack.extentreports.reporter.configuration.Theme
import com.wadektech.springkotlindemo.resources.IUserResourceImpl
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.testng.ITestResult
import org.testng.annotations.*
import java.io.File
import java.lang.reflect.Method
import java.util.concurrent.TimeUnit


open class SeleniumApiTest {
    private var extentHtmlReporter: ExtentHtmlReporter? = null
    /*
    * Here we will be initializing reports
    * */
    @BeforeTest
    fun beforeTestMethod() {
        extentHtmlReporter = ExtentHtmlReporter(
            System.getProperty("user.dir") +
                    File.separator + "reports" +
                    File.separator + "AutomationReport.html"
        )
        extentHtmlReporter!!.config().encoding = "utf-8"
        extentHtmlReporter!!.config().documentTitle = "Automation Report"
        extentHtmlReporter!!.config().reportName = "Automation Test Results"
        extentHtmlReporter!!.config().theme = Theme.DARK
        extentReports = ExtentReports()
        extentReports!!.attachReporter(extentHtmlReporter)
    }

    @BeforeMethod
    fun beforeMethod(testMethod: Method) {
        extentTest = extentReports!!.createTest(testMethod.name)
//        val testApiEndpoints = TestApiEndpoints()
//        setUpDriver()
//        testApiEndpoints.captureHttpRequests(driver)
        driver.manage().window().maximize()
        driver[IUserResourceImpl.BASE_URL]
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    }

    @AfterMethod
    fun afterMethod(iTestResult: ITestResult) {
        if (iTestResult.status == ITestResult.SUCCESS) {
            val methodName = iTestResult.method.methodName
            val logText = "Test case: " + methodName + "Passed"
            val markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN)
            extentTest!!.log(Status.PASS, markup)
        } else if (iTestResult.status == ITestResult.FAILURE) {
            val methodName = iTestResult.method.methodName
            val logText = "Test case: " + methodName + "Failed"
            val markup = MarkupHelper.createLabel(logText, ExtentColor.RED)
            extentTest!!.log(Status.FAIL, markup)
        }
        driver.quit()
    }

    @AfterTest
    fun afterTestMethod() {
        extentReports!!.flush()
    }

    private fun setUpDriver() {
            System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver"
            )
            driver = ChromeDriver()
    }

    companion object Constants {
        lateinit var driver: ChromeDriver
        var extentReports: ExtentReports? = null
        var extentTest: ExtentTest? = null
    }
}