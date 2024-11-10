package com.Barista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.CoffeeDescription.Coffee;
import com.CoffeeDescription.Cappuccino;
import com.CoffeeDescription.Americano;
import com.CoffeeDescription.PumpkinSpiceLatte;
import com.CoffeeDescription.SyrupCappuccino;
import com.CoffeeDescription.Intensity;
import com.CoffeeDescription.CoffeeName;
import com.CoffeeDescription.SyrupType;

public class Barista {
    // List to hold the coffee menu
    private List<Coffee> coffeeMenu;

    public Barista() {
        coffeeMenu = createCoffeeMenu();
    }

    private Coffee createCappuccino(Intensity intensity, CoffeeName name, int mlOfMilk) {
        return new Cappuccino(intensity, name, mlOfMilk);
    }

    private Coffee createAmericano(Intensity intensity, CoffeeName name, int mlOfWater) {
        return new Americano(intensity, name, mlOfWater);
    }

    private Coffee createSyrupCappuccino(Intensity intensity, CoffeeName name, int mlOfMilk, SyrupType syrup) {
        return new SyrupCappuccino(intensity, name, mlOfMilk, syrup);
    }

    private Coffee createPumpkinSpiceLatte(Intensity intensity, CoffeeName name, int mlOfMilk, int mgOfPumpkinSpice) {
        return new PumpkinSpiceLatte(intensity, name, mlOfMilk, mgOfPumpkinSpice);
    }

    // Create the coffee menu upon Barista initialization
    private List<Coffee> createCoffeeMenu() {
        List<Coffee> coffeeMenu = new ArrayList<>();
        coffeeMenu.add(createCappuccino(Intensity.STRONG, CoffeeName.Cappuccino, 200));
        coffeeMenu.add(createAmericano(Intensity.STRONG, CoffeeName.Americano, 300));
        coffeeMenu.add(createSyrupCappuccino(Intensity.NORMAL, CoffeeName.SyrupCappuccino, 200, SyrupType.CHOCOLATE));
        coffeeMenu.add(createPumpkinSpiceLatte(Intensity.LIGHT, CoffeeName.PumpkinSpiceLatte, 250, 50));
        return coffeeMenu;
    }

    // Method to get the coffee menu (read-only access)
    public List<Coffee> getCoffeeMenu() {
        return new ArrayList<>(coffeeMenu); // Return a copy to prevent external modification
    }

    public void orderCoffee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Coffee Menu:");
        for (int i = 0; i < coffeeMenu.size(); i++) {
            System.out.println((i + 1) + ". " + coffeeMenu.get(i).getName());
        }
        System.out.print("Enter the number of the coffee you would like to order: ");
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= coffeeMenu.size()) {
            makeCoffee(choice);
        } else {
            System.out.println("Invalid selection.");
        }
    }
    // Example method to make all coffees (encapsulating behavior)
    private void makeCoffee(int choice) {
        Coffee selectedCoffee = coffeeMenu.get(choice - 1);
        System.out.println("Creating: " + selectedCoffee.getName());
        Scanner scanner = new Scanner(System.in);
    
        if (selectedCoffee instanceof SyrupCappuccino) {
            // Display syrup options dynamically from the SyrupType enum
            System.out.println("Please select a syrup type:");
            SyrupType[] syrupTypes = SyrupType.values();
            for (int i = 0; i < syrupTypes.length; i++) {
                System.out.println((i + 1) + ". " + syrupTypes[i].name());
            }
    
            int syrupChoice = -1; // Start with an invalid value
            boolean validChoice = false;  // Flag to track if input is valid
            SyrupType syrupType = null;  // Initialize syrupType here
    
            while (!validChoice) {
                System.out.print("Enter the number of your choice: ");
                try {
                    syrupChoice = scanner.nextInt();
    
                    // Check if the chosen number is within the valid range
                    if (syrupChoice >= 1 && syrupChoice <= syrupTypes.length) {
                        syrupType = syrupTypes[syrupChoice - 1]; // Get the chosen syrup type
                        validChoice = true;  // If valid, exit the loop
                    } else {
                        System.out.println("We are sorry, we do not have such syrup. Please select from the valid flavors.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); // Clear the invalid input (to prevent infinite loop)
                }
            }
    
            // Create a custom SyrupCappuccino with the chosen syrup type
            SyrupCappuccino syrupCappuccino = new SyrupCappuccino(
                ((SyrupCappuccino) selectedCoffee).getIntensity(),
                selectedCoffee.getName(),
                ((SyrupCappuccino) selectedCoffee).getMlOfMilk(),
                syrupType
            );
    
            syrupCappuccino.makeCappuccino(); // Call the method to "make" the coffee
    
        } else if (selectedCoffee instanceof Cappuccino) {
            ((Cappuccino) selectedCoffee).makeCappuccino();
    
        } else if (selectedCoffee instanceof Americano) {
            ((Americano) selectedCoffee).makeAmericano();
    
        } else if (selectedCoffee instanceof PumpkinSpiceLatte) {
            ((PumpkinSpiceLatte) selectedCoffee).makeCappuccino();
        }
    }
    
}
