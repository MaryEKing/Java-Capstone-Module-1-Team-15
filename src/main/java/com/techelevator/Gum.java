package com.techelevator;

public class Gum extends Products {

    public Gum(String name, double price) {
        super(name, price);
    }

    public String getSound() {
        return "Chew Chew, Yum!";
    }
}