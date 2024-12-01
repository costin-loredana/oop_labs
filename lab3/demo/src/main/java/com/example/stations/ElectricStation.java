package com.example.stations;
import java.util.List;
import com.example.Car;

public class ElectricStation implements Refuelable {
    private int electricCarsServed = 0;
    private List<Car> cars;

    public ElectricStation(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public void refuel(String carId) {
        Car car = findCarById(carId);
            if (car !=null && car.needsCharging()) {
                electricCarsServed++;
                System.out.println("Refueling electric car " + car.getCarId() + ".");
            }
    }
    
    

    private Car findCarById(String carId){
        for(Car car : cars){
            if(car.getCarId().equals(carId)){
                return car;
            }
        }
        return null;
    }

    public int getElectricCarsServed() {
        return electricCarsServed;
    }

    public void reset() {
        electricCarsServed = 0;
    }
}