package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VendingMachineCLI extends Products{

	double moneyFed;
	String name;
	double price;


	public VendingMachineCLI(double moneyFed, double price, String name) {

			super(name, price);
			this.moneyFed = moneyFed;

			Scanner input = new Scanner(System.in);
			String firstChoiceMade = "";
			String secondChoiceMade = "";

			System.out.println("(1) Display Vending Machine Items");
			System.out.println("(2) Purchase");
			System.out.println("(3) Exit");
			firstChoiceMade = input.nextLine();

			if (firstChoiceMade == "1") {

			} else if (firstChoiceMade == "2") {
				System.out.println("(1) Feed Money");
				System.out.println("(2) Select Product");
				System.out.println("(3) Finish Purchase");
				System.out.println();
				System.out.println("Current money Provided: " + moneyFed);
				secondChoiceMade = input.nextLine();
			} else if (firstChoiceMade == "3") {
				System.out.println("Program ending.");
			} else {
				System.out.println("Invalid choice.");
			}


			if (secondChoiceMade == "1") {

				System.out.println("How much money (in dollars) would you like to add?");
				moneyFed = Double.parseDouble(input.nextLine());

			} else if (secondChoiceMade == "2") {
				System.out.println("What product would you like to buy?");
				name = input.nextLine();
			} else if (secondChoiceMade == "3") {

			} else {
				System.out.println("Invalid choice.");
			}



		}

	public void printTransaction(String name, String itemSlot, double price) {
		File transactionLog = new File("transactionLog.txt");
		if (!transactionLog.exists()) {
			try {
				transactionLog.createNewFile();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try (PrintWriter pw = new PrintWriter(new FileWriter(transactionLog, true))) {

			//	pw.println("DateTime            | Product | Slot | AmountAccepted | Balance");

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		try (PrintWriter pw = new PrintWriter(new FileWriter(transactionLog, true))) {

			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-uuuu hh:mm a");
			pw.print(formatter.format(dateTime) + " | ");
			pw.print(name + " | ");
			pw.print(itemSlot + "   | ");
			pw.print(moneyFed + " | ");
			// pw.println(changeInCoins(moneyFed - itemPrice));
		} catch (Exception e) {
			System.out.println("There was a problem writing to the log file.");
			System.out.println(e.getMessage());
		}

	}

	@Override
	public String getSound() {
		return null;
	}

}
/*
public class Item {
	private String slot;
	private String name;
	private int price;
	private int stock;
	private int sales;

	public Item(String slot, String name, int price)
	{
		this.slot = slot;
		this.name = name;
		this.price = price;
		stock = 5;
		sales = 0;
	}
 */

