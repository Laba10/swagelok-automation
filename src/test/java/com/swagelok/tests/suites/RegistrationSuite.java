package com.swagelok.tests.suites;


import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.swagelok.tests.steps.RegistrationPageSteps;
import com.swagelok.utils.DriverFactory;
import com.swagelok.utils.EnvFactory;
import org.junit.*;
import org.junit.jupiter.api.extension.RegisterExtension;

import static com.codeborne.selenide.WebDriverRunner.*;

public class RegistrationSuite {

    @RegisterExtension
    static ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension(true).to("target/screenshots");
    private String homeUrl = EnvFactory.getMainUrl();

    @BeforeClass
    public static void openRegistrationPage(){
        DriverFactory.setTestParameters();
        RegistrationPageSteps.openRegistrationPage();
        RegistrationPageSteps.acceptCookie();
        RegistrationPageSteps.passCaptcha();
    }

    @Test
    public void sendRegistrationForm(){
        RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();
        registrationPageSteps.populateRegistrationFields();
        String message = registrationPageSteps.submitRegistration();

        Assert.assertEquals("Current URL:" + url() +" is not equal with url about success registration",
                homeUrl + "register/success", url());

        Assert.assertEquals("Current Head line message: " + message + " is not equal with expected",
                "\n" +
                "                Welcome to Swagelok!", message);
    }

    @Test
    public void additionalFields(){
        RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();
        registrationPageSteps.populateFieldsWithOtherValues();

        Assert.assertTrue("Data was not populated in additional fields that appearing in case selection Other value.",
                registrationPageSteps.verifyPresenceAdditionalFields());

    }

    @After
    public void afterTest(){
        clearBrowserCache();
    }

    @AfterClass
    public static void closeDriver(){
        closeWebDriver();
    }
}
