package com.main;

import com.CoffeeDescription.Coffee;
import com.CoffeeDescription.Americano;
import com.CoffeeDescription.Cappuccino;
import com.CoffeeDescription.PumpkinSpiceLatte;
import com.CoffeeDescription.SyrupCappuccino;
import com.CoffeeDescription.Intensity;
import com.CoffeeDescription.CoffeeName;
import com.CoffeeDescription.SyrupType;

public class Main {
    public static void main(String[] args) {
        // Create a Cappuccino instance
        Coffee myCappuccino = new Cappuccino(Intensity.NORMAL, CoffeeName.Cappuccino, 200);
        if (myCappuccino instanceof Cappuccino) {
            Cappuccino cappuccino = (Cappuccino) myCappuccino;
            cappuccino.printCoffeeDetails();
            cappuccino.makeCappuccino(); // This should be implemented in the Cappuccino class
        }

        // Create a SyrupCappuccino instance
        Coffee mySyrupCappuccino = new SyrupCappuccino(Intensity.NORMAL, CoffeeName.SyrupCappuccino, 150, SyrupType.MACADAMIA);
        if (mySyrupCappuccino instanceof SyrupCappuccino) {
            SyrupCappuccino syrupCappuccino = (SyrupCappuccino) mySyrupCappuccino;
            syrupCappuccino.printCoffeeDetails();
            syrupCappuccino.makeSyrupCappuccino(); // Ensure this method is implemented in the SyrupCappuccino class
        }

        // Create a PumpkinSpiceLatte instance
        Coffee myPumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.LIGHT, CoffeeName.PumpkinSpiceLatte, 200, 50);
        if (myPumpkinSpiceLatte instanceof PumpkinSpiceLatte) {
            PumpkinSpiceLatte pumpkinSpiceLatte = (PumpkinSpiceLatte) myPumpkinSpiceLatte;
            pumpkinSpiceLatte.printCoffeeDetails();
            pumpkinSpiceLatte.makePumpkinSpiceLatte(); // Ensure this method is implemented in the PumpkinSpiceLatte class
        }

        // Create an Americano instance
        Coffee myAmericano = new Americano(Intensity.STRONG, CoffeeName.Americano, 300);
        if (myAmericano instanceof Americano) {
            Americano americano = (Americano) myAmericano;
            americano.printCoffeeDetails();
            americano.makeAmericano(); // Ensure this method is implemented in the Americano class
        }
    }
}
