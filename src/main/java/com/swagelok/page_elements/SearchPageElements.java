package com.swagelok.page_elements;

import org.openqa.selenium.By;

public class SearchPageElements {

    public static final By SEARCH_HEADER_VALUE_XPATH = By.xpath("//h1[@class='s-page-header__headline']");
    public static final By SEARCH_RESULTS_BASE_PRODUCT_NAMES_XPATH = By.xpath("//a[@class='s-headline-link s-plp-product__name']");

    public static final By SEARCH_PAGE_PRODUCTS_TAB_XPATH = By.xpath("//button[@value='products']");
    public static final By SEARCH_PAGE_DOWNLOADS_TAB_XPATH = By.xpath("//button[@value='download']");
    public static final By SEARCH_PAGE_CONTENT_TAB_XPATH = By.xpath("//button[@value='content']");
    public static final By SEARCH_PAGE_LOCAL_TAB_XPATH = By.xpath("//button[@value='minisite']");
    public static final By SEARCH_PAGE_NO_RESULTS_VALUE_XPATH = By.xpath("//p/strong");
    public static final By SEARCH_PAGE_SUGGESTED_VALUE_XPATH = By.xpath("//p[@class='searchSpellingSuggestionPrompt']/a");
    public static final By SEARCH_PAGE_NO_RESULTS_MESSAGE_XPATH = By.xpath("//div[@class='s-srp__empty-messages']/p");
}
