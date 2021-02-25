package com.swagelok.tests.suites;

import com.codeborne.selenide.junit.ScreenShooter;
import com.swagelok.tests.DriverFactory;
import com.swagelok.tests.steps.LoginPageSteps;
import org.junit.*;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;


public class LoginSuite {

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();


    @BeforeClass
    public static void openLoginPage(){
        DriverFactory.openLoginPage();
    }

    @Test
    public void swagelokLogin(){
        String email = "automation01@zaelab.com";
        String pass = "12341234";

        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.login(email, pass);
        String name = loginPageSteps.getLink();

        Assert.assertEquals("Next link was opened instead of All products page: '"+name+"'",
                "https://products.qa.swagelok.com/en/",
                name
        );
    }

    @Test
    public void loginWithSelectionSSC(){
        String email = "automation03@zaelab.com";
        String pass = "12341234";

        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.login(email, pass);
        String name = loginPageSteps.getLink();

        Assert.assertEquals("Next link was opened instead of All products page: '"+name+"'",
                "https://products.qa.swagelok.com/en/",
                name
        );
    }


    @After
    public void swagelokLogout(){
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        String link =
                loginPageSteps
                        .logout();

        Assert.assertEquals("Next link was opened instead of All Products page: '"+link+"'",
                "https://products.qa.swagelok.com/en/",
                link
        );
        loginPageSteps.redirectToLoginPage();
    }


    @AfterClass
    public static void closeDriver(){
        closeWebDriver();
    }
}
