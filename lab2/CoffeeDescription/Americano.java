package lab2.CoffeeDescription;

public class Americano extends Coffee{
    //private Intensity intensityOfCoffee;
    private int mlOfWater;
    private final String coffeeName = "Americano";

    public Americano(Intensity coffeeIntensity, int mlOfWater){
        super(coffeeIntensity);
        //this.intensityOfCoffee = intensityOfCoffee;
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    public String getCoffeeName() {
        return coffeeName;
    }
}
