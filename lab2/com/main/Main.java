package com.main;

import java.util.Scanner;

import com.Barista.Barista;

public class Main {
    public static void main(String[] args) {
        Barista barista = new Barista();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to COOL COFFEE! Here's our menu:");
            System.out.println("Would you like to order anything? (yes/no)");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("yes")) {
                // Start the coffee ordering loop
                boolean continueOrdering = true;
                while (continueOrdering) {
                    System.out.println("What would you like to order?");
                    barista.orderCoffee();

                    // After placing the order, ask if the user wants to order another coffee
                    System.out.println("Would you like to order another coffee? (yes/no)");
                    String orderAgain = scanner.nextLine().toLowerCase();
                    if (orderAgain.equals("no")) {
                        continueOrdering = false;  // Exit the loop if the user doesn't want another coffee
                    } else if (!orderAgain.equals("yes")) {
                        System.out.println("Please enter 'yes' or 'no'.");
                    }
                }
            } else if (choice.equals("no")) {
                System.out.println("Okay, I'll let you decide then.");
                break;  // Exit the program if the user doesn't want to order
            } else {
                System.out.println("Please enter 'yes' or 'no' to continue.");
            }
        }

        scanner.close();  // Close the scanner when done
    }
}
