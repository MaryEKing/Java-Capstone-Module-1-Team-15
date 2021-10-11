package com.techelevator;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.HashMap;

public abstract class Product {
    private String name;
    private double price;
    private String slot;

    private int numberOfItems = 5;

    public Product(String name, double price, String slot) {
        this.name = name;
        this.price = price;
        this.slot = slot;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    public abstract String getSound();

    public String toString() {
        DecimalFormat myFormat = new DecimalFormat("#.00");
        String str = String.format(" %1$-20s %2$-10s %3$s", name, "$" + myFormat.format(price), this.getNumberOfItems());
        return str;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }


    public boolean isAvailableToPurchase() {
        if (this.numberOfItems >= 1) {
            return true;
        }
        return false;
    }

    public void purchaseItem() {
        numberOfItems -= 1;

    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
}