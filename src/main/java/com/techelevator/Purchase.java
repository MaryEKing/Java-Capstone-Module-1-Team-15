package com.techelevator;
import com.techelevator.Purchase;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Purchase extends VendingMachineCLI{
    private double moneyFed;
    private double price;
    private double changeDue;
    private int numberOfQuarters;
    private int numberOfDimes;
    private int numberOfNickles;
    String changeInCoins;


    public Purchase(double changeDue) throws FileNotFoundException , IOException {
        this.changeDue = changeDue;
    }


    public String makeChange(){



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

    public void setMoneyFed(double moneyFed) {
        this.moneyFed = moneyFed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getChangeDue() {
        return changeDue;
    }

    public double setChangeDue() {
        changeDue = moneyFed - price;
        return changeDue;
    }

    public void setChangeInCoins(String changeInCoins) {
        this.changeInCoins = changeInCoins;
    }
}