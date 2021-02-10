package com.swagelok.pages;

import com.swagelok.utils.RandomUtil;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.swagelok.page_elements.RegistrationPageElements.*;

public class RegistrationPage extends OverallPage{

    private RandomUtil randomUtil = new RandomUtil();

    public void populateProfessionalInformation() {
        $(FNAME_FIELD_ID).sendKeys(randomUtil.generateName());
        $(LNAME_FIELD_ID).sendKeys("LName");
        $(PHONE_FIELD_ID).sendKeys(randomUtil.generatePhone());
        $(COMPANY_FIELD_ID).sendKeys("Automation");
        $(COMPANY_TYPE_FABRICATION_VALUE_XPATH).click();
        $(JOB_TYPE_EDUCATION_VALUE_XPATH).click();
    }

    public void populateOtherCompanyType(){
        $(COMPANY_TYPE_OTHER_VALUE_XPATH).click();
        $(COMPANY_TYPE_INPUT_FIELD_ID).sendKeys(randomUtil.generateRandomPassword(9));
    }

    public void populateOtherJobType(){
        $(JOB_TYPE_OTHER_VALUE_XPATH).click();
        $(JOB_TYPE_INPUT_FIELD_ID).sendKeys(randomUtil.generateRandomPassword(7));
    }

    public void populateOtherIndustry(){
        $(INDUSTRY_CHECKBOX_OTHER_VALUE_XPATH).click();
        $(INDUSTRY_INPUT_FIELD_ID).sendKeys("Air autotest77");
    }

    public Boolean verifyValuesInAdditionalFields(){
        Boolean valuesArePresent = true;
        if ($(COMPANY_TYPE_INPUT_FIELD_ID).getText() == null) {
            valuesArePresent = false;
            System.out.println("Value is absent in additional field for Company type"); }

        if ($(JOB_TYPE_INPUT_FIELD_ID).getText() == null) {
            valuesArePresent = false;
            System.out.println("Value is absent in additional field for Job type"); }

        if ($(INDUSTRY_INPUT_FIELD_ID).getText() == null) {
            valuesArePresent = false;
            System.out.println("Value is absent in additional field for Company type"); }
        return valuesArePresent;
    }

    public void populateIndustry() {
        $(INDUSTRY_CHECKBOX_VALUE_XPATH).click();
    }

    public void populateLocation() {
        $(COUNTRY_US_VALUE_XPATH).click();
        $(ZIP_CODE_FIELD_ID).sendKeys("01000");
    }

    public void populateSSC() {
        $(SSC_SELECTION_BUTTON_XPATH).click();
        if(!$(SSC_WINDOW_XPATH).exists()){
            sleep(500);
        }
        $(SSC_US_COUNTRY_VALUE_XPATH).click();
        $(SSC_SEARCH_FIELD_XPATH).sendKeys("Cleveland");
        $(SSC_FIND_BUTTON_XPATH).click();
        $(SSC_SELECT_CENTER_BUTTON_XPATH).click();
    }

    public void populateAccountInformation() {
        $(COMPANY_EMAIL_FIELD_ID).sendKeys("automation1@zaelab.com");
        String pass = randomUtil.generateRandomPassword(11);
        $(PASSWORD_FIELD_ID).sendKeys(pass);
        $(CONFIRM_PASSWORD_FIELD_ID).sendKeys(pass);
    }

    public void populateSitePolicies() {
        $(PRIVACY_POLICY_CHECKBOX_XPATH).click();
        $(TERMS_AND_CONDS_CHECKBOX_XPATH).click();
        $(COOKIE_CHECKBOX_XPATH).click();
//        $(CAPTCHA_CHECKBOX_XPATH).click();
    }

    public void clickRegister(){
        $(REGISTER_BUTTON_XPATH).click();
        sleep(1000);
    }

    public String getHeadLineAfterRegistration(){
        String headerText = $(SUCCESS_HEADER_CLASS).getText();
        return headerText;
    }
}
