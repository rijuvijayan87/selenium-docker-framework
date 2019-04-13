package com.newtours.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver _driver;
    private WebDriverWait wait;

    private @FindBy(name="firstName") WebElement txtFirstName;
    private @FindBy(name="lastName") WebElement txtLastName;
    private @FindBy(name="email") WebElement txtUsername;
    private @FindBy(name="password") WebElement txtPassword;
    private @FindBy(name="confirmPassword") WebElement txtConfirmPassword;
    private @FindBy(name="register") WebElement txtSubmitBtn;


    public RegistrationPage(WebDriver driver){
        this._driver = driver;
        this.wait = new WebDriverWait(_driver, 30);
        PageFactory.initElements(_driver, this);
    }

    public void goTo(){
        this._driver.get("http://newtours.demoaut.com/mercuryregister.php");
        this.wait.until(ExpectedConditions.visibilityOf(this.txtUsername));
    }

    public void enterUserDetails(String firstName, String lastName) {
        this.txtFirstName.sendKeys(firstName);
        this.txtLastName.sendKeys(lastName);
    }

    public void enterUserCredentials(String userName, String password){
        this.txtUsername.sendKeys(userName);
        this.txtPassword.sendKeys(password);
        this.txtConfirmPassword.sendKeys(password);
    }

    public void submit(){
        this.txtSubmitBtn.click();
    }
}
