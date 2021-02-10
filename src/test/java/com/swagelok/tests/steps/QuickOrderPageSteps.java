package com.swagelok.tests.steps;

import com.swagelok.models.QuickOrderProduct;
import com.swagelok.pages.QuickOrderPage;

import java.util.ArrayList;

public class QuickOrderPageSteps {
    private QuickOrderPage quickOrderPage = new QuickOrderPage();

    public void resetQuickOrderPage(){
        quickOrderPage.resetForm();
    }

    public void openQuickOrderPageViaForm(){
        quickOrderPage.openQuickOrderWindow();
        quickOrderPage.clickQuickOrderFormButton();
    }

    public void fillProductRow(ArrayList<QuickOrderProduct> products){
        quickOrderPage.populateDataOnQuickOrderPage(products);
    }

    public void clickAddToCart(){
        quickOrderPage.addToCart();
    }

    public String verifyIfProductsWereAddedToCart(){
        String qtyProducts = null;
       if (quickOrderPage.checkAddToCartPopup() == true){
           qtyProducts = quickOrderPage.countOfSuccessfullyAddedProducts();
       }
       return qtyProducts;
    }

    public Boolean presenceAddToCartPopup(){
        return quickOrderPage.checkAddToCartPopup();
    }

    public Boolean verifyThatQuickOrderRowsClean(){
        Boolean allRowsClean = true;
        if (quickOrderPage.checkThatPartNumberRowsEmpty() != true){
            allRowsClean = false;
        }

        if (quickOrderPage.qtyFieldsEmpty() != true){
            allRowsClean = false;
        }

        if (quickOrderPage.notesFieldsEmpty() != true){
            allRowsClean = false;
        }
        return  allRowsClean;
    }

    public void fillQuickOrderForm(ArrayList<QuickOrderProduct> product){
        quickOrderPage.openQuickOrderWindow();
        quickOrderPage.populateDataInQuickOrderForm(product);
    }

    public void addProductsToCartFromForm(){
        quickOrderPage.clickAddToCartQuickOrder();
    }

    public void closeAddToCartPopup(){
        quickOrderPage.cancelAddToCartPopup();
    }

    public void openAllProductsPage() {
        quickOrderPage.openAllProductsPage();
    }

    public void uploadProductsViaBulk(){
        quickOrderPage.uploadBulkFile();
    }

    public void addToCartFromBulkFile(){
        quickOrderPage.addToCartBulkFile();
    }

    public boolean checkAddToCartButtonPage() {
        return quickOrderPage.addToCartIsActiveOnPage();
    }

    public boolean checkAddToCartButtonForm(){
        return quickOrderPage.addToCartIsActiveOnForm();
    }

    public boolean invalidProductMessagePresent(){
        return quickOrderPage.checkMessageForPartNumber();
    }

    public boolean checkErrorMessageAddToCartPopup(){
        return quickOrderPage.checkErrorInAddToCartPopup();
    }
}
