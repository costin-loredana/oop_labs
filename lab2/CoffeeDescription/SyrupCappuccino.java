package lab2.CoffeeDescription;

public class SyrupCappuccino extends Cappuccino{
    //private Intensity intensityCoffee;
    //private int mlOfMilk;
    private SyrupType syrup;
    private final String coffee = "SyrupCappuccino";

    public SyrupCappuccino(Intensity coffeeIntensity, int mlOfMilk, SyrupType syrup){
        super(coffeeIntensity, mlOfMilk);
        this.syrup = syrup;
    }

    public SyrupType getSyrupType() {
        return syrup;
    }

    public String getCoffee() {
        return coffee;
    }
}
enum SyrupType {
    MACADAMIA, VANILLA, COCONUT, CARAMEL,
    CHOCOLATE, POPCORN;
}
