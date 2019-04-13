package com.newtours.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

    private WebDriver _driver;
    private WebDriverWait wait;

    private @FindBy(name = "passCount") WebElement passengers;
    private @FindBy(name = "findFlights") WebElement btnSubmit;

    public FlightDetailsPage(WebDriver driver) {
        this._driver = driver;
        wait = new WebDriverWait(_driver, 30);
        PageFactory.initElements(_driver, this);
    }

    public void selectPassengers(String noOfPassengers) {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.passengers));
        Select select = new Select(passengers);
        select.selectByValue(noOfPassengers);
    }

    public void goToFindFlightsPage() {
        this.btnSubmit.click();
    }
}
