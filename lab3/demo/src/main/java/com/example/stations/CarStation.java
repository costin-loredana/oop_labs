package com.example.stations;

import com.example.Car;
import com.example.Queue;

public class CarStation {
    private Dineable diningService;
    private Refuelable refuelingService;
    private Queue<Car> queue;

    public CarStation(Dineable diningService, Refuelable refuelingService, Queue<Car> queue) {
        if (queue == null) {
            throw new IllegalArgumentException("Queue cannot be null.");
        }
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.queue = queue;
    }

    public void serveCars() {
        while (!isEmpty()) {
            Car car = queue.dequeue();
            if(car.getCarType()==Car.CarType.ELECTRIC && refuelingService!=null){
                handleCharging(car);
            }

            if(car.getCarType()==Car.CarType.GAS && refuelingService!=null ){
                handleRefuelCar(car);
            }
            
            handleDining(car);
        }
    }
    
    private void handleRefuelCar(Car car) {
        if (car.needsRefueling()) {
            refuelingService.refuel(car.getCarId());
        }
    }

    private void handleCharging(Car car) {
        if (car.needsCharging()) {
            refuelingService.refuel(car.getCarId());
        }
    }
    
    private void handleDining(Car car) {
        if (diningService != null) {
            if (car.hasPerson() && diningService instanceof PeopleDinner) {
                diningService.serveDinner(car.getCarId());
            } else if (!car.hasPerson() && diningService instanceof RobotDinner) {
                diningService.serveDinner(car.getCarId());
            } else {
                System.out.println("There is not specified who drives the car " + car.getCarId());
            }
        }
    }
    
    private boolean isEmpty() {
        return queue.size() == 0; 
    }
    
    public void addCar(Car car) {
        queue.enqueue(car);
    }
    
}
