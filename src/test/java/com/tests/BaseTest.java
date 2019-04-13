package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver _driver;

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        String host = "localhost";
        DesiredCapabilities capabilities;
        if (System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            capabilities = DesiredCapabilities.firefox();
        } else {
            capabilities = DesiredCapabilities.chrome();
        }

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String completeURL = "http://" + host + ":4444/wd/hub";
        capabilities.setCapability("name", ctx.getCurrentXmlTest().getName());
        this._driver = new RemoteWebDriver(new URL(completeURL), capabilities);
        _driver.manage().window().maximize();

    }

    @AfterTest
    public void quitBrowser() {
        _driver.quit();
    }
}
