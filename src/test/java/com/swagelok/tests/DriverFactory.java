package com.swagelok.tests;

import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class DriverFactory {

    private static WebDriver driver;
    public static WebDriverWait waitVar;


    public static WebDriver getDriver(){
        Assert.assertNotNull("Your driver is null.", driver);
        return driver;
    }


    public static void openLoginPage(){
        timeout = 4000;
        browser = "chrome";
//        browserSize = "780x950";
        open("https://products.qa.swagelok.com/en/login");
    }

    public static void openRegistrationPage(){
        timeout = 4000;
        browser = "chrome";
        open("https://products.qa.swagelok.com/en/register");
    }

    public static void close(){
        closeWebDriver();
        System.out.println("WebDriver is closed");
    }
}
