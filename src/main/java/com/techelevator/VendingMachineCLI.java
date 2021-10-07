package com.techelevator;

import java.util.Scanner;

public class VendingMachineCLI {

	double moneyFed;
	double price;


	public VendingMachineCLI(double moneyFed, double price) {
			this.moneyFed = moneyFed;
			this.price = price;


			Scanner input = new Scanner(System.in);
			String firstChoiceMade;
			String secondChoiceMade;

			System.out.println("(1) Display Vending Machine Items");
			System.out.println("(2) Purchase");
			System.out.println("(3) Exit");
			firstChoiceMade = input.nextLine();

			if (firstChoiceMade == "1") {

			} else if (firstChoiceMade == "2") {

			} else if (firstChoiceMade == "3") {
				System.out.println("");
			} else {
				System.out.println("Invalid choice.");
			}

			System.out.println("(1) Feed Money");
			System.out.println("(2) Select Product");
			System.out.println("(3) Finish Purchase");
			System.out.println();
			System.out.println("Current money Provided: " + moneyFed);
			secondChoiceMade = input.nextLine();

			if (secondChoiceMade == "1") {

				System.out.println("How much money (in dollars) would you like to add?");
				moneyFed = Double.parseDouble(input.nextLine());

			} else if (secondChoiceMade == "2") {

			} else if (secondChoiceMade == "3") {

			} else {
				System.out.println("Invalid choice.");
			}


		}
	}

