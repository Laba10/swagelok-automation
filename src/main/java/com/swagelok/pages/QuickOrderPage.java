package com.swagelok.pages;

import com.codeborne.selenide.SelenideElement;
import com.swagelok.models.QuickOrderProduct;

import java.io.File;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.swagelok.page_elements.PopupPageElements.*;
import static com.swagelok.page_elements.QuickOrderPageElements.*;

public class QuickOrderPage extends OverallPage {

    public void resetForm(){
        sleep(1000);

        if($(ADD_TO_CART_BUTTON_XPATH).exists()) {
            if ($(ADD_TO_CART_BUTTON_XPATH).isEnabled()) {
                if ($(QUICK_ORDER_RESET_BUTTON_XPATH).exists()) {
                    $(QUICK_ORDER_RESET_BUTTON_XPATH).click();
                    System.out.println("Quick Order Form is reset/cleared");
                }
            }
        }else {
            System.out.println("Quick Order is not cleared");
        }
    }

    public void addToCart(){
        $(ADD_TO_CART_BUTTON_XPATH).shouldBe(visible);
        $(ADD_TO_CART_BUTTON_XPATH).click();
    }

    public Boolean addToCartIsActiveOnPage(){
        return $(ADD_TO_CART_BUTTON_XPATH).isEnabled();
    }

    public Boolean checkAddToCartPopup(){
        Boolean addToCartPopupAppeared;
        $(POPUP_WINDOW_XPATH).shouldBe(visible);
        if($(ADD_TO_CART_POPUP_XPATH).isDisplayed()){
            addToCartPopupAppeared = true;
        } else {
            addToCartPopupAppeared = false;
            System.out.println("Pop up with results about added products to cart has not appeared");
        }
        return addToCartPopupAppeared;
    }

    public String countOfSuccessfullyAddedProducts(){
        $(MESSAGE_SUCCESSFULLY_ADDED_PRODUCTS_XPATH).shouldBe(visible);
        String message = $(MESSAGE_SUCCESSFULLY_ADDED_PRODUCTS_XPATH).getText();
        String actual = message.substring(0,1);
        return actual;
    }

    public Boolean checkThatPartNumberRowsEmpty(){
        for(SelenideElement e : $$(QUICK_ORDER_ROW_XPATH)){
            if(e.find(UNIVERSAL_NOTES_NUMBER_ROW_XPATH).exists()){
                String productNumberValue = e.find(UNIVERSAL_PART_NUMBER_ROW_XPATH).getText();
                if(productNumberValue.length() != 0){
                    return false;
                }
            }
        }
        return  true;
    }

    public Boolean qtyFieldsEmpty(){
        for(SelenideElement e : $$(QUICK_ORDER_ROW_XPATH)){
            if(e.find(UNIVERSAL_NOTES_NUMBER_ROW_XPATH).exists()){
                String qtyValue = e.find(UNIVERSAL_QTY_NUMBER_ROW_XPATH).getText();
                if(qtyValue.length() != 0){
                    return false;
                }
            }
        }
        return  true;
    }

    public Boolean notesFieldsEmpty(){

        for(SelenideElement e : $$(QUICK_ORDER_ROW_XPATH)){
            if(e.find(UNIVERSAL_NOTES_NUMBER_ROW_XPATH).exists()){
                String noteValue = e.find(UNIVERSAL_NOTES_NUMBER_ROW_XPATH).getText();
                if(noteValue.length() != 0){
                    return false;
                }
            }
        }
        return  true;
    }

    public void uploadBulkFile(){
        File bulkFile = new File("src/test/resources/bulkFiles/SwagelokPartUploadtest2.csv");
        $(INPUT_FILE_XPATH).uploadFile(bulkFile);
    }

    public void addToCartBulkFile(){
        $(ADD_TO_CART_BULK_XPATH).click();
        if ($(CONFIRMATION_FILE_UPLOADING_XPATH).isDisplayed()){
            $(ADD_TO_CART_BULK_XPATH).click();
            $(POPUP_WINDOW_XPATH).shouldBe(visible);
        }else {
            System.out.println("No confirmation message about succesfull bulk uploading");
        }
    }

    public void populateDataOnQuickOrderPage(ArrayList<QuickOrderProduct> listProducts){

        for(int i= 0; i < listProducts.size(); i++){
            QuickOrderProduct productRow = listProducts.get(i);
            int row = i + 4;
            SelenideElement e = $$(QUICK_ORDER_ROW_XPATH).get(row);

            if(e.find(UNIVERSAL_NOTES_NUMBER_ROW_XPATH).exists()){
                e.find(UNIVERSAL_PART_NUMBER_ROW_XPATH).sendKeys(productRow.getPartNumber());
                e.find(UNIVERSAL_QTY_NUMBER_ROW_XPATH).clear();
                e.find(UNIVERSAL_QTY_NUMBER_ROW_XPATH).sendKeys(productRow.getQty());
                if(productRow.getNote() != null){
                    e.find(UNIVERSAL_NOTES_NUMBER_ROW_XPATH).sendKeys(productRow.getNote());
                }
            }
        }
    }

}
