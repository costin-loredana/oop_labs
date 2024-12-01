package com.example;

public class Car {
    private String carId;
    private CarType carType;
    private boolean hasPerson;
    private boolean isDining;
    private int consumption;

    public enum CarType {
        ELECTRIC,
        GAS
    }

    public Car(String carId, boolean hasPerson, CarType carType,boolean isDining,int consumption) {
        this.carId = carId;
        this.hasPerson = hasPerson;
        this.carType = carType;
        this.isDining = isDining;
        this.consumption = consumption;
    }
    
    public boolean needsRefueling() {
        return carType == CarType.GAS;
    }

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

    public boolean get_isDining(){
        return isDining;
    }

    public int get_consumption(){
        return consumption;
    }
}
