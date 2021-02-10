package com.swagelok.tests.suites;

import com.codeborne.selenide.junit.ScreenShooter;
import com.swagelok.models.QuickOrderProduct;
import com.swagelok.tests.DriverFactory;
import com.swagelok.tests.steps.QuickOrderPageSteps;
import org.junit.*;

import java.util.ArrayList;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

public class QuickOrderSuite {

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();


    @BeforeClass
    public static void login(){
        DriverFactory driverFactory = new DriverFactory();
        driverFactory.openLoginPage();
        LoginSuite loginSuite = new LoginSuite();
        loginSuite.swagelokLogin();
    }

//Verify that user is redirecting to page after clicking on the Quick Order Form button
    @Test
    public void openQuickOrderPage(){
        QuickOrderPageSteps quickOrderPageSteps = new QuickOrderPageSteps();
        quickOrderPageSteps.openQuickOrderPageViaForm();

        Assert.assertEquals("Current url: " + url()+ " is not equal with Quick Order page URL",
                "https://products.qa.swagelok.com/en/quickOrder", url());
    }

//  Verify that user is able to add products from Quick Order page.
//  Check count of products in Add to Cart popup
    @Test
    public void addProductFromQuickOrderPage(){
        ArrayList<QuickOrderProduct> products = new ArrayList<>();
        products.add(new QuickOrderProduct("SS-400-1-4","7", "Test comment77"));
        products.add(new  QuickOrderProduct("SS-8-TA-1-6RT","349", null));
        products.add(new  QuickOrderProduct("SS-8TF-7","10", "Test comment@701"));
        String expectedCountProducts = String.valueOf(products.size());
        String actualCountProducts;

        QuickOrderPageSteps quickOrderPageSteps = new QuickOrderPageSteps();
        quickOrderPageSteps.openQuickOrderPageViaForm();
        quickOrderPageSteps.fillProductRow(products);
        quickOrderPageSteps.clickAddToCart();

        actualCountProducts = quickOrderPageSteps.verifyIfProductsWereAddedToCart();

        Assert.assertEquals("Count " + actualCountProducts + " of successfully added products to cart is not equal with expected " + expectedCountProducts + " ",
                expectedCountProducts, actualCountProducts);
    }

//    Check that Quick Order page is clean after click on the Reset form button
//    Verify that Add to Cart button is disabled if rows are clean
    @Test
    public void resetQuickOrderPage(){
        ArrayList<QuickOrderProduct> products = new ArrayList<>();
        products.add(new QuickOrderProduct("SS-400-1-4","7", "Test comment77"));
        products.add(new  QuickOrderProduct("SS-8-TA-1-6RT","349", null));

        QuickOrderPageSteps quickOrderPageSteps = new QuickOrderPageSteps();
        quickOrderPageSteps.openQuickOrderPageViaForm();
        quickOrderPageSteps.fillProductRow(products);
        quickOrderPageSteps.resetQuickOrderPage();

        Assert.assertTrue("Not all Quick Order rows are clean", quickOrderPageSteps.verifyThatQuickOrderRowsClean());

        Assert.assertFalse("Add to Cart button is active when rows are clean", quickOrderPageSteps.checkAddToCartButtonPage());
    }

//    Check that user is able to add Products from Quick Order Form(Popup window)
//    Verify that count of successfully added Products is equal with count of provided products
    @Test
    public void addProductFromQuickOrderForm(){
        ArrayList<QuickOrderProduct> product = new ArrayList<>();
        product.add(new QuickOrderProduct("SS-400-1-4","7", "Test comment77"));
        String expectedCountProducts = String.valueOf(product.size());

        QuickOrderPageSteps quickOrderPageSteps = new QuickOrderPageSteps();
        quickOrderPageSteps.fillQuickOrderForm(product);
        quickOrderPageSteps.addProductsToCartFromForm();

        String actualCountProducts = quickOrderPageSteps.verifyIfProductsWereAddedToCart();

        Assert.assertEquals("Count " + actualCountProducts + " of successfully added products to cart is not equal with expected " + expectedCountProducts + " ",
                expectedCountProducts, actualCountProducts);
    }

//    Verify that user is able to Add products to cart via bulk upload feature
    @Test
    public void bulkUploading(){
        QuickOrderPageSteps quickOrderPageSteps = new QuickOrderPageSteps();
        quickOrderPageSteps.openQuickOrderPageViaForm();
        quickOrderPageSteps.uploadProductsViaBulk();
        quickOrderPageSteps.addToCartFromBulkFile();

        Assert.assertTrue("Add to Cart popup is absent", quickOrderPageSteps.presenceAddToCartPopup());
    }


    @After
    public void cleanQuickOrderPage(){
        QuickOrderPageSteps quickOrderPageSteps = new QuickOrderPageSteps();
        quickOrderPageSteps.closeAddToCartPopup();
        quickOrderPageSteps.resetQuickOrderPage();
        quickOrderPageSteps.openAllProductsPage();
    }


    @AfterClass
    public static void closeDriver(){
        closeWebDriver();
    }
}
