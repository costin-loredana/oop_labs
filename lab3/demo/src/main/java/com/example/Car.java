package com.example;

public class Car {
    private String carId;
    private CarType carType;
    private boolean hasPerson;

    public enum CarType {
        ELECTRIC,
        GAS
    }

    public Car(String carId, boolean hasPerson, CarType carType) {
        this.carId = carId;
        this.hasPerson = hasPerson;
        this.carType = carType;
    }

    // This method checks if the car is a gas car
    public boolean needsRefueling() {
        return carType == CarType.GAS;
    }

    // This method checks if the car is an electric car
    public boolean needsCharging() {
        return carType == CarType.ELECTRIC;
    }

    public String getCarId() {
        return carId;
    }

    public boolean hasPerson() {
        return hasPerson;
    }
    public CarType getCarType() {
        return carType;
    }
}
