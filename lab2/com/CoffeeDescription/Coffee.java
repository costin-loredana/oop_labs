package com.CoffeeDescription;

public abstract class Coffee {
    protected Intensity intensity;
    protected CoffeeName name;

    protected Coffee(Intensity intensity, CoffeeName name) {
        this.intensity = intensity;
        this.name = name;
    }

    public Intensity getIntensity() {
        return intensity;
    }

    public CoffeeName getName() {
        return name;
    }

    protected abstract void printCoffeeDetails(); // Each coffee type will implement this
}
