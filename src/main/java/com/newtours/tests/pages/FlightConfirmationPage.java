package com.newtours.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmationPage {

    private WebDriver _driver;
    private WebDriverWait wait;

    private @FindBy(xpath = "//font[contains(text(), 'Confirmation')]")
    WebElement flightConfirmationHeader;
    private @FindBy(xpath = "//font[contains(text(), 'USD')]")
    List<WebElement> prices;
    private @FindBy(linkText = "SIGN-OFF")
    WebElement signOffLink;

    public FlightConfirmationPage(WebDriver driver) {
        this._driver = driver;
        this.wait = new WebDriverWait(_driver, 30);
        PageFactory.initElements(_driver, this);
    }

    public String getPrice() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationHeader));
        System.out.println(this.flightConfirmationHeader.getText());
        System.out.println(this.prices.get(1).getText());
        String price = this.prices.get(1).getText();
        this.signOffLink.click();
        return price;
    }


}
