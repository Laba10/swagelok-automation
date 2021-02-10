package com.swagelok.tests.steps;

import com.swagelok.pages.RegistrationPage;

public class RegistrationPageSteps {
    private RegistrationPage registrationPage = new RegistrationPage();

    public void populateRegistrationFields() {
        registrationPage.populateProfessionalInformation();
        registrationPage.populateIndustry();
        registrationPage.populateSSC();
        registrationPage.populateLocation();
        registrationPage.populateAccountInformation();
        registrationPage.populateSitePolicies();
    }

    public String submitRegistration(){
        registrationPage.clickRegister();
        String message = registrationPage.getHeadLineAfterRegistration();
        return message;
    }

    public void populateFieldsWithOtherValues(){
        registrationPage.populateOtherCompanyType();
        registrationPage.populateOtherJobType();
        registrationPage.populateOtherIndustry();
    }

    public Boolean verifyPresenceAdditionalFields(){
        return registrationPage.verifyValuesInAdditionalFields();
    }


}
