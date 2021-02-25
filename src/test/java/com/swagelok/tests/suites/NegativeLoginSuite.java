package com.swagelok.tests.suites;

import com.codeborne.selenide.junit.ScreenShooter;
import com.swagelok.tests.DriverFactory;
import com.swagelok.tests.steps.LoginPageSteps;
import org.junit.*;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class NegativeLoginSuite {

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();


    @BeforeClass
    public static void openLoginPage(){
        DriverFactory.openLoginPage();
    }

    //    TO DO: Need to implement verification for HTML5 validation message
//    @Test
//    public void loginWithoutPassword(){
//        String email = "automation02@zaelab.com";
//
//        LoginPageSteps loginPageSteps = new LoginPageSteps();
//        loginPageSteps.onlyEmail(email);
//    }

    @Test
    public void validEmailIncorrectPassword(){
        String email = "automation01@zaelab.com";
        String pass = "7777";

        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.login(email, pass);
        String link = loginPageSteps.getLink();
        String message = loginPageSteps.checkErrorMessages();

        Assert.assertEquals("User is transferred from login page to: '"+link+"'",
                "https://products.qa.swagelok.com/en/login?error=true",
                link);
        Assert.assertEquals("Validation message is absent or contains invalid text","Your username or password was incorrect.",message);
    }

    @AfterClass
    public static void closeDriver(){
        closeWebDriver();
    }
}
