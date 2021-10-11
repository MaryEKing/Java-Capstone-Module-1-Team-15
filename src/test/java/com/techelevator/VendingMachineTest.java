package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class VendingMachineTest {


    @Before
    public void SetUp() {
        VendingMachine vendingMachine = new VendingMachine();

    }

    @Test
    public void add_money_adds_correct_amount_to_balance_1() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.feedMoney(1);
        Assert.assertEquals(1, vendingMachine.getBalance(), 0.001);
    }

    @Test
    public void add_money_adds_correct_amount_to_balance_2() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.feedMoney(2);
        Assert.assertEquals(2, vendingMachine.getBalance(), 0.001);
    }

    @Test
    public void add_money_adds_correct_amount_to_balance_5() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.feedMoney(5);
        Assert.assertEquals(5, vendingMachine.getBalance(), 0.001);
    }

    @Test
    public void add_money_adds_correct_amount_to_balance_10() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.feedMoney(10);
        Assert.assertEquals(10, vendingMachine.getBalance(), 0.001);
    }

    @Test
    public void add_money_adds_correct_amount_to_balance_20() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.feedMoney(20);
        Assert.assertEquals(0, vendingMachine.getBalance(), 0.001);
    }

    @Test
    public void make_change_test_two_quarters(){
        VendingMachine vendingMachine = new VendingMachine();
        double changeDue = .5;
        String expected = "2 Quarter(s), 0 Dime(s), 0 Nickel(s)";
        String actual = vendingMachine.returnChange();
        Assert.assertEquals(expected, actual);
    }

}

