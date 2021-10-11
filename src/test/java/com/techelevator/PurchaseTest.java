package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PurchaseTest {

    @Test
    public void make_change_test_two_quarters() throws FileNotFoundException, IOException {
        double changeDue = .5;
        Purchase sut = new Purchase(changeDue);
        String expected = "0 dimes, 0 nickels, 2 quarters";
        String actual = sut.makeChange();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void make_change_test_80_cents() throws FileNotFoundException, IOException {
        double changeDue = .8;
        String expected = "0 dimes, 1 nickels, 3 quarters";
        Purchase sut = new Purchase(changeDue);
        String actual = sut.makeChange();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void make_change_test_90_cents() throws FileNotFoundException, IOException {
        double changeDue = .9;
        String expected = "1 dimes, 1 nickels, 3 quarters";
        Purchase sut = new Purchase(changeDue);
        String actual = sut.makeChange();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void make_change_test_no_change_due() throws FileNotFoundException, IOException {
        double changeDue = 0.0;
        String expected = "0 dimes, 0 nickels, 0 quarters";
        Purchase sut = new Purchase(changeDue);
        String actual = sut.makeChange();
        Assert.assertEquals(expected, actual);
    }
}
