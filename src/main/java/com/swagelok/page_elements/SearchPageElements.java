package com.swagelok.page_elements;

import org.openqa.selenium.By;

public class SearchPageElements {

    public static final By SEARCH_HEADER_VALUE_XPATH = By.xpath("//h1[@class='s-page-header__headline']");
    public static final By SEARCH_RESULTS_BASE_PRODUCT_NAMES_XPATH = By.xpath("//a[@class='s-headline-link s-plp-product__name']");

    public static final By SEARCH_PAGE_SWITCH_CONTENT_TO_PRODUCT_RESULTS_XPATH = By.xpath("//a[contains(text(), 'product listings related to')]");
    public static final By SEARCH_PAGE_RESULTS_TAB_XPATH = By.xpath("//button[@value='RESULTS']");
    public static final By SEARCH_PAGE_LOCAL_RESULTS_TAB_XPATH = By.xpath("//button[@value='LOCAL_RESULTS']");
    public static final By SEARCH_PAGE_NO_RESULTS_VALUE_XPATH = By.xpath("//p/strong");
    public static final By SEARCH_PAGE_SUGGESTED_VALUE_XPATH = By.xpath("//p[@class='searchSpellingSuggestionPrompt']/a");
    public static final By SEARCH_PAGE_NO_RESULTS_MESSAGE_XPATH = By.xpath("//div[@class='s-srp__empty-messages']/p");
}
