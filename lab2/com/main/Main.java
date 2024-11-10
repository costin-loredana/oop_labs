package com.main;

import com.Barista.Barista;

public class Main {
    public static void main(String[] args) {
        Barista barista = new Barista();
        
        // Make all coffees through Barista
        barista.makeAllCoffees();
        
        // Optionally, you can display the menu if needed
        // System.out.println("Coffee Menu: " + barista.getCoffeeMenu());
    }
}
