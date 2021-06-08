package com.swagelok.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.swagelok.models.QuickOrderProduct;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.swagelok.page_elements.HeaderPageElements.*;
import static com.swagelok.page_elements.LoginPageElements.COOKIE_POLICY_ACCEPT;
import static com.swagelok.page_elements.PopupPageElements.*;

abstract class OverallPage {

    public void acceptCookiePolicy(){
        $(COOKIE_POLICY_ACCEPT).click();
    }

    public String logout(){
        $(ACCOUNT_BUTTON_XPATH).click();
        $(LOGOUT_BUTTON_XPATH).click();
        return new AllProductsPage().getLink();
    }

    public  String getLink(){
        return url();
    }

    public void openLoginPage(){
        open("https://products.qa.swagelok.com/en/login");
    }

    public void openRegistrationPage(){
        open("https://products.qa.swagelok.com/en/register");
    }

    public void openQuickOrderPage(){
        open("https://products.qa.swagelok.com/en/quickOrder");
    }

    public void openAllProductsPage(){
        open("https://products.qa.swagelok.com/en/");
    }

    public void openCartPage(){
        open("https://products.qa.swagelok.com/en/cart");
    }

    public void typeSearchValue(String value){
        $(SEARCH_FIELD_XPATH).shouldBe(Condition.visible);
        $(SEARCH_FIELD_XPATH).sendKeys(value);
    }

    public void clickSearchButton(){
        $(SEARCH_BUTTON_XPATH).click();
    }

    public void openQuickOrderWindow(){
        $(QUICK_ORDER_BUTTON_XPATH).shouldBe(Condition.visible);
        $(QUICK_ORDER_BUTTON_XPATH).click();
        sleep(500);
    }

    public void clickQuickOrderFormButton(){
        $(QUICK_ORDER_FORM_BUTTON_XPATH).click();
    }

    public void populateDataInQuickOrderForm(ArrayList<QuickOrderProduct> listProducts){
        $(ADD_TO_CART_WINDOW_XPATH).shouldBe(Condition.visible);
        for(int i= 0; i < listProducts.size(); i++){
                QuickOrderProduct productRow = listProducts.get(i);
                SelenideElement e = $$(QUICK_ORDER_FORM_ROW_XPATH).get(i);
                e.find(QUICK_ORDER_FORM_PART_NUMBER_XPATH).sendKeys(productRow.getPartNumber());
                e.find(QUICK_ORDER_FORM_QTY_XPATH).clear();
                e.find(QUICK_ORDER_FORM_QTY_XPATH).sendKeys(productRow.getQty());
        }
    }

    public void clickAddToCartQuickOrder(){
        $(ADD_TO_CART_BUTTON_QUICK_ORDER_FORM).shouldBe(Condition.enabled);
        $(ADD_TO_CART_BUTTON_QUICK_ORDER_FORM).click();
    }

    public Boolean addToCartIsActiveOnForm(){
        return $(ADD_TO_CART_BUTTON_QUICK_ORDER_FORM).isEnabled();
    }

    public void cancelAddToCartPopup(){
        if($(ADD_TO_CART_POPUP_XPATH).isDisplayed()){
            $(CANCEL_BUTTON_ADD_TO_CART_POPUP).click();
        }else {
            System.out.println("Add to cart popup can not be canceled. No popup window.");
        }
    }

    public Boolean checkMessageForPartNumber(){
        String expectedMessage = "Invalid part number";
        $(ERROR_MESSAGE_IN_FORM_PART_NUMBER).shouldBe(Condition.visible);
        if($(ERROR_MESSAGE_IN_FORM_PART_NUMBER).exists()){
            String actualMessage = $(ERROR_MESSAGE_IN_FORM_PART_NUMBER).getText();
            return expectedMessage.equals(actualMessage);
        }
        return false;
    }

    public void clickViewCartButtonAddToCartPopup(){
        $(ADD_TO_CART_POPUP_XPATH).shouldBe(Condition.visible);
        if($(ADD_TO_CART_POPUP_XPATH).isDisplayed()){
            $(VIEW_CART_BUTTON_ADD_TO_CART_POPUP).click();
        } else {
            System.out.println("Add to cart popup is absent");
        }
    }

    public Boolean checkErrorInAddToCartPopup(){
        $(ADD_TO_CART_POPUP_ERROR_MESSAGE).shouldBe(Condition.visible);
        return $(ADD_TO_CART_POPUP_ERROR_MESSAGE).exists();
    }

    public Boolean checkIfCartIsEmpty(){
        boolean cartIsEmpty;
        cartIsEmpty = getCountOfProductsInCart().equals("0");
        return cartIsEmpty;
    }

    public String getCountOfProductsInCart(){
        $(COUNT_OF_PRODUCTS_MINI_CART_ICON_XPATH).shouldBe(Condition.visible);
        String countOfProducts = $(COUNT_OF_PRODUCTS_MINI_CART_ICON_XPATH).getText();
        System.out.println("countOfProducts: " + countOfProducts);
        return countOfProducts;
    }

}
