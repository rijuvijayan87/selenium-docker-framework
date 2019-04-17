package com.newtours.tests;

import com.newtours.tests.pages.*;
import com.tests.BaseTest;
import libs.ExecutionListener;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(ExecutionListener.class)
public class BookFlightTest extends BaseTest {

    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setupParameter(String noOfPassengers, String expectedPrice) {
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void registrationPage() {
        System.out.println("Registration page test case");
        RegistrationPage registrationPage = new RegistrationPage(_driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.enterUserCredentials("selenium", "docker");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage() {
        System.out.println("Registration confirmation page test cases");
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(_driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage() {
        System.out.println("Flight Details page test case");
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(_driver);
        flightDetailsPage.selectPassengers(noOfPassengers);
        flightDetailsPage.goToFindFlightsPage();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage() {
        System.out.println("Find flight page test case");
        FindFlightPage findFlightPage = new FindFlightPage(_driver);
        findFlightPage.submitFindFlightsPage();
        findFlightPage.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage() {
        System.out.println("Flight confirmation page test case");
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(_driver);
        String actualPrice = flightConfirmationPage.getPrice();
        Assert.assertEquals(actualPrice, expectedPrice);
    }

}
