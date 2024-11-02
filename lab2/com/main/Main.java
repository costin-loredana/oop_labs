package lab2.main;

import CoffeeDescription.Coffee;
import CoffeeDescription.Americano;
import CoffeeDescription.Cappuccino;
import CoffeeDescription.PumpkinSpiceLatte;
import CoffeeDescription.SyrupCappuccino;
import lab2.CoffeeDescription.Intensity;
import lab2.CoffeeDescription.CoffeeName;
import lab2.CoffeeDescription.SyrupType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) { 
        Americano myAmericano = new Americano(Intensity.STRONG, CoffeeName.AMERICANO, 200);
        Cappuccino myCappuccino = new Cappuccino(Intensity.NORMAL, CoffeeName.CAPPUCCINO, 200); 
        SyrupCappuccino mySyrupCappuccino = new SyrupCappuccino(Intensity.NORMAL, CoffeeName.SYRUP_CAPPUCCINO, 200, SyrupType.MACADAMIA);
        PumpkinSpiceLatte myPumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.LIGHT, CoffeeName.PUMPKIN_SPICE_LATTE, 200, 50);

        myAmericano.printCoffeeDetails();
        myCappuccino.printCoffeeDetails();
        mySyrupCappuccino.printCoffeeDetails();
        myPumpkinSpiceLatte.printCoffeeDetails();

       
    }
}
