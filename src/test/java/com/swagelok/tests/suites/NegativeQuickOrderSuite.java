package com.swagelok.tests.suites;

import com.codeborne.selenide.junit.ScreenShooter;
import com.swagelok.models.QuickOrderProduct;
import com.swagelok.tests.steps.LoginPageSteps;
import com.swagelok.tests.steps.QuickOrderPageSteps;
import com.swagelok.utils.DriverFactory;
import org.junit.*;

import java.util.ArrayList;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class NegativeQuickOrderSuite {

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();


    @BeforeClass
    public static void login(){
        DriverFactory.setTestParameters();
        LoginPageSteps.fastLogin();
    }

//    Check that Add to Cart button is disabled when Form contains only invalid products
//    Verify that Invalid products has expected error message
    @Test
    public void invalidProductsInForm(){
        ArrayList<QuickOrderProduct> product = new ArrayList<>();
        product.add(new QuickOrderProduct("SS-000","7", "Test comment77"));

        QuickOrderPageSteps quickOrderPageSteps = new QuickOrderPageSteps();
        quickOrderPageSteps.fillQuickOrderForm(product);

        Assert.assertFalse("Add to Cart button is active when page does`nt contain valid products", quickOrderPageSteps.checkAddToCartButtonForm());

        Assert.assertTrue("Message for invalid Product number is absent", quickOrderPageSteps.invalidProductMessagePresent() );
    }

//    Verify the presence of an error message in Add to Cart popup if at least 1 product was invalid
    @Test
    public void checkMessageAboutInvalidRows(){
        ArrayList<QuickOrderProduct> product = new ArrayList<>();
        product.add(new QuickOrderProduct("SS-400-1-4","7", null));
        product.add(new QuickOrderProduct("SS-000","7", null));

        QuickOrderPageSteps quickOrderPageSteps = new QuickOrderPageSteps();
        quickOrderPageSteps.openQuickOrderPageViaForm();
        quickOrderPageSteps.fillProductRow(product);
        quickOrderPageSteps.clickAddToCart();

        Assert.assertTrue("Message is absent", quickOrderPageSteps.checkErrorMessageAddToCartPopup());
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
