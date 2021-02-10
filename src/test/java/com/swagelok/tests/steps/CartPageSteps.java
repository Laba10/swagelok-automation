package com.swagelok.tests.steps;

import com.swagelok.models.CartProduct;
import com.swagelok.models.QuickOrderProduct;
import com.swagelok.pages.CartPage;

import java.util.ArrayList;

public class CartPageSteps {
    
    CartPage cartPage = new CartPage();
    
    public Boolean cartIsEmpty(){
        return cartPage.checkIfCartIsEmpty();
    }

    public void cancelCart() {
        if(cartIsEmpty() == true){
            System.out.println("Cart is empty. No need to cancel cart.");
        } else {
            cartPage.clearCart();
            cartPage.openAllProductsPage();
        }
    }

    public void clickViewCartButton(){
        cartPage.clickViewCartButtonAddToCartPopup();
    }

    public void addProductsFromQuickOrderForm(ArrayList<QuickOrderProduct> product){
        QuickOrderPageSteps quickOrderPageSteps = new QuickOrderPageSteps();
        quickOrderPageSteps.fillQuickOrderForm(product);
        quickOrderPageSteps.addProductsToCartFromForm();
    }

    public String getNumberOnMiniCartIcon(){
        return cartPage.getCountOfProductsInCart();
    }

    public String getQtyForSpecificProduct(String partNumber){
        return cartPage.checkProductData(partNumber);
    }

    public ArrayList<CartProduct> getAllProductsFromCart(){
        //cartPage.setListOfProductsAddedToCart();
        return cartPage.getListOfProductsFromCart();
    }


}
