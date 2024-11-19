package com.CoffeeDescription;

public class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;

    public SyrupCappuccino(Intensity intensity, CoffeeName name, int mlOfMilk, SyrupType syrup) {
        super(intensity, name, mlOfMilk);
        this.syrup = syrup;
    }

    public SyrupType getSyrup() {
        return syrup;
    }

    @Override
    public void makeCappuccino() {
        System.out.println("Preparing Syrup Cappuccino with " + getMlOfMilk() + " ml of milk."); 
        System.out.println("Step 1: Adding syrup in the cup: " + syrup);
        System.out.println("Step 2: Brew the coffee at " + getIntensity() + " intensity");
        System.out.println("Step 3: Pour the coffee in the cup");
        System.out.println("Step 4. Heat " + getMlOfMilk() + " ml of milk");
        System.out.println("Step 5. Pour the milk in the cup");
        
    }
}
