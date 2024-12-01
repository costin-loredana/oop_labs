package com.example.stations;

public class RobotDinner implements Dineable {
    private  int robotsServed = 0;

    @Override
    public void serveDinner(String carId) {
        robotsServed++;
        System.out.println("Serving dinner to robots in car " + carId + ".");
    }

    public  int getRobotsServed() {
        return robotsServed;
    }

    public void reset() {
        robotsServed = 0;
    }
}
