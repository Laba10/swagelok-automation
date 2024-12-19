package com.swagelok.page_elements;

import org.openqa.selenium.By;

public class PopupPageElements {
    public static final By CANCEL_BUTTON_ADD_TO_CART_POPUP = By.xpath("//button[@id='cboxClose']");
    public static final By ADD_TO_CART_POPUP_XPATH = By.xpath("//div[@id='addToCartLayer']");
    public static final By POPUP_WINDOW_XPATH = By.xpath("//div[@id='cboxLoadedContent']");
    public static final By MESSAGE_SUCCESSFULLY_ADDED_PRODUCTS_XPATH = By.xpath("//div[@class='s-cart-popup__msg s-cart-popup__msg--success']/span");
    public static final By VIEW_CART_BUTTON_ADD_TO_CART_POPUP = By.xpath("//div[@class='s-cart-popup__actions']/a[contains(text(), 'View Cart')]");
    public static final By CONFIRM_BUTTON_CLEAR_CART_POPUP = By.xpath("//div[@id='colorbox']//a[@href=\"/en/cart/clear-cart\"]");
    public static final By ADD_TO_CART_POPUP_ERROR_MESSAGE = By.xpath("//span[@id='quickOrderError']/strong");
    public static final By ADD_TO_CART_WINDOW_XPATH = By.xpath("//div[@class='s-dropdown__content s-header-nav__content collapse in']");
    public static final By ACCEPT_COOKIE_XPATH = By.xpath("//button[@id='onetrust-accept-btn-handler']");
}
