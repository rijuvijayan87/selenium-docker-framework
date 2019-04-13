package com.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {

    private WebDriver _driver;
    private WebDriverWait wait;

    private @FindBy(name = "q") WebElement txtSearch;
    private @FindBy(id = "search_button_homepage") WebElement btnSearch;
    private @FindBy(linkText = "Videos") WebElement lnkVideos;
    private @FindBy(className= "tile--vid") List<WebElement> allVideos;

    public SearchPage(WebDriver driver){
        this._driver = driver;
        this.wait = new WebDriverWait(_driver, 30);
        PageFactory.initElements(_driver, this);
    }

    public void goTo(){
        this._driver.get("https://duckduckgo.com");
    }

    public void doSearch(String keyword){
        this.wait.until(ExpectedConditions.visibilityOf(this.txtSearch));
        this.txtSearch.sendKeys(keyword);
        this.btnSearch.click();
    }

    public void goToVideos(){
        this.wait.until(ExpectedConditions.visibilityOf(this.lnkVideos));
        this.lnkVideos.click();
    }

    public int getResults(){
        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
        System.out.println(this.allVideos.size());
        return this.allVideos.size();
    }
}
