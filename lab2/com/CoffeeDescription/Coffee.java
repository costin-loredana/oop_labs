package com.CoffeeDescription;

public class Coffee {
    private Intensity coffeeIntensity;
    private final String name = "coffee";
    private CoffeeName coffeeType;

    public Coffee(Intensity coffeeIntensity, CoffeeName coffeeType) {
        this.coffeeIntensity = coffeeIntensity;
        this.coffeeType = coffeeType;
    }

    public CoffeeName getCoffeeType() {
        return coffeeType;
    }

    public Intensity getCoffeeIntensity() {
        return coffeeIntensity;
    }

    public String getName() {
        return name;
    }

    public void printCoffeeDetails() {
        System.out.println("Your " + getName() + " drink is: " + getCoffeeType());
        System.out.println("Coffee's Intensity: " + getCoffeeIntensity());
    }
}
