package com.searchmodule.test;

import com.searchmodule.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest {

    private WebDriver _driver;

    @BeforeTest
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Automation\\chromedriver.exe");
        this._driver = new ChromeDriver();
    }

    @Test
    @Parameters( {"keyword"} )
    public void search(String keyword){
        SearchPage searchPage = new SearchPage(_driver);
        searchPage.goTo();
        searchPage.doSearch(keyword);
        searchPage.goToVideos();
        int size = searchPage.getResults();
        Assert.assertTrue( size > 0);
    }

    @AfterTest
    public void quitBrowser(){
        _driver.quit();
    }
}
