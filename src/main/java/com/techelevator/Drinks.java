package com.techelevator;

public class Drinks extends Products {

    public Drinks(String name, double price) {
        super(name, price);
    }


    public String getSound() {
        return "Glug Glug, Yum!";
    }
}