package com.swagelok.models;

import lombok.Getter;
import lombok.Setter;

public class QuickOrderProduct {

    @Getter @Setter private String partNumber;
    @Getter @Setter private String qty;
    @Getter @Setter private String note;


    public QuickOrderProduct(String partNumber, String qty, String note) {
        this.partNumber = partNumber;
        this.qty = qty;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Part number: " + this.partNumber + ", Note: " + this.note + ", added qty: " + this.qty;
    }
}

