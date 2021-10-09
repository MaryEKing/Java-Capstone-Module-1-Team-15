package com.techelevator;

public class Gum extends Product {

    public Gum(String name, double price, String slot) {
        super(name, price, slot);
    }


    public String getSound() {
        return "Chew Chew, Yum!";
    }
}