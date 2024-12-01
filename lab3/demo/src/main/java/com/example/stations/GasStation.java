package com.example.stations;
import com.example.Car;
import java.util.List;
public class GasStation implements Refuelable {
    private int gasCarsServed = 0;
    private int gas_consumption = 0;
    private List<Car> cars;
    public GasStation(List<Car> cars){
        this.cars = cars;
    }

    @Override
    public void refuel(String carId) {
        Car car = findCarById(carId);
        if( car != null && car.needsRefueling()){
            gasCarsServed++;

            gas_consumption+=car.get_consumption();
            System.out.println("Refueling gas car " + car.getCarId() + ".");
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

    public int getGasCarsServed() {
        return gasCarsServed;
    }

    public int getGasConsuption(){
        return gas_consumption;
    }
    // Optional: You can reset the count for testing purposes
    public void reset() {
        gasCarsServed = 0;
        gas_consumption = 0;
    }
}
