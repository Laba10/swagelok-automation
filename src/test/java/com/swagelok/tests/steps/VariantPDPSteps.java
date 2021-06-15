package com.swagelok.tests.steps;

import com.swagelok.pages.VariantProductDetailsPage;

public class VariantPDPSteps extends SharedSteps {
    VariantProductDetailsPage variantProductDetailsPage = new VariantProductDetailsPage();

    public String getPartNumberOfCurrentProduct(){
        return variantProductDetailsPage.getPartNumber();
    }

    public boolean compareProductNumbers(String expected){
        return expected.equalsIgnoreCase(getPartNumberOfCurrentProduct());
    }
}
