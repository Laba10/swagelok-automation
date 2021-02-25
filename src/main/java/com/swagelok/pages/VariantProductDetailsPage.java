package com.swagelok.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.swagelok.page_elements.VariantProductDetailsPageElements.PART_NUMBER_VALUE_VARIANT_PDP;

public class VariantProductDetailsPage extends OverallPage{

    public String getPartNumber(){
        String field = $(PART_NUMBER_VALUE_VARIANT_PDP).getText();
        int a = field.indexOf(":");
        String value = field.substring(a+2);
        return value;

    }
}
