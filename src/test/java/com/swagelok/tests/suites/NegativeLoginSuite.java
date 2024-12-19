package com.swagelok.tests.suites;

import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.swagelok.pages.LoginPage;
import com.swagelok.tests.steps.LoginPageSteps;
import com.swagelok.utils.DriverFactory;
import com.swagelok.utils.EnvFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@ExtendWith({ScreenShooterExtension.class})
public class NegativeLoginSuite {

    @RegisterExtension
//    static ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension(true).to("target/screenshots");
    private String homeUrl = EnvFactory.getMainUrl();

    @BeforeClass
    public static void openLoginPage(){
        DriverFactory.setTestParameters();
        LoginPageSteps.openLoginPage();
        LoginPage.acceptCookiePolicy();
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
                homeUrl + "login?error=true", link);
        Assert.assertEquals("Validation message is absent or contains invalid text","Your email or password was incorrect.",message);
    }

    @AfterClass
    public static void closeDriver(){
        closeWebDriver();
    }
}
