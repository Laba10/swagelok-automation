package com.swagelok.page_elements;

import org.openqa.selenium.By;

public class HeaderPageElements {
    public static final By ACCOUNT_BUTTON_XPATH = By.xpath("//div[@class='s-dropdown s-header-nav s-header__account']");
    public static final By LOGOUT_BUTTON_XPATH = By.xpath("//a[@href='/en/logout']");

    public static final By QUICK_ORDER_BUTTON_XPATH = By.xpath("//button[@data-target='#miniQuickOrderFormWrapper']");
    public static final By QUICK_ORDER_FORM_BUTTON_XPATH = By.xpath("//a[contains(text(),'Quick Add Form')]");
    public static final By QUICK_ORDER_FORM_ROW_XPATH = By.xpath("//div[@class='s-form-row']");
    public static final By QUICK_ORDER_FORM_PART_NUMBER_XPATH = By.xpath(".//input[@class='form-control js-input-part']");
    public static final By QUICK_ORDER_FORM_QTY_XPATH = By.xpath(".//input[@class='form-control js-input-qty']");
    public static final By ADD_TO_CART_BUTTON_QUICK_ORDER_FORM = By.xpath("//button[contains(text(), 'Add to cart')]");
    public static final By ERROR_MESSAGE_IN_FORM_PART_NUMBER = By.xpath("//div[@id='part-error_m_1']");

    public static final By CART_BUTTON_IN_HEADER_XPATH = By.xpath("//button[@data-mini-cart-name='Cart']");
    public static final By VIEW_CART_BUTTON_CART_POPUP_XPATH = By.xpath("//a[contains(text(), 'View Cart')]");
    public static final By COUNT_OF_PRODUCTS_MINI_CART_ICON_XPATH = By.xpath("//span[@class='js-mini-cart-count']");

    public static final By SEARCH_FIELD_XPATH = By.xpath("//input[@id='js-site-search-input']");
    public static final By SEARCH_BUTTON_XPATH = By.xpath("//button[@class='s-site-search__cta js_search_button']");

}
