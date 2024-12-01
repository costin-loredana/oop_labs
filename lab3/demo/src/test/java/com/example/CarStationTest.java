package com.example;

import com.example.Car.CarType;
import com.example.stations.CarStation;
import com.example.stations.ElectricStation;
import com.example.stations.GasStation;
import com.example.stations.PeopleDinner;
import com.example.stations.RobotDinner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CarStationTest {

 
    // @Test
    // public void testServeCars() {
    //     List<Car> cars = new ArrayList<>();
    //     ElectricStation electricStation = new ElectricStation(cars);
    //     GasStation gasStation = new GasStation(cars);
    //     PeopleDinner peopleDinner = new PeopleDinner();
    //     RobotDinner robotDinner = new RobotDinner();
    //     Semaphore semaphore = new Semaphore();

    
    //     Car car1 = new Car("Car1", true, CarType.ELECTRIC,false,12);   // Person
    //     Car car2 = new Car("Car2", true, CarType.ELECTRIC,true,51);        // Person
    //     Car car3 = new Car("Car3", false, CarType.ELECTRIC,true,12);  // Robot
    //     Car car4 = new Car("Car4", true, CarType.GAS,true,1);       // Robot
    //     Car car5 = new Car("Car5", false, CarType.GAS,false,14);    // Person
    //     Car car6 = new Car("Car6", true, CarType.ELECTRIC,true,2);       // Robot
    
    //     cars.add(car1);
    //     cars.add(car2);
    //     cars.add(car3);
    //     cars.add(car4);
    //     cars.add(car5);
    //     cars.add(car6);
    
    //     semaphore.classifyCars(cars);

    //     Queue<Car> people_Ele_Queue = semaphore.getPeopleEleQueue();
    //     Queue<Car> robot_Ele_Queue = semaphore.getRobotEleQueue();
    //     Queue<Car> people_Gas_Queue = semaphore.getPeopleGasQueue();
    //     Queue<Car> robot_Gas_Queue = semaphore.getRobotGasQueue();

      
    //     CarStation peopleCarStation = new CarStation(peopleDinner, electricStation, people_Ele_Queue);
    //     CarStation robotCarStation = new CarStation(robotDinner, electricStation, robot_Ele_Queue);
       

    //     peopleCarStation.serveCars();
    //     robotCarStation.serveCars();

    //     CarStation people_CarStation = new CarStation(peopleDinner, gasStation, people_Gas_Queue);
    //     CarStation robot_CarStation = new CarStation(robotDinner, gasStation, robot_Gas_Queue);


    //     people_CarStation.serveCars();
    //     robot_CarStation.serveCars();

    //     System.out.println("Electric:"+electricStation.getElectricCarsServed() + " GAS:"+gasStation.getGasCarsServed());
    //     System.out.println("People:"+peopleDinner.getPeopleServed() + " Robot:"+robotDinner.getRobotsServed());
    //     System.out.println("DINING:"+semaphore.isDining() + " NOT_DINING:"+semaphore.is_NotDining());
    //     System.out.println("Electric:"+electricStation.getEleConsuption() + " GAS:"+gasStation.getGasConsuption());
      
    // }
    
    @Test
public void testServeCars() {
    try {
        CarGenerator carGenerator = new CarGenerator();
        List<Car> cars = carGenerator.generateCars();

        ElectricStation electricStation = new ElectricStation(cars);
        GasStation gasStation = new GasStation(cars);
        PeopleDinner peopleDinner = new PeopleDinner();
        RobotDinner robotDinner = new RobotDinner();
        Semaphore semaphore = new Semaphore();

        semaphore.classifyCars(cars);

        Queue<Car> peopleEleQueue = semaphore.getPeopleEleQueue();
        Queue<Car> robotEleQueue = semaphore.getRobotEleQueue();
        Queue<Car> peopleGasQueue = semaphore.getPeopleGasQueue();
        Queue<Car> robotGasQueue = semaphore.getRobotGasQueue();

        CarStation peopleCarStation = new CarStation(peopleDinner, electricStation, peopleEleQueue);
        CarStation robotCarStation = new CarStation(robotDinner, electricStation, robotEleQueue);

        peopleCarStation.serveCars();
        robotCarStation.serveCars();

        CarStation peopleCarStationGas = new CarStation(peopleDinner, gasStation, peopleGasQueue);
        CarStation robotCarStationGas = new CarStation(robotDinner, gasStation, robotGasQueue);

        peopleCarStationGas.serveCars();
        robotCarStationGas.serveCars();

        System.out.println("Electric: " + electricStation.getElectricCarsServed() + " GAS: " + gasStation.getGasCarsServed());
        System.out.println("People: " + peopleDinner.getPeopleServed() + " Robot: " + robotDinner.getRobotsServed());
        System.out.println("DINING: " + semaphore.isDining() + " NOT_DINING: " + semaphore.is_NotDining());
        System.out.println("Electric: " + electricStation.getEleConsuption() + " GAS: " + gasStation.getGasConsuption());
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
