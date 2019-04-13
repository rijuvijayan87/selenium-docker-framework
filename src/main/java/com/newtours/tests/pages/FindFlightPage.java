package com.newtours.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {

    private WebDriver _driver;
    private WebDriverWait wait;

    private @FindBy(name = "reserveFlights") WebElement btnFirstSubmit;
    private @FindBy(name = "buyFlights") WebElement btnSecondSubmit;

    public FindFlightPage(WebDriver driver){
        this._driver = driver;
        this.wait = new WebDriverWait(_driver, 30);
        PageFactory.initElements(_driver, this);
    }

    public void submitFindFlightsPage(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.btnFirstSubmit));
        this.btnFirstSubmit.click();
    }

    public void goToFlightConfirmationPage(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.btnSecondSubmit));
        this.btnSecondSubmit.click();
    }

}
