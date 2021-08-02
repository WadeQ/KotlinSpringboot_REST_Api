package com.wadektech.springkotlindemo.utils

import com.wadektech.springkotlindemo.resources.IUserResourceImpl
import com.wadektech.springkotlindemo.resources.IUserResourceImpl.Companion.BASE_URL
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.devtools.DevTools
import org.openqa.selenium.devtools.v91.network.Network
import org.openqa.selenium.devtools.v91.network.model.RequestWillBeSent
import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit

open class TestApiEndpoints {
    lateinit var devTools: DevTools
    private lateinit var driver: ChromeDriver

    fun captureHttpRequests() {
        setUpDriver()
//        devTools = driver.getDevTools()
        devTools.createSession()
        devTools.send(Network.enable(
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty()))
        devTools.addListener(Network.requestWillBeSent()) { entry: RequestWillBeSent ->
            println("Request URL is " + entry.request.url)
            println("Request type is " + entry.request.method)
        }

        driver.manage().window().maximize()
        driver[BASE_URL]
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        devTools.send(Network.disable());
    }

    private fun setUpDriver() {
        System.setProperty(
            "webdriver.chrome.driver",
            System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver"
        )
        driver = ChromeDriver()
    }
}