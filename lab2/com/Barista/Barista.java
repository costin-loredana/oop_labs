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
        List<Coffee> coffeeMenu = getCoffeeMenu();
        Scanner scanner = new Scanner(system.in);
        System.out.println("Coffee Menu:");
        for(int i=0; i<coffeeMenu.size(); i++){
            System.out.println((i + 1) + ". " + coffeeMenu.get(i).getName());
        }
        System.out.println("Enter the number of coffee you would like to order: ");
        int choice = scanner.nextInt();
    }
    // Example method to make all coffees (encapsulating behavior)
    public void makeAllCoffees() {
        for (Coffee coffee : coffeeMenu) {
            System.out.println("Creating: " + coffee.getName());
            if (coffee instanceof Cappuccino) {
                ((Cappuccino) coffee).makeCappuccino();
            } else if (coffee instanceof Americano) {
                ((Americano) coffee).makeAmericano();
            } else if (coffee instanceof SyrupCappuccino) {
                ((SyrupCappuccino) coffee).makeCappuccino();
            } else if (coffee instanceof PumpkinSpiceLatte) {
                ((PumpkinSpiceLatte) coffee).makeCappuccino();
            }
        }
    }
}
