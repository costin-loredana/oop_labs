package lab2.CoffeeDescription;

public class PumpkinSpiceLatte extends Cappuccino {
    //private Intensity intensityOfCoffee;
    //private int mlOfMilk;
    private int mgOfPumpkinSpice;
    private final String name = "PumpkinSpicelatte";

    public PumpkinSpiceLatte(Intensity coffeeIntensity, int mlOfMilk, int mgOfPumpkinSpice){
        super(coffeeIntensity, mlOfMilk);
        //this.mlOfMilk = mlOfMilk;
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public int getMgOfPumpkinSpice(){
        return mgOfPumpkinSpice;
    }

    public String getName(){
        return name;
    }
}
