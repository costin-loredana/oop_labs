package com.CoffeeDescription;


public class Cappuccino extends Coffee {
    
    private int mlOfMilk;
    
    public Cappuccino(Intensity coffeeIntensity, CoffeeName coffeeType, int mlOfMilk ) { 
        super(coffeeIntensity, coffeeType);
        this.mlOfMilk = mlOfMilk;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    //method reuse for printing details:
    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("You wanted " + getMlOfMilk() + " ml of milk");
    }
    //make Cappuccino method: using upcasting, because we are 
    public Cappuccino makeCappuccino() {
        System.out.println( getCoffeeType() + "in preparation... ");
        System.out.println("Step 1: Brew a shot of espresso, having " + getCoffeeIntensity() + " intensity");
        System.out.println("Step 2: Pour the espresso on the cup: ");
        System.out.println("Step 3: Heat: " +  getMlOfMilk() + " ml of milk");
        System.out.println("Step 5: Pour the heat milk over espresso. ");
        System.out.println("Your Cappuccino is ready!! ");
        return this;
    }
}
