package com.CoffeeDescription;

public class Americano extends Coffee{

    private int mlOfWater;

    public Americano(Intensity coffeeIntensity, CoffeeName coffeeType, int mlOfWater){
        super(coffeeIntensity, coffeeType);
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    //method reuse for printing details:
    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("You wanted " + getMlOfWater() + " ml of water");
    }

    public Americano makeAmericano() {
        System.out.println( getCoffeeType() + "in preparation... ");
        System.out.println("Step 1: Brew a shot of espresso, having " + getCoffeeIntensity() + " intensity");
        System.out.println("Step 2: Pour the espresso on the cup: ");
        System.out.println("Step 3: Pour: " +  getMlOfWater() + " ml of water on the cup");
        System.out.println("Your Americano is ready!! ");
        return this;
    }
}
