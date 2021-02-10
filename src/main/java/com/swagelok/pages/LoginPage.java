package com.swagelok.pages;

import org.junit.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.swagelok.page_elements.LoginPageElements.*;

public class LoginPage extends OverallPage{

    public void isLoginPageOpened(){
        Assert.assertEquals("message", "https://products.qa.swagelok.com/en/login", getLink());
    }

    public void enterLoginAndPass(String email, String pass){
        $(EMAIL_FIELD_XPATH).setValue(email);
        $(PASSWORD_FIELD_XPATH).setValue(pass);
        $(LOG_IN_BUTTON_XPATH).click();
        sscSelectionWindow();
    }

    public void sscSelectionWindow(){
        if($(SSC_SELECTION_WINDOW_XPATH).isDisplayed()){
            $(RANDOM_SSC_VALUE_XPATH).click();
            $(CONTINUE_LOG_IN_BUTTON_XPATH).click();
            System.out.println("During login some SSC was selected");
        } else
        {
            System.out.println("SSC selection window doesnt appeared during login");
        }
    }

    public String credentialsErrorMessage(){
        String message;
        if($(CREDENTIAL_ERROR_MESSAGE_XPATH).exists()){
            message = $(CREDENTIAL_ERROR_MESSAGE_XPATH).getText();
        }else{
            System.out.println("Error message about invalid credentials is absent");
            message = "absent";
        }
        return message;
    }

    public void enterLoginAndSubmit(String email){
        $(EMAIL_FIELD_XPATH).setValue(email);
        $(LOG_IN_BUTTON_XPATH).click();
        String message = $(PASSWORD_FIELD_XPATH).getText();
        System.out.println(message);
    }

}
