package com.newtours.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {

    private WebDriver _driver;
    private WebDriverWait wait;

    private @FindBy(partialLinkText = "sign-in") WebElement lnkSignIn;
    private @FindBy(linkText= "Flights") WebElement lnkFlights;

    public RegistrationConfirmationPage(WebDriver driver){
        this._driver = driver;
        wait = new WebDriverWait(_driver, 30);
        PageFactory.initElements(_driver, this);
    }

    public void goToFlightDetailsPage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.lnkSignIn));
        this.lnkFlights.click();
    }

}
