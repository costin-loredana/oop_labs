package lab2.CoffeeDescription;

public class Cappuccino extends Coffee {
    //private Intensity intensity;
    private int mlOfMilk;
    private final String coffee = "Cappuccino";

    public Cappuccino(Intensity coffeeIntensity, int mlOfMilk ) { //Intensity intesity
        super(coffeeIntensity);
        //this.intensity = intensity;
        this.mlOfMilk = mlOfMilk;
    }

    // public Intensity getIntensity() {
    //     return intensity;
    // }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public String getCoffee() {
        return coffee;
    }
}
