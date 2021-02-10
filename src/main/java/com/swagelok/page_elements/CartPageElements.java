package com.swagelok.page_elements;

import org.openqa.selenium.By;

public class CartPageElements {

    public static final By CLEAR_CART_BUTTON_XPATH = By.xpath("//button[contains(text(), 'Clear Cart')]");
//    public static final By PRODUCT_ROW_UNIVERSAL_XPATH = By.xpath("//*[@class ='s-cart__item-td']/..");
    public static final By PRODUCT_ROW_UNIVERSAL_XPATH = By.xpath("//tr");
    public static final By PART_NUMBER_VALUE_XPATH = By.xpath(".//*[@class ='s-cart__product-number']/span[2]");
    public static final By QTY_VALUE_XPATH = By.xpath(".//*[@name ='quantity']");
    public static final By NAME_VALUE_XPATH = By.xpath(".//*[@class ='s-headline-link']");
    public static final By CUSTOMER_PART_NUMBER_FIELD = By.xpath(".//p[@class='s-cart__item-label']");


}
