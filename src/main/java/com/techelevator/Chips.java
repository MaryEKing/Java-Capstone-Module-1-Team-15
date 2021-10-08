package com.techelevator;

public class Chips extends Products {

    public Chips(String name, double price, String slot) {
        super(name, price, slot);
    }


    public String getSound() {
        return "Crunch Crunch, Yum!";
    }
}