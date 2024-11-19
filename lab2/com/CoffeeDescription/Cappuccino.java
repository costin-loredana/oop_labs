package com.CoffeeDescription;

public class Cappuccino extends Coffee {
    protected int mlOfMilk; // Made protected to be accessible in subclasses

    public Cappuccino(Intensity intensity, CoffeeName name, int mlOfMilk) {
        super(intensity, name);
        this.mlOfMilk = mlOfMilk;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    @Override
    protected void printCoffeeDetails() {
        System.out.println("Preparing cappuccino with " + mlOfMilk + " ml of milk.");
    }

    public void makeCappuccino() {
        printCoffeeDetails();
        System.out.println("Step 1: Brew the coffee at " + intensity + " intensity");
        System.out.println("Step 2: Pour the coffee in the cup");
        System.out.println("Step 3. Heat " + mlOfMilk + " of milk");
        System.out.println("Step 4. Pour the milk in the cup");
    }
}
