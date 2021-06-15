package com.swagelok.tests.steps;

import com.swagelok.pages.LoginPage;

public class LoginPageSteps extends SharedSteps{
    private LoginPage loginPage = new LoginPage();

    public void login(String email, String pass){
    loginPage.enterLoginAndPass(email, pass);
    }

    public void onlyEmail(String email){
        loginPage.enterLoginAndSubmit(email);
    }

    public String checkErrorMessages(){
        return loginPage.credentialsErrorMessage();
    }

    public String getLink(){
        return loginPage.getLink();
    }

    public String logout(){
        return loginPage.logout();
    }

    public void redirectToLoginPage(){
        loginPage.openLoginPage();
    }
}
