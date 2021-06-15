package com.swagelok.tests.suites;

import com.codeborne.selenide.junit.ScreenShooter;
import com.swagelok.models.QuickOrderProduct;
import com.swagelok.tests.steps.CartPageSteps;
import com.swagelok.tests.steps.LoginPageSteps;
import com.swagelok.utils.DriverFactory;
import org.junit.*;

import java.util.ArrayList;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class CartSuite{

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();


    @BeforeClass
    public static void login(){
        DriverFactory.setTestParameters();
        LoginPageSteps.fastLogin();
        CartPageSteps cartPageSteps = new CartPageSteps();
        cartPageSteps.cancelCart();
    }

//    Verify that products added from Quick Order page are present in the cart and have valid qty
    @Test
    public void productAddedFromQuickOrder(){
        ArrayList<QuickOrderProduct> product = new ArrayList<>();
        product.add(new QuickOrderProduct("SS-400-1-4","7", "Test comment77"));
        product.add(new  QuickOrderProduct("SS-8-TA-1-6RT","349", null));
        String expectedCount = String.valueOf(product.size());

        CartPageSteps cartPageSteps = new CartPageSteps();
        cartPageSteps.addProductsFromQuickOrderForm(product);
        cartPageSteps.clickViewCartButton();


        Assert.assertEquals("Number on the miniCart icon is not equal with count of adding products",
                expectedCount, cartPageSteps.getNumberOnMiniCartIcon());

        Assert.assertEquals("Provided product is not found in the cart or Qty of the product is not equal with expected",
                "7", cartPageSteps.getQtyForSpecificProduct("SS-400-1-4"));
    }

    @Test
    public void verifyProducts(){
        ArrayList<QuickOrderProduct> product = new ArrayList<>();
        product.add(new QuickOrderProduct("SS-400-1-4","7", "Test comment77"));
        product.add(new  QuickOrderProduct("SS-8-TA-1-6RT","349", null));

        CartPageSteps cartPageSteps = new CartPageSteps();
        cartPageSteps.addProductsFromQuickOrderForm(product);
        cartPageSteps.clickViewCartButton();

//        ArrayList<CartProduct> products = cartPageSteps.getAllProductsFromCart();
//        Assert.assertTrue("Compare collections", products.equals(product));
    }

    @After
    public void cleanCart(){
        CartPageSteps cartPageSteps = new CartPageSteps();
        cartPageSteps.cancelCart();
    }

    @AfterClass
    public static void closeDriver(){
        closeWebDriver();
    }
}
