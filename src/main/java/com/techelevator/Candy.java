package com.techelevator;

public class Candy extends Product {

    public Candy(String name, double price, String slot) {
        super(name, price, slot);
    }

    public String getSound() {
        return "Munch Munch, Yum!";
    }

}