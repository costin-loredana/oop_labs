package com.example;

import com.example.Car.CarType;
import com.example.stations.CarStation;
import com.example.stations.ElectricStation;
import com.example.stations.GasStation;
import com.example.stations.PeopleDinner;
import com.example.stations.RobotDinner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class CarStationTest {

    @Test
    public void testServeCars_Refuel() {
        List<Car> electricCars = new ArrayList<>();
        List<Car> gasCars = new ArrayList<>();

        ElectricStation electricStation = new ElectricStation(electricCars);
        GasStation gasStation = new GasStation(gasCars);

        Car car1 = new Car("Car1", false, CarType.ELECTRIC);  // Electric Car
        Car car2 = new Car("Car2", true, CarType.GAS);        // Gas Car
        Car car3 = new Car("Car3", false, CarType.ELECTRIC);  // Electric Car
        Car car4 = new Car("Car4", true, CarType.GAS);        // Gas Car

        electricCars.add(car1);
        electricCars.add(car3);

        gasCars.add(car2);
        gasCars.add(car4);

        Queue<Car> electricQueue = new ArrayQueue<>();
        Queue<Car> gasQueue = new ArrayQueue<>();

        electricQueue.enqueue(car1);
        electricQueue.enqueue(car3);

        gasQueue.enqueue(car2);
        gasQueue.enqueue(car4);

        CarStation electricCarStation = new CarStation(null, electricStation, electricQueue);
        CarStation gasCarStation = new CarStation(null, gasStation, gasQueue);

        electricCarStation.serveCars();

        gasCarStation.serveCars();
        
        assertEquals(2, electricStation.getElectricCarsServed(), "Electric cars should be charged correctly");
        assertEquals(2, gasStation.getGasCarsServed(), "Gas cars should be refueled correctly");
    }

    @Test
    public void testServeCars_Dining() {
        PeopleDinner peopleDinner = new PeopleDinner();
        RobotDinner robotDinner = new RobotDinner();

        Queue<Car> peopleQueue = new ArrayQueue<>();
        Queue<Car> robotQueue = new ArrayQueue<>();

        Car car1 = new Car("Car1", true, CarType.ELECTRIC);  // Person
        Car car2 = new Car("Car2", true, CarType.GAS);       // Person
        Car car3 = new Car("Car3", false, CarType.ELECTRIC); // Robot
        Car car4 = new Car("Car4", false, CarType.GAS);      // Robot

        peopleQueue.enqueue(car1);
        peopleQueue.enqueue(car2);
        robotQueue.enqueue(car3);
        robotQueue.enqueue(car4);

        CarStation peopleCarStation = new CarStation(peopleDinner, null, peopleQueue);
        CarStation robotCarStation = new CarStation(robotDinner, null, robotQueue);

        peopleCarStation.serveCars();
        
        robotCarStation.serveCars();

        assertEquals(2, peopleDinner.getPeopleServed());
        assertEquals(2, robotDinner.getRobotsServed());
    }

 
    @Test
    public void testServeCars() {
        List<Car> cars = new ArrayList<>();
        ElectricStation electricStation = new ElectricStation(cars);
        GasStation gasStation = new GasStation(cars);
        PeopleDinner peopleDinner = new PeopleDinner();
        RobotDinner robotDinner = new RobotDinner();
    
        Queue<Car> peopleQueue = new ArrayQueue<>();
        Queue<Car> robotQueue = new ArrayQueue<>();
    
        Car car1 = new Car("Car1", true, CarType.ELECTRIC);   // Person
        Car car2 = new Car("Car2", true, CarType.ELECTRIC);        // Person
        Car car3 = new Car("Car3", false, CarType.GAS);  // Robot
        Car car4 = new Car("Car4", false, CarType.GAS);       // Robot
        Car car5 = new Car("Car5", true, CarType.ELECTRIC);    // Person
        Car car6 = new Car("Car6", false, CarType.GAS);       // Robot
    
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
    
        peopleQueue.enqueue(car1);
        peopleQueue.enqueue(car2);
        peopleQueue.enqueue(car5);
    
        robotQueue.enqueue(car3);
        robotQueue.enqueue(car4);
        robotQueue.enqueue(car6);
    
        CarStation peopleCarStation = new CarStation(peopleDinner, electricStation, peopleQueue);
        CarStation robotCarStation = new CarStation(robotDinner, gasStation, robotQueue);
    
        peopleCarStation.serveCars();

        robotCarStation.serveCars();
    
        System.out.println("Electric cars served: " + electricStation.getElectricCarsServed());
        System.out.println("Gas cars served: " + gasStation.getGasCarsServed());
        System.out.println("People served: " + peopleDinner.getPeopleServed());
        System.out.println("Robots served: " + robotDinner.getRobotsServed());
    
        // Verify that the stations served the correct number of cars
        assertEquals(3, electricStation.getElectricCarsServed());
        assertEquals(3, gasStation.getGasCarsServed());
        assertEquals(3, peopleDinner.getPeopleServed());
        assertEquals(3, robotDinner.getRobotsServed());
    }
    
    
}
