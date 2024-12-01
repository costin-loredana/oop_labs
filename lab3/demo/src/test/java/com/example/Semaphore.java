package com.example;

import java.util.List;

public class Semaphore {
    private final Queue<Car> people_Ele_Queue;
    private final Queue<Car> robot_Ele_Queue;
    private final Queue<Car> people_Gas_Queue;
    private final Queue<Car> robot_Gas_Queue;

    private int isNotDining=0;
    private int isDining=0;
    public Semaphore() {
        this.people_Ele_Queue = new ArrayQueue<>();
        this.robot_Ele_Queue = new ArrayQueue<>();
        this.people_Gas_Queue = new ArrayQueue<>();
        this.robot_Gas_Queue = new ArrayQueue<>();
    }
    
    public void classifyCars(List<Car> cars) {
        for (Car car : cars) {

            if(car.get_isDining()!=true){
                isNotDining++;
            }
            else{
                isDining++;
            }
            if (car.getCarType() == Car.CarType.ELECTRIC) {
                if (car.hasPerson()) {
                    people_Ele_Queue.enqueue(car);
                } else {
                    robot_Ele_Queue.enqueue(car);
                }
            } else if (car.getCarType() == Car.CarType.GAS) {
                if (car.hasPerson()) {
                    people_Gas_Queue.enqueue(car);
                } else {
                    robot_Gas_Queue.enqueue(car);
                }
            }
        }
    }

    public Queue<Car> getPeopleEleQueue() {
        return people_Ele_Queue;
    }

    public Queue<Car> getRobotEleQueue() {
        return robot_Ele_Queue;
    }

    public Queue<Car> getPeopleGasQueue() {
        return people_Gas_Queue;
    }

    public Queue<Car> getRobotGasQueue() {
        return robot_Gas_Queue;
    }
    public int is_NotDining(){
        return isNotDining;
    }
    public int isDining(){
        return isDining;
    }
}
