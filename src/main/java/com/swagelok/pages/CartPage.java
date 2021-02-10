package com.swagelok.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.swagelok.models.CartProduct;
import com.swagelok.page_elements.CartPageElements;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;
import static com.swagelok.page_elements.CartPageElements.*;
import static com.swagelok.page_elements.PopupPageElements.CONFIRM_BUTTON_CLEAR_CART_POPUP;

public class CartPage extends OverallPage {

    CartPageElements cartPageElements = new CartPageElements();
    CartProduct cartProduct;//should be array


    public void clearCart(){
        if(cartPageIsOpened() == false){
            openCartPage();
        }
        $(CLEAR_CART_BUTTON_XPATH).click();
        $(CONFIRM_BUTTON_CLEAR_CART_POPUP).click();
    }

    public Boolean cartPageIsOpened(){
        String expectedLink = "https://products.qa.swagelok.com/en/cart";
        Boolean cartIsOpened = false;

        if( getLink() == expectedLink){
            cartIsOpened = true;
        }
        return cartIsOpened;
    }

    public String checkProductData(String partNumber){
        ArrayList<CartProduct> listProducts;;
        String qty;
        listProducts = getListOfProductsFromCart();

        for(CartProduct product : listProducts){
            if(product.getPartNumber().equals(partNumber)){
                qty = product.getQty();
                return qty;
            }
        }
        return "No product with such part Number";
    }

    public ArrayList<CartProduct> getListOfProductsFromCart(){
        $(PRODUCT_ROW_UNIVERSAL_XPATH).shouldBe(Condition.visible);

        ArrayList<CartProduct> products = new ArrayList<>();
        for (SelenideElement e :
                $$(PRODUCT_ROW_UNIVERSAL_XPATH)) {
            if(e.find(CUSTOMER_PART_NUMBER_FIELD).exists()){
                String id = e.find(PART_NUMBER_VALUE_XPATH).getText();
                String name = e.find(NAME_VALUE_XPATH).getText();
                String qty = e.find(QTY_VALUE_XPATH).getValue();
                products.add(
                        new CartProduct(id, name, qty)
                );
            }
        }

        System.out.println(products.toString());
        return products;
    }

}
