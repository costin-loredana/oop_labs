package lab2.CoffeeDescription;

public class Coffee {
    private Intensity coffeeIntensity;
    private final String name = "coffee";
}

enum CoffeeType{
    Americano, Cappuccino, PumpkinSpiceLatte;
}

public Coffee(Intensity coffeeIntensity){
    this.coffeeIntensity = coffeeIntensity;

public String getName(){
    return name;
}
}
enum Intensity {
    LIGHT, NORMAL, STRONG;
}
