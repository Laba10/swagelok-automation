package com.swagelok.page_elements;

import org.openqa.selenium.By;

public class LoginPageElements {
    private static final By LOG_IN_FORM = By.xpath("//form[@id='loginForm']");
    public static final By EMAIL_FIELD_XPATH = By.xpath("//input[@id='j_username']");
    public static final By PASSWORD_FIELD_XPATH = By.xpath("//input[@id='j_password']");
    public static final By LOG_IN_BUTTON_XPATH = By.xpath("//button[contains(text(),'Log In')]");
    public static final By SSC_SELECTION_WINDOW_XPATH = By.xpath("//div[@id='cboxContent']");
    public static final By RANDOM_SSC_VALUE_XPATH = By.xpath("//div[@class='s-radio']");
    public static final By CONTINUE_LOG_IN_BUTTON_XPATH = By.xpath("//button[contains(text(), 'Continue Log In')]");
    public static final By CREDENTIAL_ERROR_MESSAGE_XPATH = By.xpath("//div[@class='alert alert-danger alert-dismissable getAccAlert']");
    public static final By FORGOT_PASSWORD_LINK_XPATH = By.xpath("//a[@class='js-password-forgotten']");
    public static final By COOKIE_POLICY_ACCEPT = By.xpath("//div[@class='js-cookie-notification-accept s-footer__cookie-disclaimer-close']");
}