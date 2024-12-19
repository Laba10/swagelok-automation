package com.swagelok.tests.suites;



import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.swagelok.pages.LoginPage;
import com.swagelok.tests.steps.LoginPageSteps;
import com.swagelok.utils.DriverFactory;
import com.swagelok.utils.EnvFactory;
import org.junit.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@ExtendWith({ScreenShooterExtension.class})
public class LoginSuite {

    @RegisterExtension
    private String homeUrl = EnvFactory.getMainUrl();


    @BeforeClass
    public static void openLoginPage(){
        DriverFactory.setTestParameters();
        LoginPageSteps.openLoginPage();
        LoginPage.acceptCookiePolicy();
    }

    @Test
    public void swagelokLogin(){
        String email = "automation01@zaelab.com";
//        String email = "oleh.laba@zaelab.com";
        String pass = "12341234";

        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.login(email, pass);
        String currentLink = loginPageSteps.getLink();

        Assert.assertEquals("Next link was opened instead of All products page: '"+currentLink+"'",
                homeUrl, currentLink
        );
    }

    @Test
    public void loginWithSelectionSSC(){
        String email = "automation03@zaelab.com";
//        String email = "oleh.laba@zaelab.com";
        String pass = "12341234";

        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.login(email, pass);
        String currentLink = loginPageSteps.getLink();

        Assert.assertEquals("Next link was opened instead of All products page: '"+currentLink+"'",
                homeUrl, currentLink
        );
    }


    @After
    public void swagelokLogout(){
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        String link =
                loginPageSteps
                        .logout();

        Assert.assertEquals("Next link was opened instead of All Products page: '"+link+"'",
                homeUrl, link
        );
        loginPageSteps.redirectToLoginPage();
    }


    @AfterClass
    public static void closeDriver(){
        closeWebDriver();
    }
}
