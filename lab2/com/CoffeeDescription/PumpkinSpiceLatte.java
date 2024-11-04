package com.CoffeeDescription;


public class PumpkinSpiceLatte extends Cappuccino {

    private int mgOfPumpkinSpice;

    public PumpkinSpiceLatte(Intensity coffeeIntensity, CoffeeName coffeeType, int mlOfMilk, int mgOfPumpkinSpice){
        super(coffeeIntensity, coffeeType, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public int getMgOfPumpkinSpice(){
        return mgOfPumpkinSpice;
    }


    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("You wanted " + getMgOfPumpkinSpice() + " mg of pumpkin spice");
    }

    public PumpkinSpiceLatte makePumpkinSpiceLatte() {
        System.out.println( getCoffeeType() + "in preparation... ");
        System.out.println("Step 1: Brew a shot of espresso, having " + getCoffeeIntensity() + " intensity");
        System.out.println("Step 2: Pour the espresso on the cup: ");
        System.out.println("Step 3: Heat: " +  getMlOfMilk() + " ml of milk");
        System.out.println("Step 4: Pour the heat milk over espresso. ");
        System.out.println("Step 5: Add " + getMgOfPumpkinSpice() + " mg of pumpkin spice.");
        System.out.println("Your Pumpkin Spice Latte is ready!! ");
        return this;
    }
}
