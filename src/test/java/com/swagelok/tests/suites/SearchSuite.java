package com.swagelok.tests.suites;

import com.codeborne.selenide.junit.ScreenShooter;
import com.swagelok.tests.DriverFactory;
import com.swagelok.tests.steps.SearchPageSteps;
import com.swagelok.tests.steps.VariantPDPSteps;
import org.junit.*;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class SearchSuite {

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();


    @BeforeClass
    public static void login() {
        DriverFactory.openLoginPage();
        LoginSuite loginSuite = new LoginSuite();
        loginSuite.swagelokLogin();
    }

//    Check that user is redirecting to Search page after search something
    @Test
    public void redirectToSearchPage(){
        String searchValue = "pLug";
        SearchPageSteps searchPageSteps = new SearchPageSteps();
        searchPageSteps.searchValue(searchValue);

        Assert.assertTrue("Link is not equal with expected",
                searchPageSteps.compareLinks(searchValue));

        Assert.assertTrue("Not all search results tabs are present",
                searchPageSteps.searchTabsPresent());


    }

    // Type part of valid product name and do search
    @Test
    public void searchByName(){
        String searchValue = "Plug";
        SearchPageSteps searchPageSteps = new SearchPageSteps();
        searchPageSteps.searchValue(searchValue);

        Assert.assertTrue("Search value in the Header is not equal with asked value",
                searchPageSteps.searchValueInHeaderIsCorrect(searchValue));

        Assert.assertTrue("Names of base Products don't contain Search value",
                searchPageSteps.namesProductsSimilarWithSearchValue(searchValue));
    }

    //Please type unique part number of Variant product and check that user will be redirected to Variant PDP
    @Test
    public void searchByProductNumber(){
        String productNumber = "SS-10M0-P";
        SearchPageSteps searchPageSteps = new SearchPageSteps();
        VariantPDPSteps variantPDPSteps = new VariantPDPSteps();
        searchPageSteps.searchValue(productNumber);
        String link = searchPageSteps.getLink().toLowerCase();

        Assert.assertTrue("It seems that user is on: " + link + " instead of Variant PDP",
                link.endsWith(productNumber.toLowerCase()));

        String actualProductNumber = variantPDPSteps.getPartNumberOfCurrentProduct();
        Assert.assertTrue("Expected product number: " + productNumber + ", actual product number: " + actualProductNumber,
                variantPDPSteps.compareProductNumbers(productNumber));
    }

    // Type search value without results but with proposal to correction search value.
    // Search with suggested value
    @Test
    public void searchBySuggestedValue(){
        String searchValue = "Swegelok";
        SearchPageSteps searchPageSteps = new SearchPageSteps();
        searchPageSteps.searchValue(searchValue);

        String noResultsValue = searchPageSteps.getNoResultsValue();

        Assert.assertEquals("No results message contains invalid value: " + noResultsValue,
                searchValue, noResultsValue);

        String suggestedSearchValue = searchPageSteps.getSuggestedSearchValue();
        searchPageSteps.searchBySuggestedSearchValue();
        Assert.assertTrue("Search value in the Header is not equal with suggested value",
                searchPageSteps.searchValueInHeaderIsCorrect(suggestedSearchValue));
    }

    // Perform search of invalid search value or value without results.
    // Check that user will be redirected to Search page and has a valid message.
    @Test
    public void searchByValueWithoutResults(){
        String searchValue = "gY34lp";
        SearchPageSteps searchPageSteps = new SearchPageSteps();
        searchPageSteps.searchValue(searchValue);

        String noResultsValue = searchPageSteps.getNoResultsValue();
        String link = searchPageSteps.getLink();

        Assert.assertTrue("User is not on the search page.",
                link.startsWith("https://products.qa.swagelok.com/en/search/?text="));

        Assert.assertTrue("No results message is invalid",
                searchPageSteps.getNoResultsMessage().startsWith("No results were found matching your search for:"));

        Assert.assertEquals("No results message contains invalid value: " + noResultsValue,
                searchValue, noResultsValue);
    }

    @After
    public void openMainPage(){
        SearchPageSteps searchPageSteps = new SearchPageSteps();
        searchPageSteps.openDefaultPage();
    }

    @AfterClass
    public static void closeDriver(){
        closeWebDriver();
    }
}
