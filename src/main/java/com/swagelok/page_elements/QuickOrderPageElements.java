package com.swagelok.page_elements;

import org.openqa.selenium.By;

public class QuickOrderPageElements {
    public static final By QUICK_ORDER_RESET_BUTTON_XPATH = By.xpath("//button[@id='quickOrderReset']");
    public static final By ADD_TO_CART_BUTTON_XPATH = By.xpath("//button[@id='quickOrderSubmit']");
    public static final By CHOOSE_FILE_BUTTON_XPATH = By.xpath("//div[@id='chooseFileButton']");
    public static final By INPUT_FILE_XPATH = By.xpath("//input[@id='csvFile']");
    public static final By ADD_TO_CART_BULK_XPATH = By.xpath("//button[@id='importButton']");
    public static final By CONFIRMATION_FILE_UPLOADING_XPATH = By.xpath("//div[@id='fileSuccess']");

    public static final By QUICK_ORDER_ROW_XPATH = By.xpath("//div[@class='s-form-row']");
    public static final By UNIVERSAL_PART_NUMBER_ROW_XPATH = By.xpath(".//input[@class='form-control js-input-part']");
    public static final By UNIVERSAL_QTY_NUMBER_ROW_XPATH = By.xpath(".//input[@class='form-control js-input-qty']");
    public static final By UNIVERSAL_NOTES_NUMBER_ROW_XPATH = By.xpath(".//input[@class='form-control js-input-note']");



//    public By triggerXpathForPartNumberRow(int rowNumber){
//        String universalPartNumberXPATH = "//input[@aria-describedby='part-error_";
//        if(rowNumber > 1 && rowNumber < 21){
//            String xpath = universalPartNumberXPATH + rowNumber + "']";
//            UNIVERSAL_PART_NUMBER_ROW_XPATH = By.xpath(xpath);
//        } else {
//            System.out.println("We dont have Part number with such number: " + rowNumber + " XPATH will not be triggered");
//        }
//        return UNIVERSAL_PART_NUMBER_ROW_XPATH;
//    }
//
//    public By triggerXpathForQtyRow(int rowNumber){
//        String universalQtyXPATH = "//input[@aria-describedby='qty-error_";
//        if(rowNumber > 1 && rowNumber < 21){
//            String xpath = universalQtyXPATH + rowNumber + "']";
//            UNIVERSAL_QTY_NUMBER_ROW_XPATH = By.xpath(xpath);
//        } else {
//            System.out.println("We dont have Qty row with such number: " + rowNumber + " XPATH will not be triggered");
//        }
//        return UNIVERSAL_QTY_NUMBER_ROW_XPATH;
//    }
//
//    public By triggerXpathForNotesRow(int rowNumber){
//        String universalNoteXPATH = "//input[@aria-describedby='qty-error_";
//        if(rowNumber > 1 && rowNumber < 21){
//            String xpath = universalNoteXPATH + rowNumber + "']";
//            UNIVERSAL_NOTES_NUMBER_ROW_XPATH = By.xpath(xpath);
//        } else {
//            System.out.println("We dont have Note row with such number: " + rowNumber + " XPATH will not be triggered");
//        }
//        return UNIVERSAL_NOTES_NUMBER_ROW_XPATH;
//    }

}
