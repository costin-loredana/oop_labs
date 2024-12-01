package com.example.stations;

public class PeopleDinner implements Dineable {
    private int peopleServed = 0;

    @Override
    public void serveDinner(String carId) {
        peopleServed++;
        System.out.println("Serving dinner to people in car " + carId + ".");
    }

    public int getPeopleServed() {
        return peopleServed;
    }

    // Optional: You can reset the count for testing purposes
    public void reset() {
        peopleServed = 0;
    }
}
