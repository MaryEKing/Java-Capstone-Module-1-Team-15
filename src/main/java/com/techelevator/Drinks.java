package com.techelevator;

public class Drinks extends Products {

    public Drinks(String name, double price, String slot) {
        super(name, price, slot);
    }

    public String getSound() {
        return "Glug Glug, Yum!";
    }
}