package com.swagelok.page_elements;

import org.openqa.selenium.By;

public class RegistrationPageElements {

public static final By FNAME_FIELD_ID = By.id("register.firstName");
public static final By LNAME_FIELD_ID = By.id("register.lastName");
public static final By PHONE_FIELD_ID = By.id("register.phoneNumber");
public static final By COMPANY_FIELD_ID = By.id("register.companyName");
public static final By COMPANY_TYPE_INPUT_FIELD_ID = By.id("register.otherCompanyType");
public static final By JOB_TYPE_INPUT_FIELD_ID = By.id("register.otherTitle");
public static final By INDUSTRY_INPUT_FIELD_ID = By.id("register.otherIndustry");
public static final By COUNTRY_DROP_DOWN_ID = By.id("register.country");
public static final By ZIP_CODE_FIELD_ID = By.id("register.zipCode");
public static final By COMPANY_EMAIL_FIELD_ID = By.id("register.email");
public static final By PASSWORD_FIELD_ID = By.id("password");
public static final By CONFIRM_PASSWORD_FIELD_ID = By.id("register.checkPwd");

public static final By SSC_SELECTION_BUTTON_XPATH = By.xpath("//button[@data-url='/en/store-finder/modal']");
public static final By SSC_WINDOW_XPATH = By.id("cboxContent");
public static final By SSC_COUNTRY_DROP_DOWN_XPATH = By.xpath("//select[@name='countryIso']");
public static final By SSC_US_COUNTRY_VALUE_XPATH = By.xpath("//select[@name='countryIso']/option[@value='US']");
public static final By SSC_SEARCH_FIELD_XPATH = By.xpath("//input[@name='q']");
public static final By SSC_FIND_BUTTON_XPATH = By.xpath("//div[@class='s-store-finder-form__actions']");
public static final By SSC_SELECT_CENTER_BUTTON_XPATH = By.xpath("//button[@data-action-url='/en/getStoreInfo']");

public static final By PRIVACY_POLICY_CHECKBOX_XPATH = By.xpath("//label[@for='privacyPolicyCheckbox']");
public static final By TERMS_AND_CONDS_CHECKBOX_XPATH = By.xpath("//label[@for='termsConditionsCheckbox']");
public static final By COOKIE_CHECKBOX_XPATH = By.xpath("//label[@for='cookiePolicyCheckbox']");
public static final By CAPTCHA_CHECKBOX_XPATH = By.xpath("//div[@class='recaptcha-checkbox-checkmark']");
public static final By REGISTER_BUTTON_XPATH = By.xpath("//button[contains(text(), 'Register')]");

// Values from drop down list
public static final By COMPANY_TYPE_FABRICATION_VALUE_XPATH = By.xpath("//option[@value='fabrication']");
public static final By COMPANY_TYPE_OTHER_VALUE_XPATH = By.xpath("//select[@id='register.companyType']/option[@value='other']");
public static final By JOB_TYPE_EDUCATION_VALUE_XPATH = By.xpath("//option[@value='education']");
public static final By JOB_TYPE_OTHER_VALUE_XPATH = By.xpath("//select[@id='register.title']/option[@value='other']");
public static final By INDUSTRY_CHECKBOX_VALUE_XPATH = By.xpath("//label[@for='oil_gas']");
public static final By INDUSTRY_CHECKBOX_OTHER_VALUE_XPATH = By.xpath("//label[@for='other']");
public static final By COUNTRY_US_VALUE_XPATH = By.xpath("//option[@value='US']");

//Success header
    public static final By SUCCESS_HEADER_CLASS = By.className("s-page-header__headline");
}
