package com.swagelok.tests.steps;

import com.swagelok.pages.LoginPage;


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

    public static void openRegistrationPage(){
        loginPage.openRegistrationPage();
    }
}
