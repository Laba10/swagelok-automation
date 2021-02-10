package com.swagelok.models;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class CartProduct {

    @Getter @Setter private String partNumber;
    @Getter @Setter private String name;
    @Getter @Setter private String qty;


    public CartProduct(String partNumber, String name, String qty) {
        this.partNumber = partNumber;
        this.name = name;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Part number: " + this.partNumber + ", Product name: " + this.name + ", added qty: " + this.qty;
    }
}
