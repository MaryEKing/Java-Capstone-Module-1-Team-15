package com.techelevator;

public class Chips extends Products {

    public Chips(String name, double price) {
        super(name, price);
    }

    public String getSound() {
        return "Crunch Crunch, Yum!";
    }
}