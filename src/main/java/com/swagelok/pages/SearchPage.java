package com.swagelok.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.swagelok.page_elements.SearchPageElements.*;

public class SearchPage extends OverallPage{

    public String getTextSearchHeader(){
        return  $(SEARCH_HEADER_VALUE_XPATH).getText();
    }

    public boolean tabPresence(){
        boolean[] tabs = new boolean[4];
        tabs[0] = $(SEARCH_PAGE_PRODUCTS_TAB_XPATH).exists();
        tabs[1] = $(SEARCH_PAGE_CONTENT_TAB_XPATH).exists();
        tabs[2] = $(SEARCH_PAGE_DOWNLOADS_TAB_XPATH).exists();
        tabs[3] = $(SEARCH_PAGE_LOCAL_TAB_XPATH).exists();

        for (int i = 0; i < 4; i++){
            if(tabs[i] == false){
           return false;
            }
        }
    return true;
    }

    public String[] getListOfBaseProductsOnTheSearch(){
        int size = $$(SEARCH_RESULTS_BASE_PRODUCT_NAMES_XPATH).size();
        String[] baseProducts = new String[size];
        int i = 0;
        for (SelenideElement e :
                $$(SEARCH_RESULTS_BASE_PRODUCT_NAMES_XPATH)) {
            baseProducts[i] = e.getText();
            i++;
        }
        return baseProducts;
    }

    public boolean baseProductsContainSearchValue(String name){
        String[] baseProducts;
        baseProducts = getListOfBaseProductsOnTheSearch();
        name = name.toLowerCase();
        for (String baseProduct : baseProducts) {
            if (baseProduct.toLowerCase().contains(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean noResultsFieldPresent(){
       return  $(SEARCH_PAGE_NO_RESULTS_VALUE_XPATH).exists();
    }

    public String getSearchValueWithoutResults(){
       if (noResultsFieldPresent()){
           return $(SEARCH_PAGE_NO_RESULTS_VALUE_XPATH).getText();
       }
        return null;
    }

    public String getSuggestedSearchValue(){
        return $(SEARCH_PAGE_SUGGESTED_VALUE_XPATH).getText();
    }

    public boolean suggestedSearchValueAppears(){
        return $(SEARCH_PAGE_SUGGESTED_VALUE_XPATH).exists();
    }

    public void clickOnSuggestedSearchValue(){
        if(suggestedSearchValueAppears()){
            $(SEARCH_PAGE_SUGGESTED_VALUE_XPATH).click();
        } else{
            System.out.println("Suggested search value is absent");
        }
    }

    public String getNoResultsMessage(){
        if($(SEARCH_PAGE_NO_RESULTS_MESSAGE_XPATH).exists()){
            return $(SEARCH_PAGE_NO_RESULTS_MESSAGE_XPATH).getText();
        }
        return null;
    }

}
