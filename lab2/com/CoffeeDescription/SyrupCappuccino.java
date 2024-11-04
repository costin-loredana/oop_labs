package com.CoffeeDescription;

public class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;

    public SyrupCappuccino(Intensity coffeeIntensity, CoffeeName coffeeType, int mlOfMilk, SyrupType syrup) {
        super(coffeeIntensity, coffeeType, mlOfMilk);
        this.syrup = syrup;
    }

    public SyrupType getSyrupType() {
        return syrup;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("You wanted " + getSyrupType() + " syrup !");
    }

    public SyrupCappuccino makeSyrupCappuccino() {
        System.out.println(getCoffeeType() + " in preparation... ");
        System.out.println("Step 1: Pour the " + getSyrupType() + " syrup in the cup.");
        System.out.println("Step 2: Brew a shot of espresso, having " + getCoffeeIntensity() + " intensity");
        System.out.println("Step 3: Pour the espresso in the cup: ");
        System.out.println("Step 4: Heat: " + getMlOfMilk() + " ml of milk");
        System.out.println("Step 5: Pour the heated milk over espresso.");
        System.out.println("Your Syrup Cappuccino is ready!! ");
        return this;
    }
}
