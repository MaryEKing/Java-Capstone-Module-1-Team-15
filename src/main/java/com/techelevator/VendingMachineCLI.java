package com.techelevator;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class VendingMachineCLI {

	double moneyFed;
	String name;
	String slot;
	double price;
	String changeInCoins;
	double balance;
	double changeDue;
	//List<Product> purchasedObjects = new ArrayList<Product>();
	Map<String, Product> inventoryMap;

	public VendingMachineCLI() throws FileNotFoundException, IOException {
		VendingMachine vendingMachine = new VendingMachine();
		// Get the inventory file
		File file = vendingMachine.getInputFile();
		// Read the inventory file and put it in inventoryMap
		this.inventoryMap = vendingMachine.getInventory(file);

		// super(name, price, slot);
		// this.moneyFed = moneyFed;

		Scanner input = new Scanner(System.in);
		String firstChoiceMade = "";
		String secondChoiceMade = "";

		while (true) {
			System.out.println("(1) Display Vending Machine Items");
			System.out.println("(2) Purchase");
			System.out.println("(3) Exit");
			firstChoiceMade = input.nextLine();


			if (firstChoiceMade.equals("1")) {
				listOfItems();
			} else if (firstChoiceMade.equals("2")) {
				System.out.println("(1) Feed Money");
				System.out.println("(2) Select Product");
				System.out.println("(3) Finish Purchase");
				System.out.println();
				System.out.println("Current money Provided: " + vendingMachine.getBalance());
				secondChoiceMade = input.nextLine();

			} else if (firstChoiceMade.equals("3")) {
				System.out.println("Program ending.");
				vendingMachine.returnChange();
				vendingMachine.balance = 0;
				vendingMachine.logFile();
				System.exit(1);
			}


			if (secondChoiceMade.equals("1")) {

				System.out.println("How much money (in dollars) would you like to add?");
				String money = input.nextLine();
				//double moneyInDouble = Double.parseDouble(money);
				//double[] possibleBills = {1.00, 2.00, 5.00, 10.00};
				//for (int i = 0; i < possibleBills.length - 1; i++) {
				//	if (moneyInDouble == possibleBills[i]) {
				//		moneyFed = moneyInDouble;
				//		System.out.println("You've fed $" + moneyFed);
				//		break;
				//	}
			    //}
				vendingMachine.feedMoney(Double.parseDouble(money));

			} else if (secondChoiceMade.equals("2")) {
				System.out.println("What product would you like to buy?");
				slot = input.nextLine();
				price = this.inventoryMap.get(slot).getPrice();
				// Check if there is enough money or if there is a balance
				if (!this.inventoryMap.get(slot).isAvailableToPurchase()
				|| price > vendingMachine.getBalance()){System.out.println("Not Available!");}
				// else do the purchase
				else {
					this.inventoryMap.get(slot).purchaseItem();
					vendingMachine.balance = vendingMachine.balance - price;
					System.out.println("Name: " + this.inventoryMap.get(slot).getName() + " Cost: " + this.inventoryMap.get(slot).getPrice() + " Balance: " + vendingMachine.balance);
					System.out.println(this.inventoryMap.get(slot).getSound());
					vendingMachine.log("PM", price + vendingMachine.balance, vendingMachine.balance);
				}
				//balance += price;
			} else if (secondChoiceMade.equals("3")) {
				//changeDue = moneyFed - balance;
				//System.out.println(changeDue);
				vendingMachine.returnChange();
				vendingMachine.balance = 0;
			} else {
				System.out.println("Invalid choice.");
			}
		} // End of While loop

	}

	private String listOfItems() {

		String[] productArray = new String[this.inventoryMap.size()];
		int ctr = 0;
		Set<Map.Entry<String, Product>> entrySet = this.inventoryMap.entrySet();
		for (Map.Entry<String, Product> entry : entrySet) {
			String key = entry.getKey();
			Product value = entry.getValue();
			productArray[ctr] = key + " " + value.toString();
			System.out.println(key + " " + value.toString());
			ctr++;
		}
		return Arrays.toString(productArray);
	}

	public void printTransaction(String name, String itemSlot, double price) {
		File transactionLog = new File("Log.txt");
		if (!transactionLog.exists()) {
			try {
				transactionLog.createNewFile();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try (PrintWriter pw = new PrintWriter(new FileWriter(transactionLog, true))) {

				pw.println("DateTime            | Product | Slot | AmountAccepted | Balance");

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
			pw.println((moneyFed - price));
		} catch (Exception e) {
			System.out.println("There was a problem writing to the log file.");
			System.out.println(e.getMessage());
		}

	}

	// @Override
	public String getSound() {
		return null;
	}

	// This is the main entry point for ALL java programs. It runs first.
	public static void main(String[] args) throws IOException {


		VendingMachineCLI cli = new VendingMachineCLI();
		//try {
		//	cli.run();
		//} catch (FileNotFoundException e) {
		//	e.printStackTrace();
		//}
	}

	public String getChangeInCoins() {
		return changeInCoins;
	}

}


