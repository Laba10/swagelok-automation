package com.swagelok.tests.steps;

import com.swagelok.pages.SearchPage;

public class SearchPageSteps {

    SearchPage searchPage = new SearchPage();

    public void openDefaultPage() {
        searchPage.openAllProductsPage();
    }

    public void searchValue(String value){
        searchPage.typeSearchValue(value);
        searchPage.clickSearchButton();
    }


    public boolean searchValueInHeaderIsCorrect(String searchValue){
        return searchPage.getTextSearchHeader().contains(searchValue);
    }

    public boolean compareLinks(String searchValue){
        String expectedLink = "https://products.qa.swagelok.com/en/search/?text=" + searchValue;
        return searchPage.getLink().equals(expectedLink);
    }

    public boolean searchTabsPresent(){
        return searchPage.tabPresence();
    }

    public boolean namesProductsSimilarWithSearchValue(String searchValue){
        return searchPage.baseProductsContainSearchValue(searchValue);
    }

    public String getLink(){
        return searchPage.getLink();
    }

    public String getNoResultsValue(){
        return searchPage.getSearchValueWithoutResults();
    }

    public String getSuggestedSearchValue(){
        if(searchPage.suggestedSearchValueAppears()){
            return searchPage.getSuggestedSearchValue();
        }
        return null;
    }

    public void searchBySuggestedSearchValue(){
        searchPage.clickOnSuggestedSearchValue();
    }

    public String getNoResultsMessage(){
        return searchPage.getNoResultsMessage();
    }
}
