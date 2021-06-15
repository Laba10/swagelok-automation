package com.swagelok.utils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class DriverFactory {

    private static WebDriver driver;
    public static WebDriverWait waitVar;


    public static WebDriver getDriver(){
        Assert.assertNotNull("Your driver is null.", driver);
        return driver;
    }

    public static void setTestParameters(){
        timeout = 6000;
        browser = "chrome";
//        browserSize = "780x950";
    }

    public static void close(){
        closeWebDriver();
        System.out.println("WebDriver is closed");
    }
}
