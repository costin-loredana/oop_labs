package com.CoffeeDescription;

public class PumpkinSpiceLatte extends Cappuccino {
    private int mgOfPumpkinSpice;

    public PumpkinSpiceLatte(Intensity intensity, CoffeeName name, int mlOfMilk, int mgOfPumpkinSpice) {
        super(intensity, name, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    @Override
    public void makeCappuccino() {
        System.out.println("Preparing Pumpkin Spice Latte with " + getMlOfMilk() + " ml of milk."); // Use this instance's mlOfMilk
        System.out.println("Step 1: Brew the coffee at " + getIntensity() + " intensity");
        System.out.println("Step 2: Pour the coffee in the cup");
        System.out.println("Step 3. Heat " + getMlOfMilk() + " ml of milk");
        System.out.println("Step 4. Pour the milk in the cup");
        System.out.println("Step 5: Add pumpkin spice: " + mgOfPumpkinSpice + " mg.");
    }
}
