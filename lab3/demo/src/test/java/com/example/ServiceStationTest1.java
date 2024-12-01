package com.example;

import com.example.stations.PeopleDinner;
import com.example.stations.RobotDinner;
import com.example.stations.ElectricStation;
import com.example.stations.GasStation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class ServiceStationTest1 {

    @Test
    public void testServiceStation() {
        // Create a list of cars
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Car1", false, Car.CarType.GAS));  // Gas car
        cars.add(new Car("Car2", true, Car.CarType.GAS));   // Gas car
        cars.add(new Car("Car3", true, Car.CarType.ELECTRIC)); // Electric car
        cars.add(new Car("Car4", false, Car.CarType.ELECTRIC)); // Electric car
        cars.add(new Car("Car5", false, Car.CarType.ELECTRIC)); // Electric car
        cars.add(new Car("Car6", true, Car.CarType.GAS));   // Gas car

        // Create instances of the stations
        PeopleDinner peopleDinner = new PeopleDinner();
        RobotDinner robotDinner = new RobotDinner();
        ElectricStation electricStation = new ElectricStation(cars);  // Pass cars to the station
        GasStation gasStation = new GasStation(cars);  // Pass cars to the station

        System.out.println("Starting testServiceStation...");

        // Serve dinner and refuel cars (using carId string)
        peopleDinner.serveDinner("Car1");
        peopleDinner.serveDinner("Car2");
        robotDinner.serveDinner("Car3");
        electricStation.refuel("Car4");
        electricStation.refuel("Car5");
        gasStation.refuel("Car6");

        // Print the results
        System.out.println("People served: " + peopleDinner.getPeopleServed());
        System.out.println("Robots served: " + robotDinner.getRobotsServed());
        System.out.println("Electric cars refueled: " + electricStation.getElectricCarsServed());
        System.out.println("Gas cars refueled: " + gasStation.getGasCarsServed());

        // Assertions to verify the counts
        assertEquals(2, peopleDinner.getPeopleServed());
        assertEquals(1, robotDinner.getRobotsServed());
        assertEquals(2, electricStation.getElectricCarsServed());
        assertEquals(1, gasStation.getGasCarsServed());

        System.out.println("testServiceStation completed.");
    }
}
