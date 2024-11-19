package com.CoffeeDescription;

public class Americano extends Coffee {
    private int mlOfWater;

    public Americano(Intensity intensity, CoffeeName name, int mlOfWater) {
        super(intensity, name);
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    @Override
    protected void printCoffeeDetails() {
        System.out.println("Preparing Americano with " + mlOfWater + " ml of water.");
    }

    public void makeAmericano() {
        printCoffeeDetails();
        System.out.println("Step 1: Brew the coffee with " + intensity + " intensity");
        System.out.println("Step 2: Heat " + mlOfWater + " ml of water");
        System.out.println("Step 3: Pour the coffe in the cup ");
        System.out.println("Step 4: Pour the hot water in the cup ");
    }
}
