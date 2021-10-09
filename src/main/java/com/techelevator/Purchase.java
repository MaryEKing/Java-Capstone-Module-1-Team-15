package com.techelevator;
import com.techelevator.Purchase;

import java.io.FileNotFoundException;

public class Purchase extends VendingMachineCLI{
    private double moneyFed;
    private double price;
    private double changeDue;
    private int numberOfQuarters;
    private int numberOfDimes;
    private int numberOfNickles;


    public Purchase(double moneyFed, double price, double changeDue, String name, String slot) throws FileNotFoundException {
        super();
        this.changeDue = changeDue;
    }

    public String makeChange(){

        String changeInCoins;

        while (changeDue >= .25){
            numberOfQuarters++;
            changeDue -= .25;
        }

        while (changeDue >= .10){
            numberOfDimes++;
            changeDue -= .1;
        }

        while (changeDue >= .05){
            numberOfNickles++;
            changeDue -= .05;
        }

        changeInCoins = numberOfDimes + " dimes " + numberOfNickles + " nickles" + numberOfQuarters + " quarters.";

        return changeInCoins;
    }

    public double getMoneyFed() {
        return moneyFed;
    }

    public double getPrice() {
        return price;
    }

    public double setChangeDue() {
        changeDue = moneyFed - price;
        return changeDue;
    }
}