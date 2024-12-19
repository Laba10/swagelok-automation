package com.swagelok.tests.steps;

import com.swagelok.pages.LoginPage;
import com.swagelok.pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;
import static com.swagelok.page_elements.PopupPageElements.ACCEPT_COOKIE_XPATH;


abstract class SharedSteps {
    private static LoginPage loginPage = new LoginPage();
    private static String email = "automation01@zaelab.com";
    private static String pass = "12341234";

    public static void openLoginPage() {
        loginPage.openLoginPage();
    }

    public static void fastLogin(){
        openLoginPage();
        loginPage.acceptCookiePolicy();
        loginPage.enterLoginAndPass(email, pass);

    }

    public static void acceptCookie() {
            $(ACCEPT_COOKIE_XPATH).click();
            System.out.println("Cookie consent accepted");
    }

    public static void openRegistrationPage(){
        loginPage.openRegistrationPage();
    }

    public static void passCaptcha(){
        RegistrationPage.acceptCaptcha();
    }
}
